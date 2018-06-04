package shinoamakusa.selenium.tests.vpl;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

/**
 * Test Cases class
 * 
 * @author Oleg Kravenkov
 *
 */
public class BroadenSearch extends BaseTest {

	@Test
	public void broadenSearch() {
		int searchResultsCount = resultsPage.getResultsCount();

		resultsPage = resultsPage.broadenSearch();
		assertTrue(resultsPage.searchResultsExist(), "There are no search results");
		int broadSearchResultsCount = resultsPage.getResultsCount();

		assertTrue(broadSearchResultsCount > searchResultsCount,
				"Broad search results count is not greater than regular search results count");
	}
}
