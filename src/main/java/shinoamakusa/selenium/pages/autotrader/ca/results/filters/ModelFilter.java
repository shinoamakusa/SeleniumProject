package main.java.shinoamakusa.selenium.pages.autotrader.ca.results.filters;

import org.openqa.selenium.WebDriverException;

import main.java.shinoamakusa.selenium.core.drivers.BrowserDriver;

public class ModelFilter extends BaseFilter {

	public ModelFilter(BrowserDriver driver) {
		this.driver = driver;
		this.container = driver.findByID("faceted-parent-Model");
	}

	public void changeTo(final String model) {

		selectModelFilter();
		chooseMenuOption(model);

	}

	public boolean isSelected(final String model) {
		return container.findByID("faceted-Model").getText().equalsIgnoreCase(model);
	}

	private void selectModelFilter() {

		try {
			driver.click(this.container);
		} catch (WebDriverException e) {
			checkForModal();
			selectModelFilter();
		}

	}

}
