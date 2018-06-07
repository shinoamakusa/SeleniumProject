package shinoamakusa.selenium.pageobjects.autotrader.uk.results.filters;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.elements.ByLocator;
import shinoamakusa.selenium.core.elements.PageElement;
import shinoamakusa.selenium.core.filters.BaseFilter;

public class TotalCountFilter extends BaseFilter {

	public TotalCountFilter(BrowserDriver driver) {
		this.driver = driver;
		this.locator = ByLocator.className("search-form__count");
	}

	public boolean contains(String text) {
		PageElement container = driver.findByLocator(this.locator);
		return container.textContains(text);
	}

}
