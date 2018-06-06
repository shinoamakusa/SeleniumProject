package main.java.shinoamakusa.selenium.pages.autotrader.uk.results.filters;

import main.java.shinoamakusa.selenium.core.drivers.BrowserDriver;

public class RadiusFilter extends BaseFilter {
	
	public RadiusFilter(BrowserDriver driver) {
		this.driver = driver;
		this.container = driver.findByName("radius");
	}
	
	public boolean isSelected(final String radius) {
		return container.getSelectedOption().getAttribute("value").equalsIgnoreCase(radius);
	}

}
