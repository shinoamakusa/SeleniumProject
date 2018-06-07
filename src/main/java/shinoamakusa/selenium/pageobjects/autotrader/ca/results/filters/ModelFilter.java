package shinoamakusa.selenium.pageobjects.autotrader.ca.results.filters;

import org.openqa.selenium.WebDriverException;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.elements.ByLocator;
import shinoamakusa.selenium.core.elements.PageElement;

public class ModelFilter extends PageFilter {

	public ModelFilter(BrowserDriver driver) {
		this.driver = driver;
		this.locator = ByLocator.id("faceted-parent-Model");
	}

	public void changeTo(final String model) {

		selectModelFilter();
		chooseMenuOption(model);

	}

	public boolean isSelected(final String model) {
		PageElement container = driver.findByLocator(this.locator);
		return container.findByID("faceted-Model").getText().equalsIgnoreCase(model);
	}

	private void selectModelFilter() {

		try {
			PageElement container = driver.findByLocator(this.locator);
			driver.click(container);
		} catch (WebDriverException e) {
			checkForModal();
			selectModelFilter();
		}

	}

}
