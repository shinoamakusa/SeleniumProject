package main.java.shinoamakusa.selenium.pages.autotrader.ca.results.filters;

import org.openqa.selenium.WebDriverException;

import main.java.shinoamakusa.selenium.core.drivers.BrowserDriver;

public class YearFilter extends BaseFilter {

	public YearFilter(BrowserDriver driver) {
		this.driver = driver;
		this.container = driver.findByID("faceted-parent-Year");
	}

	public void changeMaxTo(final String year) {
		selectYearFilter();
		selectMaxYear(year);

	}

	public boolean isSelected(final String year) {
		return container.findByID("faceted-Year").textContains(year);
	}

	private void selectYearFilter() {
		try {
			driver.click(this.container);
		} catch (WebDriverException e) {
			checkForModal();
			selectYearFilter();
		}
	}

	private void selectMaxYear(final String year) {

		try {
			menu = new BaseFilterMenu(container.findByClass("dropdown-menu"));
			menu.container().findByID("yearHigh").selectOptionByValue(year);
			driver.click(menu.container().findByID("applyYear"));
		} catch (WebDriverException e) {
			checkForModal();
			selectMaxYear(year);
		}

	}

}
