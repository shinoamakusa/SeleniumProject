package shinoamakusa.selenium.pageobjects.autotrader.uk.results.filters;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.elements.SelectElement;
import shinoamakusa.selenium.core.filters.BaseFilter;

public class RadiusFilter extends BaseFilter {

	public RadiusFilter(BrowserDriver driver) {
		this.driver = driver;
		this.container = driver.findByName("radius");
	}

	public boolean isSelected(final String radius) {
		return new SelectElement(container).getSelectedOption().getAttribute("value").equalsIgnoreCase(radius);
	}

}
