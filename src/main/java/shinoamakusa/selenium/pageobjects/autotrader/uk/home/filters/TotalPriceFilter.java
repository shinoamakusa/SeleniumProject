package shinoamakusa.selenium.pageobjects.autotrader.uk.home.filters;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.elements.ByLocator;
import shinoamakusa.selenium.core.elements.BaseElement;
import shinoamakusa.selenium.core.filters.BaseFilter;

public class TotalPriceFilter extends BaseFilter {
	public TotalPriceFilter(BrowserDriver driver) {
		super(driver);
		this.locator = ByLocator.attribute("for", "searchVehiclesPriceTypeTotal");
	}
	
	public boolean isSelected() {
		BaseElement container = driver.findByLocator(this.locator);
		return container.findByID("searchVehiclesPriceTypeTotal").toRadioElement().hasSelectedState(true);

	}

	public void select() {
		BaseElement container = driver.findByLocator(this.locator);
		if (!container.findByID("searchVehiclesPriceTypeTotal").toRadioElement().hasSelectedState(true)) {
			driver.click(container);
		}
	}

}
