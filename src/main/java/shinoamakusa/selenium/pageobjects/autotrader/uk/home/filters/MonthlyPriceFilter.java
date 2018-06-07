package shinoamakusa.selenium.pageobjects.autotrader.uk.home.filters;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.filters.BaseFilter;

public class MonthlyPriceFilter extends BaseFilter {
	public MonthlyPriceFilter(BrowserDriver driver) {
		this.driver = driver;
		this.container = driver.findByAttribute("for", "searchVehiclesPriceTypeMonthly");
	}

	public void select() {
		if (container.findByID("searchVehiclesPriceTypeMonthly").hasSelectedState(false)) {
			driver.click(container);
		}
	}

}
