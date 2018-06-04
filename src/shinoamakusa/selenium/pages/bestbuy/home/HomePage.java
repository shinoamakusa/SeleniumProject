package shinoamakusa.selenium.pages.bestbuy.home;

import org.openqa.selenium.WebDriverException;

import shinoamakusa.selenium.pages.BrowserPage;
import shinoamakusa.selenium.pages.bestbuy.results.ResultsPage;

public class HomePage extends BrowserPage {
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
		String searchBoxClass = "navigation-search-box";
		String searchBtnClass = "icon-search";

		if (isValidPage()) {

			try {

				driver.search(driver.findByClass(searchBoxClass), driver.findByClass(searchBtnClass), searchQuery);
			} catch (WebDriverException e) {
				checkForModal();
				searchFor(searchQuery);
			}

			return new ResultsPage(driver);
		}
		
		return null;

	}

	private void checkForModal() {
		driver.click(driver.findByClass("at-close-icon"));
	}

}
