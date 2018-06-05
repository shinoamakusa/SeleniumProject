package test.java.shinoamakusa.selenium.autotrader.ca;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import main.java.shinoamakusa.selenium.pages.autotrader.ca.home.HomePage;
import main.java.shinoamakusa.selenium.pages.autotrader.ca.results.ResultsPage;

public class BaseTest {
	protected HomePage homepage;
	protected ResultsPage resultsPage;
	
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

}
