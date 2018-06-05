package main.java.shinoamakusa.selenium.pages.autotrader.ca.results.filters;

import main.java.shinoamakusa.selenium.core.elements.PageElement;

public class PageFilterMenu {
	private PageElement element;
	private PageElement menuOption;
	
	public PageFilterMenu(PageElement element)
	{
		this.element = element;
		
	}
	
	public PageElement element()
	{
		return element;
	}
	
	public PageElement getOption()
	{
		return menuOption;
	}
	
	public void setOption(String value)
	{
		menuOption =  element.findByAttribute("data-dropdownvalue", value);
	}
	
	public int getFilterMenuCount() {
		return Integer.parseInt(menuOption.findByClass("option-count").getText().replaceAll("[()]", ""));

	}

}
