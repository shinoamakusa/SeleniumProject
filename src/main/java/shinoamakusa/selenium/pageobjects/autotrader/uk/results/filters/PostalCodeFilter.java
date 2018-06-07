package shinoamakusa.selenium.pageobjects.autotrader.uk.results.filters;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.elements.ByLocator;
import shinoamakusa.selenium.core.elements.PageElement;
import shinoamakusa.selenium.core.filters.BaseFilter;

public class PostalCodeFilter extends BaseFilter {

	public PostalCodeFilter(BrowserDriver driver) {
		this.driver = driver;
		this.locator = ByLocator.id("postcode");
	}

	public boolean isSelected(final String code) {
		PageElement container = driver.findByLocator(this.locator);
		return container.getAttribute("value").equalsIgnoreCase(code.replaceAll(" ", "").toLowerCase());
	}

}
