package main.java.shinoamakusa.selenium.pages.autotrader.ca.results.filters;

import org.openqa.selenium.WebDriverException;

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

	protected void selectFilterMenuElement(final String value) {
		try {
			driver.select(driver.parentElement().findByAttribute("data-dropdownvalue", value));
			filterMenuNumberResults = getFilterMenuCount();
			driver.click(driver.selectedElement());
		} catch (WebDriverException e) {
			checkForModal();
			selectFilterMenuElement(value);
		}

	}

	private int getFilterMenuCount() {
		return Integer.parseInt(driver.selectedElement().findByClass("option-count").getText().replaceAll("[()]", ""));

	}

}
