package main.java.shinoamakusa.selenium.pages.autotrader.uk.results.filters;

import main.java.shinoamakusa.selenium.core.drivers.BrowserDriver;
import main.java.shinoamakusa.selenium.core.elements.SelectElement;

public class RadiusFilter extends PageFilter {

	public RadiusFilter(BrowserDriver driver) {
		this.driver = driver;
		this.container = driver.findByName("radius");
	}

	public boolean isSelected(final String radius) {
		return new SelectElement(container).getSelectedOption().getAttribute("value").equalsIgnoreCase(radius);
	}

}
