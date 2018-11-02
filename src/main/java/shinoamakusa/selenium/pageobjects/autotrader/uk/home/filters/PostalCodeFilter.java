package shinoamakusa.selenium.pageobjects.autotrader.uk.home.filters;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.elements.ByLocator;
import shinoamakusa.selenium.core.elements.TextInputElement;
import shinoamakusa.selenium.core.filters.BaseFilter;

public class PostalCodeFilter extends BaseFilter {
	public PostalCodeFilter(BrowserDriver driver) {
		super(driver);
		this.locator = ByLocator.name("postcode");
	}

	public void enterValue(final String value) {
		TextInputElement container = driver.findByLocator(this.locator).toTextInputElement();
		driver.typeInto(container, value);
	}

}
