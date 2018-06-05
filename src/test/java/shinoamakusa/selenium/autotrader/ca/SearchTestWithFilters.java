package test.java.shinoamakusa.selenium.autotrader.ca;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class SearchTestWithFilters extends BaseTest {

	@Test(invocationCount = 20)
	public void searchWithFilters() {
		String postalCode = "V5Y 1V4";
		String make = "Ford";
		String model = "Mustang";
		String maxYear = "2016";

		resultsPage = homepage.search(postalCode);
		assertTrue(resultsPage.isValidPage());
		assertTrue(resultsPage.hasResults());
		assertTrue(resultsPage.filters().postalCode().isSelected(postalCode));

		resultsPage.filters().make().changeTo(make);
		assertTrue(resultsPage.makeCountsEqual());
		assertTrue(resultsPage.filters().make().isSelected(make));

		resultsPage.filters().model().changeTo(model);
		assertTrue(resultsPage.modelCountsEqual());
		assertTrue(resultsPage.filters().model().isSelected(model));

		resultsPage.filters().year().changeMaxTo(maxYear);
		assertTrue(resultsPage.isYearCountLess());
		assertTrue(resultsPage.filters().year().isSelected(maxYear));
	}

}
