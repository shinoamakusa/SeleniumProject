package shinoamakusa.selenium.pageobjects.autotrader.ca.results.filters;

import org.openqa.selenium.WebDriverException;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.elements.ByLocator;
import shinoamakusa.selenium.core.elements.BaseElement;

public class ModelFilter extends PageFilter {

	public ModelFilter(BrowserDriver driver) {
		super(driver);
		this.locator = ByLocator.id("faceted-parent-Model");
	}

	public void changeTo(final String model) {

		selectModelFilter();
		chooseMenuOption(model);

	}

	public boolean isSelected(final String model) {
		BaseElement container = driver.findByLocator(this.locator);
		return container.findByID("faceted-Model").getText().equalsIgnoreCase(model);
	}

	public String value() {
		BaseElement container = driver.findByLocator(this.locator);
		return container.findByID("faceted-Model").getText();
	}

	private void selectModelFilter() {

		try {
			BaseElement container = driver.findByLocator(this.locator);
			driver.click(container);
		} catch (WebDriverException e) {
			checkForModal();
			selectModelFilter();
		}

	}

}
