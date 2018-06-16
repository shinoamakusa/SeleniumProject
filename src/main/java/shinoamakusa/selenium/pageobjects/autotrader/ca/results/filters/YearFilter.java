package shinoamakusa.selenium.pageobjects.autotrader.ca.results.filters;

import org.openqa.selenium.WebDriverException;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.elements.ByLocator;
import shinoamakusa.selenium.core.elements.BaseElement;
import shinoamakusa.selenium.core.elements.SelectElement;

public class YearFilter extends PageFilter {

	public YearFilter(BrowserDriver driver) {
		super(driver);
		this.locator = ByLocator.id("faceted-parent-Year");
	}

	public void changeMaxTo(final String year) {
		try {
			selectYearFilter();
			selectMaxYear(year);
		} catch (WebDriverException e) {
			checkForModal();
			changeMaxTo(year);
		}

	}

	public boolean isSelected(final String year) {
		BaseElement container = driver.findByLocator(this.locator);
		return container.findByID("faceted-Year").textContains(year);
	}

	public String maxYearValue() {
		BaseElement container = driver.findByLocator(this.locator);
		return container.findByID("faceted-Year").getText();
	}

	private void selectYearFilter() {
		BaseElement container = driver.findByLocator(this.locator);
		driver.click(container);

	}

	private void selectMaxYear(final String year) {
		BaseElement container = driver.findByLocator(this.locator);
		menu = new PageFilterMenu(container.findByClass("dropdown-menu"));
		SelectElement maxYearSelect = new SelectElement(menu.container().findByID("yearHigh"));
		maxYearSelect.selectOptionByValue(year);
		driver.click(menu.container().findByID("applyYear"));

	}

}
