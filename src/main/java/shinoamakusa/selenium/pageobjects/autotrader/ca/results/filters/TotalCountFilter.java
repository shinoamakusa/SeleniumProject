package shinoamakusa.selenium.pageobjects.autotrader.ca.results.filters;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.elements.ByLocator;
import shinoamakusa.selenium.core.elements.PageElement;

public class TotalCountFilter extends PageFilter {

	public TotalCountFilter(BrowserDriver driver) {
		this.driver = driver;
		this.locator = ByLocator.id("sbCount");
	}

	public boolean changedFrom(String text) {
		PageElement container = driver.findByLocator(this.locator);
		return container.textNotEqual(text);
	}

	public boolean equalsTo(String text) {
		PageElement container = driver.findByLocator(this.locator);
		return container.textContains(text);
	}

	public int getValue() {
		PageElement container = driver.findByLocator(this.locator);
		return Integer.parseInt(container.getText().replaceAll(",", ""));

	}

}
