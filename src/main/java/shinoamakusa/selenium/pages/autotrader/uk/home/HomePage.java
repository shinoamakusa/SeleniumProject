package main.java.shinoamakusa.selenium.pages.autotrader.uk.home;

import main.java.shinoamakusa.selenium.core.elements.SelectElement;
import main.java.shinoamakusa.selenium.pages.BasePage;
import main.java.shinoamakusa.selenium.pages.autotrader.uk.results.ResultsPage;

public class HomePage extends BasePage {

	private String searchCount;

	public HomePage() {
		this.urlPart = "autotrader.co.uk";
	}

	public String getSearchCount() {
		return searchCount;
	}

	public void open() {
		super.open();
		String homeUrl = new StringBuilder("https://").append(this.urlPart).toString();
		driver.goTo(homeUrl);
		this.title = driver.getTitle();

	}
	
	
	public ResultsPage search(final String postalCode, final String radius, final String make, final String model) {
		typePostalCode(postalCode);
		
		selectRadius(radius);
		
		uncheckNearlyNew();
		uncheckNew();
		
		
		selectMake(make);

		selectModel(model);

		selectMonthlyPrice();

		driver.waitFor(5);
		
		submitSearch();

		return new ResultsPage(driver);
	}
	
	private void selectMake(final String make)
	{
		driver.select(driver.findByID("searchVehiclesMake"));
		if (driver.selectedElement().isClickable()
				&& driver.selectedElement().findByAttribute("value", make).exists()) {
			new SelectElement(driver.selectedElement()).selectOptionByValue(make);
		}
	}
	
	private void selectModel(final String model)
	{
		driver.select(driver.findByID("searchVehiclesModel"));
		if (driver.selectedElement().isClickable()
				&& driver.selectedElement().findByAttribute("value", model).exists()) {
			new SelectElement(driver.selectedElement()).selectOptionByValue(model);
		}
	}
	
	private void selectMonthlyPrice()
	{
		driver.click(driver.findByAttribute("for", "searchVehiclesPriceTypeMonthly"));
	}
	
	private void selectRadius(final String radius)
	{
		driver.select(driver.findByID("radius"));
		if (driver.selectedElement().isClickable()
				&& driver.selectedElement().findByAttribute("value", radius).exists()) {
			new SelectElement(driver.selectedElement()).selectOptionByValue(radius);
		}
	}
	
	private void submitSearch()
	{
		driver.select(driver.findByID("js-search-button"));
		searchCount = driver.selectedElement().getText().split(" ")[1];

		driver.click(driver.selectedElement());
	}
	
	private void typePostalCode(String postalCode)
	{
		driver.typeInto(driver.findByID("postcode"), postalCode);
	}
	
	private void uncheckNearlyNew()
	{
		driver.click(driver.findByAttribute("for", "oneSearchAdNearlyNew"));
	}

	private void uncheckNew()
	{
		driver.click(driver.findByAttribute("for", "oneSearchAdBrandNew"));

	}

}
