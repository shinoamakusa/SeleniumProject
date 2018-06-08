package shinoamakusa.selenium.pageobjects.autotrader.uk.results.filters;

import java.util.ArrayList;
import java.util.List;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.elements.ByLocator;
import shinoamakusa.selenium.core.elements.PageElement;
import shinoamakusa.selenium.core.filters.BaseFilter;

public class CarFilter extends BaseFilter {
	public CarFilter(BrowserDriver driver) {
		this.driver = driver;
		this.locator = ByLocator.className("options-button__values");
	}

	public List<String> getSelectedFilters() {
		List<String> filters = new ArrayList<String>();
		PageElement container = driver.findByLocator(this.locator);

		for (PageElement element : container.findAllByClass("options-button__values-item")) {
			filters.add(element.getText());
		}

		return filters;
	}

}
