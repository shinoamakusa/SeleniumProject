package main.java.shinoamakusa.selenium.pages.autotrader.ca.results.filters;

import org.openqa.selenium.WebDriverException;

import main.java.shinoamakusa.selenium.core.drivers.BrowserDriver;

public class MakeFilter extends PageFilter {

	public MakeFilter(BrowserDriver driver) {
		this.driver = driver;
		this.filterElement = driver.findByID("faceted-parent-Make");
	}

	public void changeTo(final String make) {

		selectMakeFilter();
		chooseMenuOption(make);

	}

	public boolean isSelected(final String make) {
		return driver.findByID("faceted-Make").getText().equalsIgnoreCase(make);
	}

	private void selectMakeFilter() {
		try {
			driver.click(this.filterElement);
		} catch (WebDriverException e) {
			checkForModal();
			selectMakeFilter();
		}
	}

}
