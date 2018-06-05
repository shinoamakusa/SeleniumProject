package main.java.shinoamakusa.selenium.pages.autotrader.ca.results.filters;

import main.java.shinoamakusa.selenium.core.drivers.BrowserDriver;

public class PageFilter {

	protected BrowserDriver driver;
	protected int filterMenuNumberResults;

	public int getMenuResultsCount() {
		return filterMenuNumberResults;
	}

	protected void checkForModal() {
		driver.click(driver.findByClass("acsCloseButton"));
	}

	protected int getFilterMenuCount() {
		return Integer
				.parseInt(driver.selectedElement().findByClass("option-count").getText().replaceAll("[()]", ""));

	}

	protected void selectFilterMenuElement(final String value) {
		driver.select(driver.selectedElement().findByAttribute("data-dropdownvalue", value));
		filterMenuNumberResults = getFilterMenuCount();
		driver.click(driver.selectedElement());
		
	}

}
