package shinoamakusa.selenium.pageobjects.autotrader.uk.home.filters;

import org.openqa.selenium.StaleElementReferenceException;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.elements.ByLocator;
import shinoamakusa.selenium.core.elements.PageElement;
import shinoamakusa.selenium.core.elements.SelectElement;
import shinoamakusa.selenium.core.filters.BaseFilter;

public class RadiusFilter extends BaseFilter {
	public RadiusFilter(BrowserDriver driver) {
		this.driver = driver;
		this.locator = ByLocator.name("radius");
	}

	public void select(String radius) {
		try {
			PageElement container = driver.findByLocator(this.locator);
			if (container.isClickable()) {
				PageElement radiusOption = container.findByAttribute("value", radius);
				if (radiusOption.exists())
					new SelectElement(container).selectOptionByValue(radius);
			}
		} catch (StaleElementReferenceException e) {
			select(radius);
		}
	}

}
