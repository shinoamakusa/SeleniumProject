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

		boolean selectNew = false;
		boolean selectNearlyNew = false;

		homepage.typePostalCode(postalCode);
		homepage.selectRadius(radius);
		homepage.selectNearlyNew(selectNearlyNew);
		homepage.selectNew(selectNew);
		homepage.selectMake(make);
		homepage.selectModel(model);
		homepage.selectMonthlyPrice();

		resultsPage = homepage.submitSearch();

		assertTrue(resultsPage.isValidPage());
		assertTrue(resultsPage.countContains(homepage.getSearchCount()));
		assertTrue(resultsPage.isRadiusSelected(radius));
		assertTrue(resultsPage.isPostalCode(postalCode));
		assertTrue(resultsPage.isMakeSelected(make));
		assertTrue(resultsPage.isModelSelected(model));

		resultsPage.selectMonthlySortDesc();
		assertTrue(resultsPage.sortOrderValid(true));

	}

}
