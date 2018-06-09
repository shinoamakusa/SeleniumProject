package shinoamakusa.selenium.pageobjects.autotrader.ca.home;

import org.openqa.selenium.By;

import shinoamakusa.selenium.core.elements.ByLocator;
import shinoamakusa.selenium.core.elements.PageElement;
import shinoamakusa.selenium.core.elements.SelectElement;
import shinoamakusa.selenium.core.pages.BasePage;
import shinoamakusa.selenium.pageobjects.autotrader.ca.results.ResultsPage;

public class HomePage extends BasePage {
	private static final By MAKE_LOCATOR = ByLocator.id("rfMakes");
	private static final By MODEL_LOCATOR = ByLocator.id("rfModel");
	private static final By PRICE_LOCATOR = ByLocator.id("rfPriceHigh");

	private static final By SUBMIT_BUTTON_LOCATOR = ByLocator.id("SearchButton");
	private static final By POSTAL_CODE_LOCATOR = ByLocator.id("locationAddress");

	public HomePage() {
		this.urlPart = "autotrader.ca";
	}

	public void open() {
		super.open();
		String homeUrl = new StringBuilder("https://").append(this.urlPart).toString();
		driver.goTo(homeUrl);
		this.title = driver.getTitle();

	}

	public ResultsPage search(final String postalCode) {
		typePostalCode(postalCode);
		submitSearch();
		return new ResultsPage(driver);
	}

	public ResultsPage search(final String make, final String model, final String price, final String postalCode) {
		selectMake(make);
		selectModel(model);
		selectPrice(price);
		typePostalCode(postalCode);
		submitSearch();
		return new ResultsPage(driver);
	}

	private void selectMake(final String make) {
		PageElement element = driver.findByLocator(MAKE_LOCATOR);
		if (element.isClickable())
			new SelectElement(element).selectOptionByValue(make);
	}

	private void selectModel(final String model) {
		PageElement element = driver.findByLocator(MODEL_LOCATOR);
		if (element.isClickable())
			new SelectElement(element).selectOptionByValue(model);
	}

	private void selectPrice(final String price) {
		PageElement element = driver.findByLocator(PRICE_LOCATOR);
		if (element.isClickable())
			new SelectElement(element).selectOptionByValue(price);
	}

	private void submitSearch() {
		driver.click(driver.findByLocator(SUBMIT_BUTTON_LOCATOR));
	}

	private void typePostalCode(final String postalCode) {
		PageElement element = driver.findByLocator(POSTAL_CODE_LOCATOR);
		driver.typeInto(element, postalCode);
	}

}
