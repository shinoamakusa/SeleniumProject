package main.java.shinoamakusa.selenium.pages.autotrader.ca.results.filters;

import main.java.shinoamakusa.selenium.framework.drivers.BrowserDriver;

public class PostalCodeFilter extends PageFilter {

	public PostalCodeFilter(BrowserDriver driver) {
		this.driver = driver;
	}

	public boolean isSelected(final String postalCode) {
		return driver.findByID("faceted-Location").getText().equalsIgnoreCase(postalCode);
	}

}
