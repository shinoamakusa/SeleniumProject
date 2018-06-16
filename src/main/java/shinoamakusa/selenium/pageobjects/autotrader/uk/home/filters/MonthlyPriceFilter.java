package shinoamakusa.selenium.pageobjects.autotrader.uk.home.filters;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.elements.ByLocator;
import shinoamakusa.selenium.core.elements.BaseElement;
import shinoamakusa.selenium.core.filters.BaseFilter;

public class MonthlyPriceFilter extends BaseFilter {
	public MonthlyPriceFilter(BrowserDriver driver) {
		super(driver);
		this.locator = ByLocator.attribute("for", "searchVehiclesPriceTypeMonthly");
	}

	public boolean isSelected() {
		BaseElement container = driver.findByLocator(this.locator);
		return container.findByID("searchVehiclesPriceTypeMonthly").toRadioElement().hasSelectedState(true);

	}

	public void select() {
		BaseElement container = driver.findByLocator(this.locator);
		if (!container.findByID("searchVehiclesPriceTypeMonthly").toRadioElement().hasSelectedState(true)) {
			driver.click(container);
		}
	}

}
