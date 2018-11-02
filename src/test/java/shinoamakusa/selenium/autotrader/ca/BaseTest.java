package shinoamakusa.selenium.autotrader.ca;

import static org.testng.Assert.assertTrue;

import shinoamakusa.selenium.pageobjects.autotrader.ca.home.HomePage;
import shinoamakusa.selenium.pageobjects.autotrader.ca.results.ResultsPage;

public class BaseTest {
	protected HomePage homepage;
	protected ResultsPage resultsPage;
	
	public void closeBrowser() {
		resultsPage.close();
	}

	public void openHomepage() {
		homepage = new HomePage();
		homepage.open();
		assertTrue(homepage.isLoaded());
	}

}
