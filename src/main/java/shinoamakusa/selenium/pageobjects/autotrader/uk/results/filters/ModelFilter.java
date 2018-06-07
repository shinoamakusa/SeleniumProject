package shinoamakusa.selenium.pageobjects.autotrader.uk.results.filters;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.filters.BaseFilter;

public class ModelFilter extends BaseFilter {
	public ModelFilter(BrowserDriver driver) {
		this.driver = driver;
		this.container = driver.findByAttribute("data-button-for", "model");
	}

	public boolean isSelected(final String model) {
		return container.findByClass("options-button__value").getText().equalsIgnoreCase(model);
	}

}
