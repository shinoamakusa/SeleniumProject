package shinoamakusa.selenium.autotrader.uk;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class SearchByMonthlyPriceTest extends BaseTest {

	@Test(invocationCount = 10)
	public void searchByMonthlyPriceTest() {

		String postalCode = "M15 4FN";
		String radius = "50";
		String make = "BMW";
		String model = "3 SERIES";

		homepage.filters().postal().enterValue(postalCode);
		homepage.filters().radius().select(radius);
		homepage.filters().nearlyNewFilter().select(false);
		homepage.filters().newFilter().select(false);
		homepage.filters().make().select(make);
		homepage.filters().model().select(model);
		homepage.filters().monthlyPrice().select();

		resultsPage = homepage.submitSearch();

		assertTrue(resultsPage.isValidPage());
		assertTrue(resultsPage.filters().countFilter().contains(homepage.getSearchCount()));
		assertTrue(resultsPage.filters().radius().isSelected(radius));
		assertTrue(resultsPage.filters().postal().isSelected(postalCode));
		assertTrue(resultsPage.filters().make().isSelected(make));
		assertTrue(resultsPage.filters().model().isSelected(model));

		resultsPage.filters().sortFilter().select("monthly-price-desc");
		assertTrue(resultsPage.checkSortingOrder(true));

	}

}
