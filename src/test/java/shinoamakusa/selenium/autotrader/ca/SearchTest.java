package shinoamakusa.selenium.autotrader.ca;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

	@Test
	public void searchTest() {
		String make = "Audi";
		String model = "A4";
		String price = "100000";
		String postalCode = "V5Y 1V4";
		
		openHomepage();

		resultsPage = homepage.search(make, model, price, postalCode);
		
		
		assertTrue(resultsPage.isLoaded());
		assertTrue(resultsPage.hasResults());
		assertEquals(resultsPage.make(), make);
		assertEquals(resultsPage.model(), model);
		assertEquals(resultsPage.postalCode(), postalCode);
		
		closeBrowser();
	}
}
