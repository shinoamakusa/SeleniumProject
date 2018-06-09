package shinoamakusa.selenium.pageobjects.vpl.results;

import org.openqa.selenium.By;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.elements.ByLocator;
import shinoamakusa.selenium.core.elements.PageElement;
import shinoamakusa.selenium.core.pages.BasePage;
import shinoamakusa.selenium.pageobjects.vpl.details.DetailsPage;

public class ResultsPage extends BasePage {

	private static final By BROADEN_SEARCH_LINK_LOCATOR = ByLocator.className("extendSearch");
	private static final By ITEM_AUTHOR_LOCATOR = ByLocator.attribute("testid", "author_search");
	private static final By ITEM_LOCATOR = ByLocator.className("listItem");

	private static final By ITEM_SUBTITLE_LOCATOR = ByLocator.className("subTitle");
	private static final By ITEM_TITLE_LOCATOR = ByLocator.attribute("testid", "bib_link");

	private static final By ITEMS_COUNT_LOCATOR = ByLocator.className("items_showing_count");
	
	public String author;
	public String itemTitle;
	public String subtitle;

	public ResultsPage(BrowserDriver driver) {
		this.driver = driver;
		this.urlPart = "vpl.bibliocommons.com";
		this.title = this.driver.getTitle();
	}

	public ResultsPage broadenSearch() {
		driver.click(driver.findByLocator(BROADEN_SEARCH_LINK_LOCATOR));
		return new ResultsPage(driver);

	}

	public void getResultInfo(int num) {
		PageElement element = driver.findByLocator(ITEM_LOCATOR, num);

		itemTitle = element.findByLocator(ITEM_TITLE_LOCATOR).getText().trim();

		subtitle = element.findByLocator(ITEM_SUBTITLE_LOCATOR).getText().trim();

		author = element.findByLocator(ITEM_AUTHOR_LOCATOR).getText().trim();
	}

	/**
	 * Gets search results count
	 * 
	 * @return Number of search results
	 */
	public int getResultsCount() {
		PageElement element = driver.findByLocator(ITEMS_COUNT_LOCATOR);
		String[] elementParts = element.getText().split(" ");
		return Integer.parseInt(elementParts[4]);
	}

	public DetailsPage goToFirstResult() {
		goToResult(1);
		return new DetailsPage(driver);
	}

	public boolean searchResultsExist() {
		return getResultsCount() > 0;
	}

	/**
	 * Follows the link of the first search result
	 */
	private void goToResult(int num) {
		
		PageElement element = driver.findByLocator(ITEM_LOCATOR, num);
		PageElement link = element.findByLocator(ITEM_TITLE_LOCATOR);

		driver.click(link);
	}

}
