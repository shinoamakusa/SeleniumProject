package shinoamakusa.selenium.autotrader.uk;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import javax.swing.SortOrder;

import org.testng.annotations.Test;

public class TotalPriceTest extends BaseTest {
	@Test(invocationCount = 1)
	public void totalPriceTest() {
		openHomepage();

		homepage.typePostalCode(postalCode);
		homepage.selectRadius(radius);
		homepage.selectNearlyNew(selectNearlyNew);
		homepage.selectNew(selectNew);
		homepage.selectMake(make);
		homepage.selectModel(model);
		homepage.selectTotalPrice();

		resultsPage = homepage.submitSearch();

		assertTrue(resultsPage.isLoaded());
		assertEquals(resultsPage.count(), homepage.count());
		assertEquals(resultsPage.radius(), radius);
		assertEquals(resultsPage.postalCode(), postalCode.replaceAll(" ", "").toLowerCase());
		assertEquals(resultsPage.make(), make);
		assertEquals(resultsPage.model().toUpperCase(), model);

		assertEquals(resultsPage.carFilters(), homepage.carFilters());

		resultsPage.selectTotalPriceLowest();
		assertTrue(resultsPage.isSortOrder(SortOrder.ASCENDING));

		closeBrowser();
	}

}
