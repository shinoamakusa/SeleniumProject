package shinoamakusa.selenium.pageobjects.autotrader.ca.results.filters;

import shinoamakusa.selenium.core.drivers.BrowserDriver;

public class PostalCodeFilter extends PageFilter {

	public PostalCodeFilter(BrowserDriver driver) {
		this.driver = driver;
		this.container = driver.findByID("faceted-parent-Location");
	}

	public boolean isSelected(final String postalCode) {
		return container.findByID("faceted-Location").getText().equalsIgnoreCase(postalCode);
	}

}
