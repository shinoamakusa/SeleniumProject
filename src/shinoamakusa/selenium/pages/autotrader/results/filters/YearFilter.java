package shinoamakusa.selenium.pages.autotrader.results.filters;

import org.openqa.selenium.WebDriverException;

import shinoamakusa.selenium.framework.drivers.BrowserDriver;

public class YearFilter extends PageFilter {

	public YearFilter(BrowserDriver driver) {
		this.driver = driver;
	}

	public void changeMax(final String year) {
		try {
			driver.select(driver.findByID("faceted-parent-Year"));
			driver.click(driver.getSelectedElement());
			selectMaxYear(year);
		} catch (WebDriverException e) {
			checkForSurvey();
			changeMax(year);
		}
	}

	public boolean isSelected(final String year) {
		return driver.findByID("faceted-Year").textContains(year);
	}

	private void selectMaxYear(final String year) {
		driver.select(driver.getSelectedElement().findByID("yearHigh"));
		driver.selectOptionByValue(driver.getSelectedElement(), year);
		driver.click(driver.findByID("applyYear"));

	}

}
