package shinoamakusa.selenium.pageobjects.autotrader.uk.home.filters;

import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByChained;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.elements.ByLocator;

public class NearlyNewFilter extends CarOptionsFilter {
	
	public NearlyNewFilter(BrowserDriver driver) {
		super(driver);
		this.locator = ByLocator.attribute("for", "oneSearchAdNearlyNew");
	}
	
	public NearlyNewFilter(BrowserDriver driver, By parentLocator) {
		this(driver);
		this.locator = new ByChained(parentLocator, this.locator);
	}

}
