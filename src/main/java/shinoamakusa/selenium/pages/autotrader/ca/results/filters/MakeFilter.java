package main.java.shinoamakusa.selenium.pages.autotrader.ca.results.filters;

import org.openqa.selenium.WebDriverException;

import main.java.shinoamakusa.selenium.core.drivers.BrowserDriver;

public class MakeFilter extends BaseFilter {

	public MakeFilter(BrowserDriver driver) {
		this.driver = driver;
		this.container = driver.findByID("faceted-parent-Make");
	}

	public void changeTo(final String make) {

		selectMakeFilter();
		chooseMenuOption(make);

	}

	public boolean isSelected(final String make) {
		return container.findByID("faceted-Make").getText().equalsIgnoreCase(make);
	}

	private void selectMakeFilter() {
		try {
			driver.click(this.container);
		} catch (WebDriverException e) {
			checkForModal();
			selectMakeFilter();
		}
	}

}
