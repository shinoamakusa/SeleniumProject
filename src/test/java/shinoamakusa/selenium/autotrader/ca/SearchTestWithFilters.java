package shinoamakusa.selenium.autotrader.ca;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class SearchTestWithFilters extends BaseTest {

	@Test(invocationCount = 1)
	public void searchWithFilters() {
		String postalCode = "V5Y 1V4";
		String make = "Ford";
		String model = "Mustang";
		String maxYear = "2016";
		
		openHomepage();

		resultsPage = homepage.search(postalCode);
		assertTrue(resultsPage.isLoaded());
		assertTrue(resultsPage.hasResults());
		assertEquals(resultsPage.postalCode(), postalCode);

		resultsPage.changeMakeTo(make);
		assertTrue(resultsPage.makeCountsEqual());
		assertEquals(resultsPage.make(), make);

		resultsPage.changeModelTo(model);
		assertTrue(resultsPage.modelCountsEqual());
		assertEquals(resultsPage.model(), model);

		resultsPage.changeMaxYearTo(maxYear);
		assertTrue(resultsPage.isYearCountLess());
		assertEquals(resultsPage.maxYear(), maxYear);
		
		closeBrowser();
	}

}
