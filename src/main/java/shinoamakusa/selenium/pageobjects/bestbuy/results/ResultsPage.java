package shinoamakusa.selenium.pageobjects.bestbuy.results;

import org.openqa.selenium.By;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.elements.ByLocator;
import shinoamakusa.selenium.core.elements.BaseElement;
import shinoamakusa.selenium.core.pages.BasePage;

public class ResultsPage extends BasePage {
	private static final By BESTBUY_ONLY_TAB_LOCATOR = ByLocator.id("at-BBY-only");
	private static final By BESTBUY_MARKETPLACE_TAB_LOCATOR = ByLocator.id("at-BBY-MP");

	private static final By BESTBUY_MARKETPLACE_COUNT_LOCATOR = ByLocator.id("at-BBYMP-item-count");
	private static final By BESTBUY_ONLY_COUNT_LOCATOR = ByLocator.id("at-BBY-item-count");

	private static final By TAB_LOCATOR = ByLocator.className("ui-tab");
	private static final By TOTAL_COUNT_LOCATOR = ByLocator.className("display-total");

	private By selectedTabCountLocator;

	public ResultsPage(final BrowserDriver driver) {
		this.urlPart = "www.bestbuy.ca/en-CA/Search/SearchResults.aspx";
		this.driver = driver;
		this.title = this.driver.getTitle();
		this.url = this.driver.getUrl();

	}

	/**
	 * Checks that item counts in total items section and in selected tab are the
	 * same
	 */
	public boolean itemCountsEqual() {
		return driver.findByLocator(TOTAL_COUNT_LOCATOR)
				.textContains(driver.findByLocator(selectedTabCountLocator).getText().replaceAll("[()]", ""));
	}

	/**
	 * Performs a check that per page options on search results page work and load
	 * appropriate number of entries
	 */
	public boolean perPageOptionsWork() {
		try {

			boolean passed = false;
			int[] perPageOptions = { 32, 64, 96 };
			for (int option : perPageOptions) {
				BaseElement element = driver.findByAttribute("data-value", Integer.toString(option));
				int numPosts = Integer.parseInt(element.getText());
				driver.click(element);
				passed = BaseElement.elementCountEquals(ByLocator.className("listing-item"), numPosts);
			}

			return passed;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Selects "Best Buy & Marketplace" tab
	 */
	public void selectBBMarketTab() {
		if (selectBBTab(1))
			selectedTabCountLocator = BESTBUY_MARKETPLACE_COUNT_LOCATOR;

	}

	/**
	 * Selects "Best Buy & Only" tab
	 */
	public void selectBBOnlyTab() {
		if (selectBBTab(2))
			selectedTabCountLocator = BESTBUY_ONLY_COUNT_LOCATOR;

	}

	private boolean selectBBTab(final int num) {
		BaseElement element = driver.findByLocator(TAB_LOCATOR, num);
		driver.click(element);
		switch (num) {
		case 1:
			element = element.findByLocator(BESTBUY_MARKETPLACE_TAB_LOCATOR);
			break;
		case 2:
			element = element.findByLocator(BESTBUY_ONLY_TAB_LOCATOR);
			break;
		}
		return element.hasAttribute("class", "active");
	}

}
