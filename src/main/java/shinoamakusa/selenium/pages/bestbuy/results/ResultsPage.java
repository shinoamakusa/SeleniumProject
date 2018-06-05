package main.java.shinoamakusa.selenium.pages.bestbuy.results;

import main.java.shinoamakusa.selenium.core.drivers.BrowserDriver;
import main.java.shinoamakusa.selenium.core.elements.ElementLocator;
import main.java.shinoamakusa.selenium.core.elements.PageElement;
import main.java.shinoamakusa.selenium.pages.BasePage;

public class ResultsPage extends BasePage {

	public ResultsPage(final BrowserDriver driver) {
		this.urlPart = "www.bestbuy.ca/en-CA/Search/SearchResults.aspx";
		this.driver = driver;
		this.title = this.driver.getTitle();
	}

	/**
	 * Checks that item counts in total items section and in selected tab are the
	 * same
	 */
	public boolean itemCountsEqual() {
		return PageElement.textContains(ElementLocator.byClass("display-total"),
				driver.selectedElement().getText().replaceAll("[()]", ""));
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
				passed = PageElement.elementCountEquals(ElementLocator.byClass("listing-item"), numPosts);
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
			driver.select(driver.findByID("at-BBYMP-item-count"));

	}

	/**
	 * Selects "Best Buy & Only" tab
	 */
	public void selectBBOnlyTab() {
		if (selectBBTab(2))
			driver.select(driver.findByID("at-BBY-item-count"));

	}

	private boolean selectBBTab(final int num) {
		driver.click(driver.findByClass("ui-tab", num));
		return driver.findByClass("ui-tab", num).hasAttribute("class", "active");
	}

}
