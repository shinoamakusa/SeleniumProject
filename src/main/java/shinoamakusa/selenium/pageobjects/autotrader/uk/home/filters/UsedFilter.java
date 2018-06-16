package shinoamakusa.selenium.pageobjects.autotrader.uk.home.filters;

import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByChained;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.elements.ByLocator;

public class UsedFilter extends CarOptionsFilter {

	public UsedFilter(BrowserDriver driver) {
		super(driver);
		this.locator = ByLocator.attribute("for", "oneSearchAdUsed");
	}

	public UsedFilter(final BrowserDriver driver, final By parentLocator) {
		this(driver);
		this.locator = new ByChained(parentLocator, this.locator);
	}

}
