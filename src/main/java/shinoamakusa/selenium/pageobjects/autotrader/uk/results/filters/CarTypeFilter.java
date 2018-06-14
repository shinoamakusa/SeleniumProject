package shinoamakusa.selenium.pageobjects.autotrader.uk.results.filters;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.elements.BaseElement;
import shinoamakusa.selenium.core.filters.BaseFilter;

public class CarTypeFilter extends BaseFilter{
	
	public CarTypeFilter(BrowserDriver driver) {
		super(driver);
	}

	public boolean isSelected(final String make) {
		BaseElement container = driver.findByLocator(this.locator);
		return container.findByClass("options-button__value").getText().equalsIgnoreCase(make);
	}

	public String value() {
		BaseElement container = driver.findByLocator(this.locator);
		return container.findByClass("options-button__value").getText();
	}

}
