package shinoamakusa.selenium.pageobjects.autotrader.uk.home.filters;

import java.util.ArrayList;
import java.util.List;

import shinoamakusa.selenium.core.drivers.BrowserDriver;

public class CarFilters {
	private NearlyNewFilter nearlyNewFilter;
	private NewFilter newFilter;
	private UsedFilter usedFilter;

	public CarFilters(BrowserDriver driver) {
		nearlyNewFilter = new NearlyNewFilter(driver);
		newFilter = new NewFilter(driver);
		usedFilter = new UsedFilter(driver);
	}

	public NearlyNewFilter nearlyNewFilter() {
		return nearlyNewFilter;
	}

	public NewFilter newFilter() {
		return newFilter;
	}

	public UsedFilter usedFilter() {
		return usedFilter;
	}

	public List<String> getSelectedFilters() {
		List<String> filters = new ArrayList<String>();

		if (usedFilter.isSelected())
			filters.add(usedFilter.getText());
		if (nearlyNewFilter.isSelected())
			filters.add(nearlyNewFilter.getText());
		if (newFilter.isSelected())
			filters.add(newFilter.getText());
		return filters;

	}

}
