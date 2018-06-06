package main.java.shinoamakusa.selenium.pages.autotrader.uk.results.filters;

import main.java.shinoamakusa.selenium.core.drivers.BrowserDriver;
import main.java.shinoamakusa.selenium.core.elements.PageElement;
import main.java.shinoamakusa.selenium.core.filters.BaseFilter;

public class PageFilter extends BaseFilter {
	
	public PageFilter(BrowserDriver driver)
	{
		this.driver = driver;
	}
	
	public PageFilter(PageElement element)
	{
		this.container = element;
	}
	
	public PageFilter()
	{
		
	}

}
