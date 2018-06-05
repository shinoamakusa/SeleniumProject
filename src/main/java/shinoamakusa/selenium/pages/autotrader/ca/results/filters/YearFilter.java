package main.java.shinoamakusa.selenium.pages.autotrader.ca.results.filters;

import org.openqa.selenium.WebDriverException;

import main.java.shinoamakusa.selenium.core.drivers.BrowserDriver;

public class YearFilter extends PageFilter {

	public YearFilter(BrowserDriver driver) {
		this.driver = driver;
	}

	public void changeMax(final String year) {
		try {
			selectYearFilter();
			selectMaxYear(year);
		} catch (WebDriverException e) {
			checkForModal();
			changeMax(year);
		}
	}

	public boolean isSelected(final String year) {
		return driver.findByID("faceted-Year").textContains(year);
	}
	
	private void selectYearFilter()
	{
		driver.select(driver.findByID("faceted-parent-Year"));
		driver.click(driver.selectedElement());
	}

	private void selectMaxYear(final String year) {

		driver.selectedElement().findByID("yearHigh").selectOptionByValue(year);
		driver.click(driver.findByID("applyYear"));

	}

}
