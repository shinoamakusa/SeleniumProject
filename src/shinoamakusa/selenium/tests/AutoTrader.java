package shinoamakusa.selenium.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import shinoamakusa.selenium.pages.autotrader.home.HomePage;
import shinoamakusa.selenium.pages.autotrader.results.ResultsPage;

public class AutoTrader {

	private HomePage homepage;
	private ResultsPage resultsPage;

	@AfterMethod
	public void after() {
		resultsPage.close();
	}

	@BeforeMethod
	public void before() {
		homepage = new HomePage();
		homepage.open();
		assertTrue(homepage.isValidPage());
	}

	@Test
	public void searchTest() {
		String make = "Audi";
		String model = "A4";
		String price = "100000";
		String postalCode = "V5Y 1V4";

		resultsPage = homepage.search(make, model, price, postalCode);
		assertTrue(resultsPage.isValidPage());
		assertTrue(resultsPage.hasResults());
		assertTrue(resultsPage.filters().contain(make, model, postalCode));
	}

	@Test(invocationCount = 1)
	public void searchWithFilters() {
		String postalCode = "V5Y 1V4";
		String make = "Ford";
		String model = "Mustang";
		String maxYear = "2016";

		resultsPage = homepage.search(postalCode);
		assertTrue(resultsPage.isValidPage());
		assertTrue(resultsPage.hasResults());
		assertTrue(resultsPage.filters().postalCode().isSelected(postalCode));

		resultsPage.filters().make().change(make);
		assertTrue(resultsPage.countsEqual());
		assertTrue(resultsPage.filters().make().isSelected(make));

		resultsPage.filters().model().change(model);
		assertTrue(resultsPage.countsEqual());
		assertTrue(resultsPage.filters().model().isSelected(model));

		resultsPage.filters().year().changeMax(maxYear);
		assertTrue(resultsPage.isCountFiltered());
		assertTrue(resultsPage.filters().year().isSelected(maxYear));
	}
}
