package shinoamakusa.selenium.pageobjects.autotrader.uk.results.filters;

import shinoamakusa.selenium.core.drivers.BrowserDriver;

public class ResultsFilters {
	private TotalCountFilter countFilter;
	private MakeFilter make;
	private ModelFilter model;
	private PostalCodeFilter postal;
	private RadiusFilter radius;
	private SortFilter sortFilter;
	private CarOptionsFilter carFilters;

	public ResultsFilters(final BrowserDriver driver) {
		countFilter = new TotalCountFilter(driver);
		radius = new RadiusFilter(driver);
		postal = new PostalCodeFilter(driver);
		make = new MakeFilter(driver);
		model = new ModelFilter(driver);
		sortFilter = new SortFilter(driver);
		carFilters = new CarOptionsFilter(driver);

	}

	public CarOptionsFilter carFilters() {
		return carFilters;
	}

	public TotalCountFilter countFilter() {
		return countFilter;
	}

	public MakeFilter make() {
		return make;
	}

	public ModelFilter model() {
		return model;
	}

	public PostalCodeFilter postal() {
		return postal;
	}

	public RadiusFilter radius() {
		return radius;
	}

	public SortFilter sortFilter() {
		return sortFilter;
	}

}