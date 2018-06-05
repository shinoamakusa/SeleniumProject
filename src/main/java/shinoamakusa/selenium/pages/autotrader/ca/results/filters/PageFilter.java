package main.java.shinoamakusa.selenium.pages.autotrader.ca.results.filters;

import org.openqa.selenium.WebDriverException;

import main.java.shinoamakusa.selenium.core.drivers.BrowserDriver;
import main.java.shinoamakusa.selenium.core.elements.PageElement;

public class PageFilter {

	protected BrowserDriver driver;
	protected int menuOptionCount;
	protected PageFilterMenu menu;
	protected PageElement filterElement;

	public PageFilter(PageElement element) {
		this.filterElement = element;
	}

	public PageFilter() {

	}

	public int getMenuOptionResultsCount() {
		return menuOptionCount;
	}

	protected void checkForModal() {
		driver.click(driver.findByClass("acsCloseButton"));
	}

	protected void chooseMenuOption(final String value) {
		try {
			menu = new PageFilterMenu(filterElement.findByClass("dropdown-menu"));
			menu.setOption(value);
			menuOptionCount = menu.getFilterMenuCount();
			driver.click(menu.getOption());
		} catch (WebDriverException e) {
			checkForModal();
			chooseMenuOption(value);
		}

	}

}
