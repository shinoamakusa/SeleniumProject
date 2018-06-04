package shinoamakusa.selenium.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import shinoamakusa.selenium.pages.bestbuy.home.HomePage;
import shinoamakusa.selenium.pages.bestbuy.results.ResultsPage;

public class BestBuy {

	private HomePage homepage;
	private final String query = "windows laptops";
	private ResultsPage resultsPage;

	@AfterMethod
	public void after() {
		assertTrue(resultsPage.itemCountsEqual());
		assertTrue(resultsPage.perPageOptionsWork());
		resultsPage.close();
	}

	@BeforeMethod
	public void before() {
		homepage = new HomePage();
		homepage.open();
		assertTrue(homepage.isValidPage());
		resultsPage = homepage.searchFor(query);
		assertTrue(resultsPage.isValidPage());
	}

	@Test
	public void SearchBestBuyAndMarketplace() {

		resultsPage.selectBBMarketTab();

	}

	@Test
	public void SearchBestBuyOnly() {

		resultsPage.selectBBOnlyTab();

	}
}
