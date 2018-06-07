package shinoamakusa.selenium.pageobjects.autotrader.uk.home.filters;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.pageobjects.autotrader.uk.home.filters.ModelFilter;

public class HomeFilters {

	private MakeFilter make;
	private ModelFilter model;
	private MonthlyPriceFilter monthlyPrice;
	private NearlyNewFilter nearlyNewFilter;
	private NewFilter newFilter;
	private PostalCodeFilter postal;
	private RadiusFilter radius;
	private TotalPriceFilter totalPrice;
	private UsedFilter usedFilter;

	public HomeFilters(BrowserDriver driver) {
		model = new ModelFilter(driver);
		make = new MakeFilter(driver);
		radius = new RadiusFilter(driver);
		postal = new PostalCodeFilter(driver);
		monthlyPrice = new MonthlyPriceFilter(driver);
		totalPrice = new TotalPriceFilter(driver);
		nearlyNewFilter = new NearlyNewFilter(driver);
		newFilter = new NewFilter(driver);
		usedFilter = new UsedFilter(driver);
	}

	public MakeFilter make() {
		return make;
	}

	public ModelFilter model() {
		return model;
	}

	public MonthlyPriceFilter monthlyPrice() {
		return monthlyPrice;
	}

	public NearlyNewFilter nearlyNewFilter() {
		return nearlyNewFilter;
	}

	public NewFilter newFilter() {
		return newFilter;
	}

	public PostalCodeFilter postal() {
		return postal;
	}

	public RadiusFilter radius() {
		return radius;
	}

	public TotalPriceFilter totalPrice() {
		return totalPrice;
	}

	public UsedFilter usedFilter() {
		return usedFilter;
	}

}
