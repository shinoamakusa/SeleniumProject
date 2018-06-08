package shinoamakusa.selenium.pageobjects.autotrader.uk.home.filters;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.elements.ByLocator;
import shinoamakusa.selenium.core.elements.PageElement;
import shinoamakusa.selenium.core.filters.BaseFilter;

public class TotalPriceFilter extends BaseFilter {
	public TotalPriceFilter(BrowserDriver driver) {
		this.driver = driver;
		this.locator = ByLocator.attribute("for", "searchVehiclesPriceTypeTotal");
	}

	public void select() {
		PageElement container = driver.findByLocator(this.locator);
		if (container.findByID("searchVehiclesPriceTypeTotal").hasSelectedState(false)) {
			driver.click(container);
		}
	}

}