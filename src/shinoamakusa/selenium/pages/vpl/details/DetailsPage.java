package shinoamakusa.selenium.pages.vpl.details;

import shinoamakusa.selenium.framework.drivers.BrowserDriver;
import shinoamakusa.selenium.pages.BrowserPage;

public class DetailsPage extends BrowserPage {
	public String author;
	public String itemTitle;
	public String subtitle;

	public DetailsPage(BrowserDriver driver) {
		this.driver = driver;
		this.urlPart = driver.getUrl();
		this.title = driver.getTitle();
	}

	public void getDetails() {
		driver.select(driver.findByAttribute("testid", "text_bibtitle"));
		itemTitle = driver.getSelectedElement().getText().trim();

		driver.select(driver.findByAttribute("testid", "text_bibsubtitle"));
		subtitle = driver.getSelectedElement().getText().trim();

		driver.select(driver.findByAttribute("testid", "author_search"));
		author = driver.getSelectedElement().getText().trim();
	}

	/**
	 * Follows the link to next item in details page pagination
	 */
	public DetailsPage goToNextItem() {
		driver.select(driver.findByAttribute("testid", "link_next"));
		if (driver.getSelectedElement() == null)
			return null;
		driver.click(driver.getSelectedElement());
		return new DetailsPage(driver);
	}

	/**
	 * Follows the link to previous item in details page pagination
	 */
	public DetailsPage goToPreviousItem() {
		driver.select(driver.findByAttribute("testid", "link_prev"));
		if (driver.getSelectedElement() == null)
			return null;
		driver.click(driver.getSelectedElement());
		return new DetailsPage(driver);
	}

	public boolean visitedBefore() {
		return driver.getHistory().contains(this.urlPart);
	}

}
