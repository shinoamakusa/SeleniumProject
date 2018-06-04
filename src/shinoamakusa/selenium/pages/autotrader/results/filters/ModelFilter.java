package shinoamakusa.selenium.pages.autotrader.results.filters;

import org.openqa.selenium.WebDriverException;

import shinoamakusa.selenium.framework.drivers.BrowserDriver;

public class ModelFilter extends PageFilter {

	public ModelFilter(BrowserDriver driver) {
		this.driver = driver;
	}

	public void change(final String model) {
		try {
			select(model);
			filterMenuNumberResults = getFilterCount();
			driver.click(driver.selectedElement());
		} catch (WebDriverException e) {
			checkForModal();
			change(model);
		}

	}

	public boolean isSelected(final String model) {
		return driver.findByID("faceted-Model").getText().equalsIgnoreCase(model);
	}

	private void select(final String model) {

		driver.select(driver.findByID("faceted-parent-Model"));
		driver.click(driver.selectedElement());
		selectFilterElement(model);

	}

}
