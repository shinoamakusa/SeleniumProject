package shinoamakusa.selenium.pageobjects.autotrader.uk.results;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.pages.BasePage;
import shinoamakusa.selenium.pageobjects.autotrader.uk.results.filters.ResultsFilters;

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
