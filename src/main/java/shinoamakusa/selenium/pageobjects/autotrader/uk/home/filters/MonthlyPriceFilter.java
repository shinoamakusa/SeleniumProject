package shinoamakusa.selenium.pageobjects.autotrader.uk.home.filters;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.elements.ByLocator;
import shinoamakusa.selenium.core.elements.PageElement;
import shinoamakusa.selenium.core.filters.BaseFilter;

public class MonthlyPriceFilter extends BaseFilter {
	public MonthlyPriceFilter(BrowserDriver driver) {
		this.driver = driver;
		this.locator = ByLocator.attribute("for", "searchVehiclesPriceTypeMonthly");
	}

	public void select() {
		PageElement container = driver.findByLocator(this.locator);
		if (container.findByID("searchVehiclesPriceTypeMonthly").hasSelectedState(false)) {
			driver.click(container);
		}
	}

}
