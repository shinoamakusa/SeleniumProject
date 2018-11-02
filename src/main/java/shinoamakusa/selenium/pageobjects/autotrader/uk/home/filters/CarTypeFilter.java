package shinoamakusa.selenium.pageobjects.autotrader.uk.home.filters;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.StaleElementReferenceException;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.elements.BaseElement;
import shinoamakusa.selenium.core.elements.SelectElement;
import shinoamakusa.selenium.core.filters.BaseFilter;

public class CarTypeFilter extends BaseFilter {
	public CarTypeFilter(final BrowserDriver driver) {
		super(driver);
	}
	
	public String getCount() {
		BaseElement container = driver.findByLocator(locator);
		return StringUtils.substringBetween(new SelectElement(container).getSelectedOption().getText(), "(", ")");
	}
	
	public boolean updated()
	{
		BaseElement container = driver.findByLocator(locator);
		return container.hasUpdated();
	}

	public void select(final String value) {
		try {
			SelectElement container = driver.findByLocator(this.locator).toSelectElement();
			container.hasUpdated();
			if (container.isClickable()) {
				BaseElement makeOption = container.findByAttribute("value", value);
				if (makeOption.exists()) {
					container.selectOptionByValue(value);
				}
			}
		} catch (StaleElementReferenceException e) {
			select(value);
		}

	}

}
