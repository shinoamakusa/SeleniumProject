package shinoamakusa.selenium.pageobjects.autotrader.uk.results;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

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
		filters = new ResultsFilters(driver);
		closeModal();
	}

	public boolean sortOrderValid(boolean descending) {
		By containerLocator = ByLocator.className("search-page__results");
		By locator = ByLocator.className("finance-price");

		if (driver.findByLocator(containerLocator).hasUpdated()) {
			PageElement.elementCountEquals(locator, 10);
		}

		List<Integer> values = new ArrayList<Integer>();
		List<PageElement> elements = driver.findAllByLocator(locator);
		for (PageElement element : elements) {
			int value = Integer.parseInt(StringUtils.substringBetween(element.getText(), "£", "per").trim());
			values.add(value);
		}

		if (descending)
			return Ordering.natural().reverse().isOrdered(values);
		else
			return Ordering.natural().isOrdered(values);

	}
	
	public void selectMonthlySortDesc()
	{
		filters().sortFilter().select("monthly-price-desc");
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

	private void closeModal() {
		driver.click(driver.findByID("buttonno"));
		driver.click(driver.findByID("js-cookie-alert-close"));
	}

}
