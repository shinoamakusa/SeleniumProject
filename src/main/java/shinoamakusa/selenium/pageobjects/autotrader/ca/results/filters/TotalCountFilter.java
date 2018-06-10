package shinoamakusa.selenium.pageobjects.autotrader.ca.results.filters;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.elements.ByLocator;
import shinoamakusa.selenium.core.elements.BaseElement;

public class TotalCountFilter extends PageFilter {

	public TotalCountFilter(BrowserDriver driver) {
		super(driver);
		this.locator = ByLocator.id("sbCount");
	}

	public boolean changedFrom(String text) {
		BaseElement container = driver.findByLocator(this.locator);
		return container.textNotEqual(text);
	}

	public boolean equalsTo(String text) {
		BaseElement container = driver.findByLocator(this.locator);
		return container.textContains(text);
	}

	public int getValue() {
		BaseElement container = driver.findByLocator(this.locator);
		return Integer.parseInt(container.getText().replaceAll(",", ""));

	}

}
