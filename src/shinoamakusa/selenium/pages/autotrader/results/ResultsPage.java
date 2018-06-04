package shinoamakusa.selenium.pages.autotrader.results;

import shinoamakusa.selenium.framework.drivers.BrowserDriver;
import shinoamakusa.selenium.framework.elements.ElementLocator;
import shinoamakusa.selenium.framework.elements.PageElement;
import shinoamakusa.selenium.pages.BrowserPage;
import shinoamakusa.selenium.pages.autotrader.results.filters.ResultsFilters;

public class ResultsPage extends BrowserPage {

	private int lastTotalResults;
	private ResultsFilters resultsFilters;
	private boolean surveyRemoved;

	public ResultsPage(final BrowserDriver driver) {
		this.urlPart = "autotrader.ca/cars";
		this.driver = driver;
		this.title = this.driver.getTitle();
		surveyRemoved = false;
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
