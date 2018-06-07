package shinoamakusa.selenium.pageobjects.autotrader.uk.results.filters;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.elements.PageElement;
import shinoamakusa.selenium.core.elements.ByLocator;
import shinoamakusa.selenium.core.filters.BaseFilter;

public class ModelFilter extends BaseFilter {
	public ModelFilter(BrowserDriver driver) {
		this.driver = driver;
		this.locator = ByLocator.attribute("data-button-for", "model");
	}

	public boolean isSelected(final String model) {
		PageElement container = driver.findByLocator(this.locator);
		return container.findByClass("options-button__value").getText().equalsIgnoreCase(model);
	}

}
