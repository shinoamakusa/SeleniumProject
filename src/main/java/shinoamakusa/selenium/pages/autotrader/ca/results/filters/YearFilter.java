package main.java.shinoamakusa.selenium.pages.autotrader.ca.results.filters;

import org.openqa.selenium.WebDriverException;

import main.java.shinoamakusa.selenium.core.drivers.BrowserDriver;

public class YearFilter extends PageFilter {

	public YearFilter(BrowserDriver driver) {
		this.driver = driver;
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
			driver.setParentElement(driver.findByID("faceted-parent-Year"));
			driver.click(driver.parentElement());
		} catch (WebDriverException e) {
			checkForModal();
			selectYearFilter();
		}
	}

	private void selectMaxYear(final String year) {

		try {
			driver.parentElement().findByID("yearHigh").selectOptionByValue(year);
			driver.click(driver.findByID("applyYear"));
		} catch (WebDriverException e) {
			checkForModal();
			selectMaxYear(year);
		}

	}

}
