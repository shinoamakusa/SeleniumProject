package shinoamakusa.selenium.autotrader.uk;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class SearchByMonthlyPriceTest extends BaseTest {

	@Test(invocationCount = 1)
	public void searchByMonthlyPriceTest() {

		String postalCode = "M15 4FN";
		String radius = "50";
		String make = "BMW";
		String model = "3 SERIES";

		resultsPage = homepage.search(postalCode, radius, make, model);
		assertTrue(resultsPage.isValidPage());
		assertTrue(resultsPage.filters().countFilter().contains(homepage.getSearchCount()));
		assertTrue(resultsPage.filters().radius().isSelected(radius));
		assertTrue(resultsPage.filters().postal().isSelected(postalCode));

	}

}
