package main.java.shinoamakusa.selenium.pages.autotrader.ca.results.filters;

import org.openqa.selenium.WebDriverException;

import main.java.shinoamakusa.selenium.core.drivers.BrowserDriver;

public class ModelFilter extends PageFilter {

	public ModelFilter(BrowserDriver driver) {
		this.driver = driver;
	}

	public void change(final String model) {
		try {
			selectModelFilter();
			selectFilterMenuElement(model);
		} catch (WebDriverException e) {
			checkForModal();
			change(model);
		}

	}

	public boolean isSelected(final String model) {
		return driver.findByID("faceted-Model").getText().equalsIgnoreCase(model);
	}

	private void selectModelFilter() {

		driver.select(driver.findByID("faceted-parent-Model"));
		driver.click(driver.selectedElement());

	}

}
