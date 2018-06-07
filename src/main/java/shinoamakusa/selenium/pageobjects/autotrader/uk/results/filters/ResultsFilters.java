package shinoamakusa.selenium.pageobjects.autotrader.uk.results.filters;

import shinoamakusa.selenium.core.drivers.BrowserDriver;

public class ResultsFilters {
	private TotalCountFilter countFilter;
	private RadiusFilter radius;
	private PostalCodeFilter postal;
	private MakeFilter make;
	private ModelFilter model;

	public ResultsFilters(BrowserDriver driver) {
		countFilter = new TotalCountFilter(driver);
		radius = new RadiusFilter(driver);
		postal = new PostalCodeFilter(driver);
		make = new MakeFilter(driver);
		model = new ModelFilter(driver);

	}

	public TotalCountFilter countFilter() {
		return countFilter;
	}

	public RadiusFilter radius() {
		return radius;
	}

	public PostalCodeFilter postal() {
		return postal;
	}

	public MakeFilter make() {
		return make;
	}

	public ModelFilter model() {
		return model;
	}

}