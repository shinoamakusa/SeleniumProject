package shinoamakusa.selenium.pageobjects.autotrader.uk.home.filters;

import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByChained;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.elements.LabelElement;
import shinoamakusa.selenium.core.filters.BaseFilter;

public class CarOptionsFilter extends BaseFilter {
	
	protected boolean selectedState = true;
	
	public CarOptionsFilter()
	{
		super();
	}
	
	public CarOptionsFilter(final BrowserDriver driver) {
		super(driver);
	}
	public CarOptionsFilter(final BrowserDriver driver, final By parentLocator) {
		this(driver);
		this.locator = new ByChained(parentLocator, this.locator);
	}
	
	public boolean isSelected() {
		return this.selectedState;

	}
	
	public void select(final boolean state) {
		LabelElement container = driver.findByLocator(this.locator).toLabelElement();
		if (!container.hasSelectedState(state)) {
			driver.click(container);
			this.selectedState = state;
		}
	}

}
