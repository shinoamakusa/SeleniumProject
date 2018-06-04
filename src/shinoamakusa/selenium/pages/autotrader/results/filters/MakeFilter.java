package shinoamakusa.selenium.pages.autotrader.results.filters;

import org.openqa.selenium.WebDriverException;

import shinoamakusa.selenium.framework.drivers.BrowserDriver;

public class MakeFilter extends PageFilter {

	public MakeFilter(BrowserDriver driver) {
		this.driver = driver;
	}

	public void change(final String make) {
		try {
			select(make);
			filterMenuNumberResults = getFilterCount();
			driver.click(driver.getSelectedElement());
		} catch (WebDriverException e) {
			checkForSurvey();
			change(make);
		}

	}

	public boolean isSelected(final String make) {
		return driver.findByID("faceted-Make").getText().equalsIgnoreCase(make);
	}

	private void select(final String make) {
		driver.select(driver.findByID("faceted-parent-Make"));
		driver.click(driver.getSelectedElement());
		selectFilterElement(make);
	}

}
