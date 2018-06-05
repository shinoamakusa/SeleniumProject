package main.java.shinoamakusa.selenium.pages.autotrader.ca.results.filters;

import org.openqa.selenium.WebDriverException;

import main.java.shinoamakusa.selenium.core.drivers.BrowserDriver;

public class MakeFilter extends PageFilter {

	public MakeFilter(BrowserDriver driver) {
		this.driver = driver;
	}

	public void changeTo(final String make) {

		selectMakeFilter();
		selectFilterMenuElement(make);

	}

	public boolean isSelected(final String make) {
		return driver.findByID("faceted-Make").getText().equalsIgnoreCase(make);
	}

	private void selectMakeFilter() {
		try {
			driver.setParentElement(driver.findByID("faceted-parent-Make"));
			driver.click(driver.parentElement());
		} catch (WebDriverException e) {
			checkForModal();
			selectMakeFilter();
		}
	}

}
