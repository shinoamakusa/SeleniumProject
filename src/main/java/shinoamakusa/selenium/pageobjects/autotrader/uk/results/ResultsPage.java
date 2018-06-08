package shinoamakusa.selenium.pageobjects.autotrader.uk.results;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByChained;

import com.google.common.collect.Ordering;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.elements.ByLocator;
import shinoamakusa.selenium.core.elements.PageElement;
import shinoamakusa.selenium.core.pages.BasePage;
import shinoamakusa.selenium.pageobjects.autotrader.uk.results.filters.ResultsFilters;

public class ResultsPage extends BasePage {

	private ResultsFilters filters;

	public ResultsPage(final BrowserDriver driver) {
		this.urlPart = "autotrader.co.uk/car-search";
		this.driver = driver;
		this.title = this.driver.getTitle();
		this.url = this.driver.getUrl();
		filters = new ResultsFilters(driver);
		closeModal();
	}

	public boolean carFiltersContain(List<String> compareList) {
		List<String> list = getSelectedCarFilters();
		list.removeAll(compareList);
		return list.isEmpty();

	}

	public boolean countContains(String value) {
		return filters().countFilter().contains(value);
	}

	public ResultsFilters filters() {
		return filters;
	}

	public boolean isMakeSelected(String make) {
		return filters().make().isSelected(make);
	}

	public boolean isModelSelected(String model) {
		return filters().model().isSelected(model);
	}

	public boolean isPostalCode(String postalCode) {
		return filters().postal().isSelected(postalCode);
	}

	public boolean isRadiusSelected(String radius) {
		return filters().radius().isSelected(radius);
	}

	public void selectMonthlyPriceHighest() {
		filters().sortFilter().select("monthly-price-desc");
	}

	public void selectTotalPriceLowest() {
		filters().sortFilter().select("price-asc");
	}

	public boolean sortOrderDescending(boolean descending) {
		By containerLocator = ByLocator.className("search-page__results");
		By locator = ByLocator.attribute("data-standout-type", "");

		if (driver.findByLocator(containerLocator).hasUpdated()) {
			PageElement.elementCountEquals(locator, 10);
		}

		if (this.url.contains("total-price"))
			locator = new ByChained(locator, ByLocator.className("vehicle-price"));
		else
			locator = new ByChained(locator, ByLocator.className("finance-price"));

		List<Integer> values = new ArrayList<Integer>();
		List<PageElement> elements = driver.findAllByLocator(locator);
		for (PageElement element : elements) {
			int value;
			if (this.url.contains("total-price"))
				value = Integer.parseInt(element.getText().substring(1).trim());
			else
				value = Integer.parseInt(StringUtils.substringBetween(element.getText(), "�", "per").trim());
			values.add(value);
		}

		if (descending)
			return Ordering.natural().reverse().isOrdered(values);
		else
			return Ordering.natural().isOrdered(values);

	}

	private void closeModal() {
		driver.click(driver.findByID("buttonno"));
		if (this.url.contains("total-price"))
			driver.click(driver.findByAttribute("data-label", "finance-search-callout"));
		driver.click(driver.findByID("js-cookie-alert-close"));
	}

	private List<String> getSelectedCarFilters() {
		return filters().carFilters().getSelectedFilters();
	}

}