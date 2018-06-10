package shinoamakusa.selenium.pageobjects.autotrader.ca.results.filters;

import org.openqa.selenium.WebDriverException;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.elements.ByLocator;
import shinoamakusa.selenium.core.elements.BaseElement;

public class MakeFilter extends PageFilter {

	public MakeFilter(BrowserDriver driver) {
		this.driver = driver;
		this.locator = ByLocator.id("faceted-parent-Make");
	}

	public void changeTo(final String make) {

		selectMakeFilter();
		chooseMenuOption(make);

	}

	public boolean isSelected(final String make) {
		BaseElement container = driver.findByLocator(this.locator);
		return container.findByID("faceted-Make").getText().equalsIgnoreCase(make);
	}

	private void selectMakeFilter() {
		try {
			BaseElement container = driver.findByLocator(this.locator);
			driver.click(container);
		} catch (WebDriverException e) {
			checkForModal();
			selectMakeFilter();
		}
	}

}
