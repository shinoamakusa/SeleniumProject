package main.java.shinoamakusa.selenium.pages.autotrader.ca.results;

import main.java.shinoamakusa.selenium.framework.drivers.BrowserDriver;
import main.java.shinoamakusa.selenium.pages.BrowserPage;
import main.java.shinoamakusa.selenium.pages.autotrader.ca.results.filters.ResultsFilters;

public class ResultsPage extends BrowserPage {

	private int lastTotalResults;
	private ResultsFilters resultsFilters;
	public ResultsPage(final BrowserDriver driver) {
		this.urlPart = "autotrader.ca/cars";
		this.driver = driver;
		this.title = this.driver.getTitle();
		resultsFilters = new ResultsFilters(driver);
	}

	public boolean countsEqual() {

			boolean countsEqual = driver.findByID("sbCount")
					.textContains(String.format("%,d", resultsFilters.getMenuResultsCount()));

			if (countsEqual) {
				lastTotalResults = resultsFilters.getMenuResultsCount();
			}
			return countsEqual;
	}

	public ResultsFilters filters() {
		return this.resultsFilters;
	}

	public boolean hasResults() {
		lastTotalResults = getResultsCount();
		return lastTotalResults > 0;
	}

	public boolean isCountFiltered() {

			return driver.findByID("sbCount").textNotEqual(String.format("%,d", lastTotalResults))
					&& getResultsCount() < lastTotalResults;

	}

	private int getResultsCount() {
			return Integer.parseInt(driver.findByID("sbCount").getText().replaceAll(",", ""));
	}

}
