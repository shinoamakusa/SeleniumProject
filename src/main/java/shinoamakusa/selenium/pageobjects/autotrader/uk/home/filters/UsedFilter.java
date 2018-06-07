package shinoamakusa.selenium.pageobjects.autotrader.uk.home.filters;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.filters.BaseFilter;

public class UsedFilter extends BaseFilter {
	public UsedFilter(BrowserDriver driver) {
		this.driver = driver;
		this.container = driver.findByAttribute("for", "oneSearchAdUsed");
	}
	
	public void select(boolean checked)
	{
		if (container.findByName("onesearchad").hasSelectedState(!checked)) {
			driver.click(container);
		}
	}

}
