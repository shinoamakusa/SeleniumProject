package shinoamakusa.selenium.pageobjects.autotrader.uk.results.filters;

import shinoamakusa.selenium.core.drivers.BrowserDriver;

public class TotalCountFilter extends PageFilter {

	public TotalCountFilter(BrowserDriver driver) {
		this.driver = driver;
		this.container = driver.findByClass("search-form__count");
	}

	public boolean contains(String text) {
		return container.textContains(text);
	}

}
