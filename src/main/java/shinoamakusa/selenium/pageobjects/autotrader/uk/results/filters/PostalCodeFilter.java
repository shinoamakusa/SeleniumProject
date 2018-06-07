package shinoamakusa.selenium.pageobjects.autotrader.uk.results.filters;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.filters.BaseFilter;

public class PostalCodeFilter extends BaseFilter {

	public PostalCodeFilter(BrowserDriver driver) {
		this.driver = driver;
		this.container = driver.findByID("postcode");
	}

	public boolean isSelected(final String code) {
		return container.getAttribute("value").equalsIgnoreCase(code.replaceAll(" ", "").toLowerCase());
	}

}
