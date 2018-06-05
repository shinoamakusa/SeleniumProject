package main.java.shinoamakusa.selenium.pages.autotrader.ca.results.filters;

import org.openqa.selenium.WebDriverException;

import main.java.shinoamakusa.selenium.core.drivers.BrowserDriver;

public class YearFilter extends PageFilter {

	public YearFilter(BrowserDriver driver) {
		this.driver = driver;
		this.filterElement = driver.findByID("faceted-parent-Year");
	}

	public void changeMaxTo(final String year) {
		selectYearFilter();
		selectMaxYear(year);

	}

	public boolean isSelected(final String year) {
		return driver.findByID("faceted-Year").textContains(year);
	}

	private void selectYearFilter() {
		try {
			driver.click(this.filterElement);
		} catch (WebDriverException e) {
			checkForModal();
			selectYearFilter();
		}
	}

	private void selectMaxYear(final String year) {

		try {
			filterElement.findByID("yearHigh").selectOptionByValue(year);
			driver.click(filterElement.findByID("applyYear"));
		} catch (WebDriverException e) {
			checkForModal();
			selectMaxYear(year);
		}

	}

}
