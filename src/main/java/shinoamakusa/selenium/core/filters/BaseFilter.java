package shinoamakusa.selenium.core.filters;

import org.openqa.selenium.By;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.elements.BaseElement;

public class BaseFilter {

	protected BrowserDriver driver;
	protected By locator;

	public BaseFilter() {

	}

	public BaseFilter(final BrowserDriver driver) {
		this.driver = driver;
	}

	public BaseFilter(final BrowserDriver driver, final By locator) {
		this(locator, driver);
	}

	public BaseFilter(final By locator) {
		this.locator = locator;
	}

	public BaseFilter(final By locator, final BrowserDriver driver) {
		this.driver = driver;
		this.locator = locator;
	}

	public String getText() {
		BaseElement container = driver.findByLocator(this.locator);
		return container.getText();
	}

	public String value() {
		BaseElement container = driver.findByLocator(this.locator);
		return container.getAttribute("value");
	}

}
