package shinoamakusa.selenium.pageobjects.autotrader.ca.results.filters;

import org.openqa.selenium.WebDriverException;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.elements.BaseElement;
import shinoamakusa.selenium.core.filters.BaseFilter;

public class PageFilter extends BaseFilter {
	protected int menuOptionCount;
	protected PageFilterMenu menu;

	public PageFilter() {

	}
	
	public PageFilter(BrowserDriver driver)
	{
		super(driver);
	}

	public int getMenuOptionResultsCount() {
		return menuOptionCount;
	}

	protected void checkForModal() {
		driver.click(driver.findByClass("acsCloseButton"));
	}

	protected void chooseMenuOption(final String value) {
		try {
			BaseElement container = driver.findByLocator(this.locator);
			menu = new PageFilterMenu(container.findByClass("dropdown-menu"));
			menu.setOption(value);
			menuOptionCount = menu.getFilterMenuCount();
			driver.click(menu.getOption());
		} catch (WebDriverException e) {
			checkForModal();
			chooseMenuOption(value);
		}

	}

}
