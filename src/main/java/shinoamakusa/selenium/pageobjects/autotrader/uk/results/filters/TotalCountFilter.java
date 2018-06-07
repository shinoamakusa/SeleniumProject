package shinoamakusa.selenium.pageobjects.autotrader.uk.results.filters;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.filters.BaseFilter;

public class TotalCountFilter extends BaseFilter {

	public TotalCountFilter(BrowserDriver driver) {
		this.driver = driver;
		this.container = driver.findByClass("search-form__count");
	}

	public boolean contains(String text) {
		return container.textContains(text);
	}

}
