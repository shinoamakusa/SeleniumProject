package shinoamakusa.selenium.pageobjects.autotrader.ca.results.filters;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.elements.ByLocator;
import shinoamakusa.selenium.core.elements.BaseElement;

public class PostalCodeFilter extends PageFilter {

	public PostalCodeFilter(BrowserDriver driver) {
		super(driver);
		this.locator = ByLocator.id("faceted-parent-Location");
	}

	public boolean isSelected(final String postalCode) {
		BaseElement container = driver.findByLocator(this.locator);
		return container.findByID("faceted-Location").getText().equalsIgnoreCase(postalCode);
	}

}
