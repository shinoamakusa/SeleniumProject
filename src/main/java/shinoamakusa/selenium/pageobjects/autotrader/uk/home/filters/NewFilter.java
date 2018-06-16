package shinoamakusa.selenium.pageobjects.autotrader.uk.home.filters;

import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByChained;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.elements.ByLocator;

public class NewFilter extends CarOptionsFilter {
	public NewFilter(BrowserDriver driver) {
		super(driver);
		this.locator = ByLocator.attribute("for", "oneSearchAdBrandNew");
	}
	
	public NewFilter(final BrowserDriver driver, final By parentLocator) {
		this(driver);
		this.locator = new ByChained(parentLocator, this.locator);
	}
}
