package shinoamakusa.selenium.pageobjects.autotrader.uk.home.filters;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.filters.BaseFilter;

public class TotalPriceFilter extends BaseFilter {
	public TotalPriceFilter(BrowserDriver driver) {
		this.driver = driver;
		this.container = driver.findByAttribute("for", "searchVehiclesPriceTypeTotal");
	}

	public void select() {
		if (container.findByID("searchVehiclesPriceTypeTotal").hasSelectedState(false)) {
			driver.click(container);
		}
	}

}
