package shinoamakusa.selenium.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import shinoamakusa.selenium.pages.vpl.details.DetailsPage;
import shinoamakusa.selenium.pages.vpl.home.HomePage;
import shinoamakusa.selenium.pages.vpl.results.ResultsPage;

/**
 * Test Cases class
 * 
 * @author Oleg Kravenkov
 *
 */
public class VPL {

	private HomePage homepage;

	private final String query = "java";
	private ResultsPage resultsPage;

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

	@Test
	public void BroadenSearch() {
		int searchResultsCount = resultsPage.getResultsCount();

		resultsPage = resultsPage.broadenSearch();
		assertTrue(resultsPage.searchResultsExist(), "There are no search results");
		int broadSearchResultsCount = resultsPage.getResultsCount();

		assertTrue(broadSearchResultsCount > searchResultsCount,
				"Broad search results count is not greater than regular search results count");
	}

	@Test
	public void DetailsInfoCheck() {
		resultsPage.getResultInfo(1);
		DetailsPage detailsPage = resultsPage.goToFirstResult();
		detailsPage.getDetails();
		assertTrue(
				(resultsPage.itemTitle.equalsIgnoreCase(detailsPage.itemTitle))
						&& (resultsPage.subtitle.equalsIgnoreCase(detailsPage.subtitle))
						&& (resultsPage.author.equalsIgnoreCase(detailsPage.author)),
				"Item information on the results and details pages is not the same");
	}

	@Test
	public void DetailsNavigationCheck() {
		DetailsPage detailsPage = resultsPage.goToFirstResult();

		detailsPage = detailsPage.goToNextItem();
		assertTrue(detailsPage != null);
		detailsPage = detailsPage.goToNextItem();
		assertTrue(detailsPage != null);

		detailsPage = detailsPage.goToPreviousItem();
		assertTrue(detailsPage != null);
		assertTrue(detailsPage.visitedBefore(), "Previous link page was not visited before");
		detailsPage = detailsPage.goToPreviousItem();
		assertTrue(detailsPage != null);
		assertTrue(detailsPage.visitedBefore(), "Previous link page was not visited before");

	}
}
