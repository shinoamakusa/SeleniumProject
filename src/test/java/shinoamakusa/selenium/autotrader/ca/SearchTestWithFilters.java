package test.java.shinoamakusa.selenium.autotrader.ca;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class SearchTestWithFilters extends BaseTest {

	@Test(invocationCount = 1)
	public void searchWithFilters() {
		String postalCode = "V5Y 1V4";
		String make = "Ford";
		String model = "Mustang";
		String maxYear = "2016";

		resultsPage = homepage.search(postalCode);
		assertTrue(resultsPage.isValidPage());
		assertTrue(resultsPage.hasResults());
		assertTrue(resultsPage.filters().postalCode().isSelected(postalCode));

		resultsPage.filters().make().change(make);
		assertTrue(resultsPage.countsEqual());
		assertTrue(resultsPage.filters().make().isSelected(make));

		resultsPage.filters().model().change(model);
		assertTrue(resultsPage.countsEqual());
		assertTrue(resultsPage.filters().model().isSelected(model));

		resultsPage.filters().year().changeMax(maxYear);
		assertTrue(resultsPage.isCountFiltered());
		assertTrue(resultsPage.filters().year().isSelected(maxYear));
	}

}
