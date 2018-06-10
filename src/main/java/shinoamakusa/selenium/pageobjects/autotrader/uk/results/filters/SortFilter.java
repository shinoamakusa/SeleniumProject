package shinoamakusa.selenium.pageobjects.autotrader.uk.results.filters;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.elements.ByLocator;
import shinoamakusa.selenium.core.elements.BaseElement;
import shinoamakusa.selenium.core.elements.SelectElement;
import shinoamakusa.selenium.core.filters.BaseFilter;

public class SortFilter extends BaseFilter {
	public SortFilter(BrowserDriver driver) {
		super(driver);
		this.locator = ByLocator.className("js-sort-options");
	}

	public void select(String value) {

		SelectElement container = driver.findByLocator(this.locator).toSelectElement();
		BaseElement sortOption = container.findByAttribute("value", value);
		if (sortOption.exists())
			container.selectOptionByValue(value);

	}

}
