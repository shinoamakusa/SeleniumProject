package main.java.shinoamakusa.selenium.pages.autotrader.results.filters;

import main.java.shinoamakusa.selenium.framework.drivers.BrowserDriver;

public class PageFilter {

	protected BrowserDriver driver;
	protected int filterMenuNumberResults;

	public int getMenuResultsCount() {
		return filterMenuNumberResults;
	}

	protected void checkForModal() {
		driver.click(driver.findByClass("acsCloseButton"));
	}

	protected int getFilterCount() {
		return Integer
				.parseInt(driver.selectedElement().findByClass("option-count").getText().replaceAll("[()]", ""));

	}

	protected void selectFilterElement(final String value) {
		driver.select(driver.selectedElement().findByAttribute("data-dropdownvalue", value));
	}

}
