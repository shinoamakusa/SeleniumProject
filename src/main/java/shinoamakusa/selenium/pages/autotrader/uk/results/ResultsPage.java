package main.java.shinoamakusa.selenium.pages.autotrader.uk.results;

import main.java.shinoamakusa.selenium.core.drivers.BrowserDriver;
import main.java.shinoamakusa.selenium.pages.BasePage;
import main.java.shinoamakusa.selenium.pages.autotrader.uk.results.filters.ResultsFilters;

public class ResultsPage extends BasePage {

	private ResultsFilters filters;

	public ResultsPage(final BrowserDriver driver) {
		this.urlPart = "autotrader.co.uk/car-search";
		this.driver = driver;
		this.title = this.driver.getTitle();
		filters = new ResultsFilters(driver);
		closeModal();
	}

	public ResultsFilters filters() {
		return filters;
	}
	
	private void closeModal()
	{
		driver.click(driver.findByID("buttonno"));
	}

}
