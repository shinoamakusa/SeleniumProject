package shinoamakusa.selenium.pageobjects.autotrader.uk.results.filters;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.elements.ByLocator;
import shinoamakusa.selenium.core.elements.SelectElement;
import shinoamakusa.selenium.core.filters.BaseFilter;

public class RadiusFilter extends BaseFilter {

	public RadiusFilter(BrowserDriver driver) {
		super(driver);
		this.locator = ByLocator.attribute("data-field-name", "radius");
	}

	public boolean isSelected(final String radius) {
		SelectElement container = driver.findByLocator(this.locator).toSelectElement();
		return container.getSelectedOption().getAttribute("value").equalsIgnoreCase(radius);
	}

}
