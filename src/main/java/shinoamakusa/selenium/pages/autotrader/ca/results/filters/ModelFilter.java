package main.java.shinoamakusa.selenium.pages.autotrader.ca.results.filters;

import org.openqa.selenium.WebDriverException;

import main.java.shinoamakusa.selenium.core.drivers.BrowserDriver;

public class ModelFilter extends PageFilter {

	public ModelFilter(BrowserDriver driver) {
		this.driver = driver;
		this.filterElement = driver.findByID("faceted-parent-Model");
	}

	public void changeTo(final String model) {

		selectModelFilter();
		chooseMenuOption(model);

	}

	public boolean isSelected(final String model) {
		return driver.findByID("faceted-Model").getText().equalsIgnoreCase(model);
	}

	private void selectModelFilter() {

		try {
			driver.click(this.filterElement);
		} catch (WebDriverException e) {
			checkForModal();
			selectModelFilter();
		}

	}

}
