package shinoamakusa.selenium.pageobjects.autotrader.ca.results;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.pages.BasePage;
import shinoamakusa.selenium.pageobjects.autotrader.ca.results.filters.ResultsFilters;

public class ResultsPage extends BasePage {

	private ResultsFilters filters;
	private int lastTotalResults;

	public ResultsPage(final BrowserDriver driver) {
		this.urlPart = "autotrader.ca/cars";
		this.driver = driver;
		this.title = this.driver.getTitle();
		filters = new ResultsFilters(driver);
	}

	public ResultsFilters filters() {
		return this.filters;
	}
	
	public boolean hasResults() {
		lastTotalResults = filters.totalCount().getValue();
		return lastTotalResults > 0;
	}

	public boolean isYearCountLess() {

		return filters.totalCount().changedFrom(String.format("%,d", lastTotalResults))
				&& filters.totalCount().getValue() < lastTotalResults;

	}

	public boolean makeCountsEqual() {

		boolean countsEqual = filters.totalCount()
				.equalsTo(String.format("%,d", filters.make().getMenuOptionResultsCount()));

		if (countsEqual) {
			lastTotalResults = filters.make().getMenuOptionResultsCount();
		}
		return countsEqual;
	}

	public boolean modelCountsEqual() {

		boolean countsEqual = filters.totalCount()
				.equalsTo(String.format("%,d", filters.model().getMenuOptionResultsCount()));

		if (countsEqual) {
			lastTotalResults = filters.model().getMenuOptionResultsCount();
		}
		return countsEqual;
	}

}
