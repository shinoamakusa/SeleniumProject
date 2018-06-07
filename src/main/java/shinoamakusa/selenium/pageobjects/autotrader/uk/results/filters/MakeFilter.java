package shinoamakusa.selenium.pageobjects.autotrader.uk.results.filters;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.filters.BaseFilter;

public class MakeFilter extends BaseFilter {
	public MakeFilter(BrowserDriver driver) {
		this.driver = driver;
		this.container = driver.findByAttribute("data-button-for", "make");
	}

	public boolean isSelected(final String make) {
		return container.findByClass("options-button__value").getText().equalsIgnoreCase(make);
	}

}
