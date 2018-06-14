package shinoamakusa.selenium.autotrader.uk;

import static org.testng.Assert.assertTrue;

import shinoamakusa.selenium.pageobjects.autotrader.uk.home.HomePage;
import shinoamakusa.selenium.pageobjects.autotrader.uk.results.ResultsPage;

public class BaseTest {
	protected HomePage homepage;
	protected final String make = "BMW";
	
	protected final String model = "3 SERIES";
	protected final String postalCode = "M15 4FN";
	protected final String radius = "50";
	protected ResultsPage resultsPage;

	protected final boolean selectNearlyNew = false;
	protected final boolean selectNew = false;
	
	public void closeBrowser() {
		resultsPage.close();
	}

	public void openHomepage() {
		homepage = new HomePage();
		homepage.open();
		assertTrue(homepage.isLoaded());
	}

}
