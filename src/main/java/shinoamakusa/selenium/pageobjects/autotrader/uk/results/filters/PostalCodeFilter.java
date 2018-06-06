package main.java.shinoamakusa.selenium.pageobjects.autotrader.uk.results.filters;

import main.java.shinoamakusa.selenium.core.drivers.BrowserDriver;
import main.java.shinoamakusa.selenium.core.elements.SelectElement;

public class PostalCodeFilter extends PageFilter {

	public PostalCodeFilter(BrowserDriver driver) {
		this.driver = driver;
		this.container = driver.findByID("postcode");
	}

	public boolean isSelected(final String code) {
		String text = code.replaceAll(" ", "").toLowerCase();
		return container.getAttribute("value").equalsIgnoreCase(text);
	}

}
