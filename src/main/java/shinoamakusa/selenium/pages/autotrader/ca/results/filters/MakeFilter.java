package main.java.shinoamakusa.selenium.pages.autotrader.ca.results.filters;

import org.openqa.selenium.WebDriverException;

import main.java.shinoamakusa.selenium.core.drivers.BrowserDriver;

public class MakeFilter extends PageFilter {

	public MakeFilter(BrowserDriver driver) {
		this.driver = driver;
	}

	public void change(final String make) {
		select(make);
		filterMenuNumberResults = getFilterCount();
		try {
			driver.click(driver.selectedElement());
		} catch (WebDriverException e) {
			checkForModal();
			change(make);
		}

	}

	public boolean isSelected(final String make) {
		return driver.findByID("faceted-Make").getText().equalsIgnoreCase(make);
	}

	private void select(final String make) {
		driver.select(driver.findByID("faceted-parent-Make"));
		driver.click(driver.selectedElement());
		selectFilterElement(make);
	}

}
