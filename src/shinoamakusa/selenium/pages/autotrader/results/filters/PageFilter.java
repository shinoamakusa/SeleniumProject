package shinoamakusa.selenium.pages.autotrader.results.filters;

import shinoamakusa.selenium.framework.drivers.BrowserDriver;

public class PageFilter {

	protected BrowserDriver driver;
	protected int filterMenuNumberResults;

	public int getMenuResultsCount() {
		return filterMenuNumberResults;
	}

	protected int getFilterCount() {
		return Integer
				.parseInt(driver.getSelectedElement().findByClass("option-count").getText().replaceAll("[()]", ""));

	}

	protected void selectFilterElement(final String value) {
		driver.select(driver.getSelectedElement().findByAttribute("data-dropdownvalue", value));
	}

	protected void checkForSurvey() {
		driver.click(driver.findByClass("acsCloseButton"));
	}

}
