package main.java.shinoamakusa.selenium.pages.autotrader.uk.results.filters;

import main.java.shinoamakusa.selenium.core.drivers.BrowserDriver;

public class ResultsFilters {
	private TotalCountFilter countFilter;
	private RadiusFilter radius;

	public ResultsFilters(BrowserDriver driver) {
		countFilter = new TotalCountFilter(driver);
		radius = new RadiusFilter(driver);

	}

	public TotalCountFilter countFilter() {
		return countFilter;
	}
	
	public RadiusFilter radius()
	{
		return radius;
	}

}