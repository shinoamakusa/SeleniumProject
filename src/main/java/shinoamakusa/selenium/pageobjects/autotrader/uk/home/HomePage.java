package shinoamakusa.selenium.pageobjects.autotrader.uk.home;

import shinoamakusa.selenium.core.pages.BasePage;
import shinoamakusa.selenium.pageobjects.autotrader.uk.home.filters.HomeFilters;
import shinoamakusa.selenium.pageobjects.autotrader.uk.results.ResultsPage;

public class HomePage extends BasePage {

	private String searchCount;
	private HomeFilters filters;

	public HomePage() {
		this.urlPart = "autotrader.co.uk";
	}

	public String getSearchCount() {
		return searchCount;
	}

	public HomeFilters filters() {
		return filters;
	}

	public void open() {
		super.open();
		String homeUrl = new StringBuilder("https://").append(this.urlPart).toString();
		driver.goTo(homeUrl);
		this.title = driver.getTitle();
		filters = new HomeFilters(driver);

	}


	private void selectMake(final String make) {
		filters().make().select(make);
	}

	private void selectModel(final String model) {
		filters().model().select(model);
	}

	private void selectMonthlyPrice() {

		filters().monthlyPrice().select();
	}

	private void selectRadius(final String radius) {
		filters().radius().select(radius);
	}

	public ResultsPage submitSearch() {
		driver.waitFor(5);
		driver.select(driver.findByID("js-search-button"));
		if (driver.selectedElement().isClickable()) {
			searchCount = driver.selectedElement().getText().split(" ")[1];
			driver.click(driver.selectedElement());
		}
		return new ResultsPage(driver);
	}

	private void typePostalCode(String postalCode) {
		filters().postal().enterValue(postalCode);
	}

	private void uncheckNearlyNew() {
		filters().nearlyNewFilter().select(false);
	}

	private void uncheckNew() {
		filters().newFilter().select(false);

	}

}
