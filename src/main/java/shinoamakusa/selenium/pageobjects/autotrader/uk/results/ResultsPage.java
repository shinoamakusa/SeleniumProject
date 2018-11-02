package shinoamakusa.selenium.pageobjects.autotrader.uk.results;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SortOrder;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByChained;

import com.google.common.collect.Ordering;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.elements.ByLocator;
import shinoamakusa.selenium.core.elements.BaseElement;
import shinoamakusa.selenium.core.pages.BasePage;
import shinoamakusa.selenium.pageobjects.autotrader.uk.results.filters.ResultsFilters;

public class ResultsPage extends BasePage {

	private static final By RESULTS_DISPLAY_LOCATOR = ByLocator.className("search-page__results");
	private static final By RESULTS_ENTRY_LOCATOR = ByLocator.attribute("data-standout-type", "");
	private ResultsFilters filters;

	public ResultsPage(final BrowserDriver driver) {
		this.partialURL = "autotrader.co.uk/car-search";
		this.driver = driver;
		this.title = this.driver.getTitle();
		this.url = this.driver.getUrl();
		filters = new ResultsFilters(driver);
		closeModal();
	}

	public List<String> carFilters() {
		return filters.carFilters().getSelectedFilters();
	}

	public boolean carFiltersContain(final List<String> compareList) {
		List<String> list = carFilters();
		list.removeAll(compareList);
		return list.isEmpty();

	}

	public String count() {
		return filters.countFilter().value();
	}

	public boolean isSortOrder(final SortOrder direction) {

		List<Integer> values = getEntryPrices();

		switch (direction) {
		case DESCENDING:
			return Ordering.natural().reverse().isOrdered(values);
		case ASCENDING:
			return Ordering.natural().isOrdered(values);
		default:
			return false;
		}
	}

	public String make() {
		return filters.make().value();
	}
	
	public String model() {
		return filters.model().value();
	}

	public String postalCode() {
		return filters.postal().value();
	}

	public String radius() {
		return filters.radius().value();
	}

	public void selectMonthlyPriceHighest() {
		filters.sortFilter().select("monthly-price-desc");
	}

	public void selectTotalPriceLowest() {
		filters.sortFilter().select("price-asc");
	}

	private void closeModal() {
		// driver.click(driver.findByID("buttonno"));
		if (this.url.contains("total-price"))
			driver.click(driver.findByAttribute("data-label", "finance-search-callout"));
		driver.click(driver.findByID("js-cookie-alert-close"));
	}

	private List<BaseElement> findAllEntryPrices()
	{
		By locator;
		if (this.url.contains("total-price"))
			locator = new ByChained(RESULTS_ENTRY_LOCATOR, ByLocator.className("vehicle-price"));
		else
			locator = new ByChained(RESULTS_ENTRY_LOCATOR, ByLocator.className("finance-price"));
		return driver.findAllByLocator(locator);
	}

	private List<Integer> getEntryPrices() {

		waitForResultsListToUpdate(); 
	

		List<Integer> values = new ArrayList<Integer>();
		List<BaseElement> elements = findAllEntryPrices();
		
		for (BaseElement element : elements) {
			int value;
			if (this.url.contains("total-price"))
				value = Integer.parseInt(element.getText().substring(1).replaceAll(",", "").trim());
			else
				value = Integer.parseInt(
						StringUtils.substringBetween(element.getText(), "£", "per").replaceAll(",", "").trim());
			values.add(value);
		}

		return values;
	}

	private void waitForResultsListToUpdate() {
		if (driver.findByLocator(RESULTS_DISPLAY_LOCATOR).hasUpdated()) {
			BaseElement.elementCountEquals(RESULTS_ENTRY_LOCATOR, 10);
		}
	}

}
