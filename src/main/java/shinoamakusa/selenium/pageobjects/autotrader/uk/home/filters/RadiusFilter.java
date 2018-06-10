package shinoamakusa.selenium.pageobjects.autotrader.uk.home.filters;

import org.openqa.selenium.StaleElementReferenceException;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.elements.ByLocator;
import shinoamakusa.selenium.core.elements.BaseElement;
import shinoamakusa.selenium.core.elements.SelectElement;
import shinoamakusa.selenium.core.filters.BaseFilter;

public class RadiusFilter extends BaseFilter {
	public RadiusFilter(BrowserDriver driver) {
		super(driver);
		this.locator = ByLocator.name("radius");
	}

	public void select(String radius) {
		try {
			SelectElement container = driver.findByLocator(this.locator).toSelectElement();
			if (container.isClickable()) {
				BaseElement radiusOption = container.findByAttribute("value", radius);
				if (radiusOption.exists())
					container.selectOptionByValue(radius);
			}
		} catch (StaleElementReferenceException e) {
			select(radius);
		}
	}

}
