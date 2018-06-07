package shinoamakusa.selenium.pageobjects.autotrader.uk.home.filters;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.filters.BaseFilter;

public class PostalCodeFilter extends BaseFilter {
	public PostalCodeFilter(BrowserDriver driver) {
		this.driver = driver;
		this.container = driver.findByName("postcode");
	}

	public void enterValue(String value) {
		driver.typeInto(container, value);
	}

}
