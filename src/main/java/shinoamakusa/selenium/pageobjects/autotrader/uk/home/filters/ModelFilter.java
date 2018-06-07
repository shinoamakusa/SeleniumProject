package shinoamakusa.selenium.pageobjects.autotrader.uk.home.filters;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.StaleElementReferenceException;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.elements.PageElement;
import shinoamakusa.selenium.core.elements.SelectElement;
import shinoamakusa.selenium.core.filters.BaseFilter;

public class ModelFilter extends BaseFilter {
	public ModelFilter(BrowserDriver driver) {
		this.driver = driver;
		this.container = driver.findByName("model");
	}

	public String getCount(String model) {
		return StringUtils.substringBetween(container.findByAttribute("value", model).getText(), "(", ")");
	}

	public void select(String model) {
		try {
			if (container.isClickable()) {
				PageElement modelOption = container.findByAttribute("value", model);
				if (modelOption.exists())
					new SelectElement(container).selectOptionByValue(model);
			}
		} catch (StaleElementReferenceException e) {
			select(model);
		}

	}

}
