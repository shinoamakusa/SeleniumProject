package shinoamakusa.selenium.pageobjects.bestbuy.results;

import org.openqa.selenium.By;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.elements.ByLocator;
import shinoamakusa.selenium.core.elements.PageElement;
import shinoamakusa.selenium.core.pages.BasePage;

public class ResultsPage extends BasePage {
	private static final By BB_ONLY_TAB_LOCATOR = ByLocator.id("at-BBY-only");
	private static final By BB_MARKET_TAB_LOCATOR = ByLocator.id("at-BBY-MP");

	private static final By BB_MARKET_COUNT_LOCATOR = ByLocator.id("at-BBYMP-item-count");
	private static final By BB_ONLY_COUNT_LOCATOR = ByLocator.id("at-BBY-item-count");

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
				PageElement element = driver.findByAttribute("data-value", Integer.toString(option));
				int numPosts = Integer.parseInt(element.getText());
				driver.click(element);
				passed = PageElement.elementCountEquals(ByLocator.className("listing-item"), numPosts);
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
			selectedTabCountLocator = BB_MARKET_COUNT_LOCATOR;

	}

	/**
	 * Selects "Best Buy & Only" tab
	 */
	public void selectBBOnlyTab() {
		if (selectBBTab(2))
			selectedTabCountLocator = BB_ONLY_COUNT_LOCATOR;

	}

	private boolean selectBBTab(final int num) {
		driver.click(driver.findByLocator(TAB_LOCATOR, num));
		PageElement tab = new PageElement();
		switch (num) {
		case 1:
			tab = driver.findByLocator(BB_MARKET_TAB_LOCATOR);
			break;
		case 2:
			tab = driver.findByLocator(BB_ONLY_TAB_LOCATOR);
			break;
		}
		return tab.hasAttribute("class", "active");
	}

}
