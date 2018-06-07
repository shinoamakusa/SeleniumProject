package shinoamakusa.selenium.pageobjects.autotrader.uk.home;

import org.openqa.selenium.By;

import shinoamakusa.selenium.core.elements.ByLocator;
import shinoamakusa.selenium.core.pages.BasePage;
import shinoamakusa.selenium.pageobjects.autotrader.uk.home.filters.HomeFilters;
import shinoamakusa.selenium.pageobjects.autotrader.uk.results.ResultsPage;

public class HomePage extends BasePage {

	private HomeFilters filters;
	private String searchCount;

	public HomePage() {
		this.urlPart = "autotrader.co.uk";
	}

	public HomeFilters filters() {
		return filters;
	}

	public String getSearchCount() {
		return searchCount;
	}

	public void open() {
		super.open();
		String homeUrl = new StringBuilder("https://").append(this.urlPart).toString();
		driver.goTo(homeUrl);
		this.title = driver.getTitle();
		filters = new HomeFilters(driver);

	}

	public void selectMake(final String make) {
		filters().make().select(make);
	}

	public void selectModel(final String model) {
		filters().model().select(model);
	}

	public void selectMonthlyPrice() {

		filters().monthlyPrice().select();
	}

	public void selectNearlyNew(final boolean state) {
		filters().carFilters().nearlyNewFilter().select(state);
	}

	public void selectNew(final boolean state) {
		filters().carFilters().newFilter().select(state);

	}

	public void selectRadius(final String radius) {
		filters().radius().select(radius);
	}

	public ResultsPage submitSearch() {
		//driver.waitFor(5);
		By locator = ByLocator.id("js-search-button");
		driver.select(driver.findByLocator(locator));
		if (driver.selectedElement().hasUpdated() && driver.selectedElement().isClickable()) {
			searchCount = driver.selectedElement().getText().split(" ")[1];
			driver.click(driver.selectedElement());
		}
		return new ResultsPage(driver);
	}

	public void typePostalCode(String postalCode) {
		filters().postal().enterValue(postalCode);
	}

}
