package shinoamakusa.selenium.pageobjects.autotrader.ca.results.filters;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.elements.ByLocator;
import shinoamakusa.selenium.core.elements.PageElement;

public class PostalCodeFilter extends PageFilter {

	public PostalCodeFilter(BrowserDriver driver) {
		this.driver = driver;
		this.locator = ByLocator.id("faceted-parent-Location");
	}

	public boolean isSelected(final String postalCode) {
		PageElement container = driver.findByLocator(this.locator);
		return container.findByID("faceted-Location").getText().equalsIgnoreCase(postalCode);
	}

}
