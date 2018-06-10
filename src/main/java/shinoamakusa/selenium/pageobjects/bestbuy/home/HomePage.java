package shinoamakusa.selenium.pageobjects.bestbuy.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;

import shinoamakusa.selenium.core.elements.ByLocator;
import shinoamakusa.selenium.core.pages.BasePage;
import shinoamakusa.selenium.pageobjects.bestbuy.results.ResultsPage;

public class HomePage extends BasePage {
	private static final By SEARCH_BOX_LOCATOR = ByLocator.className("navigation-search-box");
	private static final By SEARCH_BUTTON_LOCATOR = ByLocator.className("icon-search");

	private static final By MODAL_CLOSE_BUTTON_LOCATOR = ByLocator.className("at-close-icon");

	public HomePage() {
		this.urlPart = "www.bestbuy.ca";
	}

	public void open() {
		super.open();
		String homeUrl = new StringBuilder("https://").append(this.urlPart).toString();
		driver.goTo(homeUrl);
		this.title = driver.getTitle();

	}

	public ResultsPage searchFor(final String searchQuery) {
		if (isValidPage()) {
			try {
				driver.search(driver.findByLocator(SEARCH_BOX_LOCATOR).toTextInputElement(),
						driver.findByLocator(SEARCH_BUTTON_LOCATOR).toButtonElement(), searchQuery);
			} catch (WebDriverException e) {
				checkForModal();
				searchFor(searchQuery);
			}
			return new ResultsPage(driver);
		}
		return null;

	}

	private void checkForModal() {
		driver.click(driver.findByLocator(MODAL_CLOSE_BUTTON_LOCATOR));
	}

}
