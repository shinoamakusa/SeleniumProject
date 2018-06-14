package shinoamakusa.selenium.pageobjects.autotrader.uk.home;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import shinoamakusa.selenium.core.elements.ButtonElement;
import shinoamakusa.selenium.core.elements.ByLocator;
import shinoamakusa.selenium.core.pages.BasePage;
import shinoamakusa.selenium.pageobjects.autotrader.uk.home.filters.HomeFilters;
import shinoamakusa.selenium.pageobjects.autotrader.uk.results.ResultsPage;

public class HomePage extends BasePage {

	private static final By SEARCH_BUTTON_LOCATOR = ByLocator.id("js-search-button");

	private HomeFilters filters;
	private String searchCount;
	private List<String> selectedCarFilters;

	public HomePage() {
		this.partialURL = "autotrader.co.uk";
	}

	public HomeFilters filters() {
		return filters;
	}

	public String count() {
		return searchCount;
	}

	public void open() {
		super.open();
		String homeUrl = new StringBuilder("https://").append(this.partialURL).toString();
		driver.goTo(homeUrl);
		this.title = driver.getTitle();
		this.url = this.driver.getUrl();
		filters = new HomeFilters(driver);
		selectedCarFilters = new ArrayList<String>();

	}

	public void selectMake(final String make) {
		// driver.waitFor(2);
		filters().make().select(make);
	}

	public void selectModel(final String model) {
		// driver.waitFor(2);
		filters().model().select(model);
	}

	public void selectMonthlyPrice() {

		filters().monthlyPrice().select();
	}

	public void selectTotalPrice() {

		filters().totalPrice().select();
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
		selectedCarFilters = filters().carFilters().getSelectedFilters();

		ButtonElement searchButton = driver.findByLocator(SEARCH_BUTTON_LOCATOR).toButtonElement();
		if (searchButton.textContains(filters().model().getCount()) && searchButton.isClickable()) {
			searchCount = searchButton.getText().split(" ")[1];
			driver.click(searchButton);
		}
		return new ResultsPage(driver);
	}

	public void typePostalCode(String postalCode) {
		filters().postal().enterValue(postalCode);
	}

	public List<String> carFilters() {
		return selectedCarFilters;
	}

}
