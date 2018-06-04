package shinoamakusa.selenium.tests.autotrader;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import shinoamakusa.selenium.pages.autotrader.home.HomePage;
import shinoamakusa.selenium.pages.autotrader.results.ResultsPage;

public class SearchTest extends BaseTest {

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
}
