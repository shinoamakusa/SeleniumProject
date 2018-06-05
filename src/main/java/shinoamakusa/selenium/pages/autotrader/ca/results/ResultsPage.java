package main.java.shinoamakusa.selenium.pages.autotrader.ca.results;

import main.java.shinoamakusa.selenium.core.drivers.BrowserDriver;
import main.java.shinoamakusa.selenium.pages.BasePage;
import main.java.shinoamakusa.selenium.pages.autotrader.ca.results.filters.ResultsFilters;

public class ResultsPage extends BasePage {

	private int lastTotalResults;
	private ResultsFilters filters;

	public ResultsPage(final BrowserDriver driver) {
		this.urlPart = "autotrader.ca/cars";
		this.driver = driver;
		this.title = this.driver.getTitle();
		filters = new ResultsFilters(driver);
	}

	public boolean countsEqual() {

		boolean countsEqual = filters.count()
				.equalsTo(String.format("%,d", filters.getMenuResultsCount()));

		if (countsEqual) {
			lastTotalResults = filters.getMenuResultsCount();
		}
		return countsEqual;
	}

	public ResultsFilters filters() {
		return this.filters;
	}

	public boolean hasResults() {
		lastTotalResults = filters.count().getValue();
		return lastTotalResults > 0;
	}

	public boolean isCountLessThanPrevious() {

		return filters.count().changedFrom(String.format("%,d", lastTotalResults))
				&& filters.count().getValue() < lastTotalResults;

	}

}
