package shinoamakusa.selenium.pageobjects.autotrader.uk.results.filters;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.elements.ByLocator;

public class ModelFilter extends CarTypeFilter {
	public ModelFilter(BrowserDriver driver) {
		super(driver);
		this.locator = ByLocator.attribute("data-button-for", "model");
	}

}
