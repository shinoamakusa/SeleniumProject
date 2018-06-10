package shinoamakusa.selenium.pageobjects.autotrader.uk.home.filters;

import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByChained;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.elements.ByLocator;
import shinoamakusa.selenium.core.elements.BaseElement;
import shinoamakusa.selenium.core.filters.BaseFilter;

public class NewFilter extends BaseFilter {
	
	private boolean selectedState = true;
	public NewFilter(BrowserDriver driver) {
		this.driver = driver;
		this.locator = ByLocator.attribute("for", "oneSearchAdBrandNew");
	}
	
	public NewFilter(BrowserDriver driver, By parentLocator) {
		this(driver);
		this.locator = new ByChained(parentLocator, this.locator);
	}
	
	public void select(boolean state)
	{
		BaseElement container = driver.findByLocator(this.locator);
		if (container.findByName("onesearchad").hasSelectedState(!state)) {
			driver.click(container);
			this.selectedState = state;
		}
	}
	public boolean isSelected() {
		return this.selectedState;

	}
}
