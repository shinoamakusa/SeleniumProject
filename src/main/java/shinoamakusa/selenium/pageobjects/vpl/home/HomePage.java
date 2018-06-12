package shinoamakusa.selenium.pageobjects.vpl.home;

import org.openqa.selenium.By;

import shinoamakusa.selenium.core.elements.ByLocator;
import shinoamakusa.selenium.core.pages.BasePage;
import shinoamakusa.selenium.pageobjects.vpl.results.ResultsPage;

public class HomePage extends BasePage {
	private static final By SEARCH_BOX_LOCATOR = ByLocator.id("edit-search");
	private static final By SEARCH_BUTTON_LOCATOR = ByLocator.id("edit-submit");

	public HomePage() {
		this.partialURL = "vpl.ca";
	}

	public void open() {
		super.open();
		String homeUrl = new StringBuilder("https://").append(this.partialURL).toString();
		driver.goTo(homeUrl);
		this.title = driver.getTitle();

	}

	public ResultsPage searchFor(final String searchQuery) {

		driver.search(driver.findByLocator(SEARCH_BOX_LOCATOR).toTextInputElement(),
				driver.findByLocator(SEARCH_BUTTON_LOCATOR).toButtonElement(), searchQuery);

		return new ResultsPage(driver);

	}

}
