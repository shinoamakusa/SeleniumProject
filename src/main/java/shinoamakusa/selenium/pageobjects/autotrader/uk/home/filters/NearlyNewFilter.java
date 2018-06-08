package shinoamakusa.selenium.pageobjects.autotrader.uk.home.filters;

import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByChained;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.elements.ByLocator;
import shinoamakusa.selenium.core.elements.PageElement;
import shinoamakusa.selenium.core.filters.BaseFilter;

public class NearlyNewFilter extends BaseFilter {
	private boolean selectedState = true;
	
	public NearlyNewFilter(BrowserDriver driver) {
		this.driver = driver;
		this.locator = ByLocator.attribute("for", "oneSearchAdNearlyNew");
	}
	
	public NearlyNewFilter(BrowserDriver driver, By parentLocator) {
		this(driver);
		this.locator = new ByChained(parentLocator, this.locator);
	}

	public void select(boolean state) {
		PageElement container = driver.findByLocator(this.locator);
		if (container.findByName("onesearchad").hasSelectedState(!state)) {
			driver.click(container);
			this.selectedState = state;
		}
	}

	public boolean isSelected() {
		return this.selectedState;

	}

}