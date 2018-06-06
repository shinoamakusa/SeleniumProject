package shinoamakusa.selenium.vpl;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import shinoamakusa.selenium.pageobjects.vpl.home.HomePage;
import shinoamakusa.selenium.pageobjects.vpl.results.ResultsPage;

public class BaseTest {
	protected HomePage homepage;

	protected final String query = "java";
	protected ResultsPage resultsPage;

	@AfterMethod
	public void after() {
		resultsPage.close();
	}

	@BeforeMethod
	public void before() {
		homepage = new HomePage();
		homepage.open();

		resultsPage = homepage.searchFor(query);
		assertTrue(resultsPage.searchResultsExist(), "There are no search results");
	}

}
