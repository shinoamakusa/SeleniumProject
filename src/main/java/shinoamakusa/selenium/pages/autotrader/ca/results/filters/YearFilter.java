package main.java.shinoamakusa.selenium.pages.autotrader.ca.results.filters;

import org.openqa.selenium.WebDriverException;

import main.java.shinoamakusa.selenium.core.drivers.BrowserDriver;

public class YearFilter extends PageFilter {

	public YearFilter(BrowserDriver driver) {
		this.driver = driver;
	}

	public void changeMax(final String year) {
		driver.select(driver.findByID("faceted-parent-Year"));
		try {
			driver.click(driver.selectedElement());
		} catch (WebDriverException e) {
			checkForModal();
			changeMax(year);
		}
		selectMaxYear(year);

	}

	public boolean isSelected(final String year) {
		return driver.findByID("faceted-Year").textContains(year);
	}

	private void selectMaxYear(final String year) {
		driver.select(driver.selectedElement().findByID("yearHigh"));
		driver.selectOptionByValue(driver.selectedElement(), year);
		driver.click(driver.findByID("applyYear"));

	}

}
