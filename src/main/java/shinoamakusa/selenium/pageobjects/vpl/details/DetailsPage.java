package shinoamakusa.selenium.pageobjects.vpl.details;

import org.openqa.selenium.By;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.elements.ByLocator;
import shinoamakusa.selenium.core.elements.BaseElement;
import shinoamakusa.selenium.core.pages.BasePage;

public class DetailsPage extends BasePage {
	private static final By ITEM_AUTHOR_LOCATOR = ByLocator.attribute("testid", "author_search");
	private static final By ITEM_SUBTITLE_LOCATOR = ByLocator.attribute("testid", "text_bibsubtitle");
	private static final By ITEM_TITLE_LOCATOR = ByLocator.attribute("testid", "text_bibtitle");
	
	private static final By NEXT_ITEM_LINK = ByLocator.attribute("testid", "link_next");
	private static final By PREVIOUS_ITEM_LINK = ByLocator.attribute("testid", "link_prev");
	
	public String author;
	public String itemTitle;
	public String subtitle;

	public DetailsPage(BrowserDriver driver) {
		this.driver = driver;
		this.urlPart = driver.getUrl();
		this.title = driver.getTitle();
	}

	public void getDetails() {
		BaseElement element = driver.findByLocator(ITEM_TITLE_LOCATOR);
		itemTitle = element.getText().trim();

		element = driver.findByLocator(ITEM_SUBTITLE_LOCATOR);
		subtitle = element.getText().trim();

		element = driver.findByLocator(ITEM_AUTHOR_LOCATOR);
		author = element.getText().trim();
	}

	/**
	 * Follows the link to next item in details page pagination
	 */
	public DetailsPage goToNextItem() {
		BaseElement element = driver.findByLocator(NEXT_ITEM_LINK);
		if (element.webElement() == null)
			return null;
		driver.click(element);
		return new DetailsPage(driver);
	}

	/**
	 * Follows the link to previous item in details page pagination
	 */
	public DetailsPage goToPreviousItem() {
		BaseElement element = driver.findByLocator(PREVIOUS_ITEM_LINK);
		if (element.webElement() == null)
			return null;
		driver.click(element);
		return new DetailsPage(driver);
	}

	public boolean visitedBefore() {
		return driver.getHistory().contains(this.urlPart);
	}

}
