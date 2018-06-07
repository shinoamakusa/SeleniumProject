package shinoamakusa.selenium.pageobjects.autotrader.uk.home.filters;

import shinoamakusa.selenium.core.drivers.BrowserDriver;

public class CarFilters {
	private NearlyNewFilter nearlyNewFilter;
	private NewFilter newFilter;
	private UsedFilter usedFilter;
	
	public CarFilters(BrowserDriver driver) {
		nearlyNewFilter = new NearlyNewFilter(driver);
		newFilter = new NewFilter(driver);
		usedFilter = new UsedFilter(driver);
	}
	
	public NearlyNewFilter nearlyNewFilter() {
		return nearlyNewFilter;
	}

	public NewFilter newFilter() {
		return newFilter;
	}
	
	public UsedFilter usedFilter() {
		return usedFilter;
	}

}
