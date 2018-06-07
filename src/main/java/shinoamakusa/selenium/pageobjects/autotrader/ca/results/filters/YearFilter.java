package shinoamakusa.selenium.pageobjects.autotrader.ca.results.filters;

import org.openqa.selenium.WebDriverException;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.elements.ByLocator;
import shinoamakusa.selenium.core.elements.PageElement;
import shinoamakusa.selenium.core.elements.SelectElement;

public class YearFilter extends PageFilter {

	public YearFilter(BrowserDriver driver) {
		this.driver = driver;
		this.locator = ByLocator.id("faceted-parent-Year");
	}

	public void changeMaxTo(final String year) {
		selectYearFilter();
		selectMaxYear(year);

	}

	public boolean isSelected(final String year) {
		PageElement container = driver.findByLocator(this.locator);
		return container.findByID("faceted-Year").textContains(year);
	}

	private void selectYearFilter() {
		try {
			PageElement container = driver.findByLocator(this.locator);
			driver.click(container);
		} catch (WebDriverException e) {
			checkForModal();
			selectYearFilter();
		}
	}

	private void selectMaxYear(final String year) {

		try {
			PageElement container = driver.findByLocator(this.locator);
			menu = new PageFilterMenu(container.findByClass("dropdown-menu"));
			SelectElement maxYearSelect = new SelectElement(menu.container().findByID("yearHigh"));
			maxYearSelect.selectOptionByValue(year);
			driver.click(menu.container().findByID("applyYear"));
		} catch (WebDriverException e) {
			checkForModal();
			selectMaxYear(year);
		}

	}

}
