package main.java.shinoamakusa.selenium.pages.autotrader.uk.results.filters;

import main.java.shinoamakusa.selenium.core.drivers.BrowserDriver;
import main.java.shinoamakusa.selenium.core.elements.PageElement;

public class BaseFilter {
	protected PageElement container;
	protected BrowserDriver driver;
	
	public BaseFilter(BrowserDriver driver)
	{
		this.driver = driver;
	}
	
	public BaseFilter(PageElement element)
	{
		this.container = element;
	}
	
	public BaseFilter()
	{
		
	}

}
