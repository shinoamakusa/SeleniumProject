package shinoamakusa.selenium.pageobjects.autotrader.uk.home.filters;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.StaleElementReferenceException;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.elements.ByLocator;
import shinoamakusa.selenium.core.elements.BaseElement;
import shinoamakusa.selenium.core.elements.SelectElement;
import shinoamakusa.selenium.core.filters.BaseFilter;

public class ModelFilter extends CarTypeFilter {
	public ModelFilter(BrowserDriver driver) {
		super(driver);
		this.locator = ByLocator.name("model");
	}

}
