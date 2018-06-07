package shinoamakusa.selenium.pageobjects.autotrader.uk.home.filters;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.elements.ByLocator;
import shinoamakusa.selenium.core.elements.PageElement;
import shinoamakusa.selenium.core.filters.BaseFilter;

public class PostalCodeFilter extends BaseFilter {
	public PostalCodeFilter(BrowserDriver driver) {
		this.driver = driver;
		this.locator = ByLocator.name("postcode");
	}

	public void enterValue(String value) {
		PageElement container = driver.findByLocator(this.locator);
		driver.typeInto(container, value);
	}

}
