package shinoamakusa.selenium.pageobjects.autotrader.uk.home.filters;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.StaleElementReferenceException;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.elements.ByLocator;
import shinoamakusa.selenium.core.elements.BaseElement;
import shinoamakusa.selenium.core.elements.SelectElement;
import shinoamakusa.selenium.core.filters.BaseFilter;

public class MakeFilter extends BaseFilter {
	public MakeFilter(BrowserDriver driver) {
		this.driver = driver;
		this.locator = ByLocator.name("make");
	}

	public String getCount(String make) {
		BaseElement container = driver.findByLocator(this.locator);
		return StringUtils.substringBetween(container.findByAttribute("value", make).getText(), "(", ")");
	}

	public void select(String make) {
		try {
			SelectElement container = driver.findByLocator(this.locator).toSelectElement();
			container.hasUpdated();
			if (container.isClickable()) {
				BaseElement makeOption = container.findByAttribute("value", make);
				if (makeOption.exists()) {
					container.selectOptionByValue(make);
				}
			}
		} catch (StaleElementReferenceException e) {
			select(make);
		}

	}

}
