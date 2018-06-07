package shinoamakusa.selenium.pageobjects.autotrader.uk.results.filters;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.elements.ByLocator;
import shinoamakusa.selenium.core.elements.PageElement;
import shinoamakusa.selenium.core.elements.SelectElement;
import shinoamakusa.selenium.core.filters.BaseFilter;

public class SortFilter extends BaseFilter {
	public SortFilter(BrowserDriver driver) {
		this.driver = driver;
		this.locator = ByLocator.className("js-sort-options");
	}

	public void select(String value) {

		PageElement container = driver.findByLocator(this.locator);
		PageElement sortOption = container.findByAttribute("value", value);
		if (sortOption.exists())
			new SelectElement(container).selectOptionByValue(value);

	}

}
