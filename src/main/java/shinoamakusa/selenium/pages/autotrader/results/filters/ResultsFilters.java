package main.java.shinoamakusa.selenium.pages.autotrader.results.filters;

import main.java.shinoamakusa.selenium.framework.drivers.BrowserDriver;

public class ResultsFilters {

	private MakeFilter make;
	private ModelFilter model;
	private PostalCodeFilter postalCode;
	private YearFilter year;

	public ResultsFilters(BrowserDriver driver) {
		make = new MakeFilter(driver);
		model = new ModelFilter(driver);
		year = new YearFilter(driver);
		postalCode = new PostalCodeFilter(driver);
	}

	public boolean contain(final String make, final String model, final String postalCode) {
		return this.postalCode.isSelected(postalCode) && this.make.isSelected(make) && this.model.isSelected(model);
	}

	public int getMenuResultsCount() {
		if (model.getMenuResultsCount() != 0)
			return model.getMenuResultsCount();
		else
			return make.getMenuResultsCount();
	}

	public MakeFilter make() {
		return make;
	}
	
	public ModelFilter model() {
		return model;
	}

	public PostalCodeFilter postalCode()
	{
		return postalCode;
	}

	public YearFilter year() {
		return year;
	}

}
