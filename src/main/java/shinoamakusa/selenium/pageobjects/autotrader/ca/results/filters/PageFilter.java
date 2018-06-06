package main.java.shinoamakusa.selenium.pageobjects.autotrader.ca.results.filters;

import org.openqa.selenium.WebDriverException;

import main.java.shinoamakusa.selenium.core.elements.PageElement;
import main.java.shinoamakusa.selenium.core.filters.BaseFilter;

public class PageFilter extends BaseFilter {
	protected int menuOptionCount;
	protected PageFilterMenu menu;

	public PageFilter(PageElement element) {
		this.container = element;
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
