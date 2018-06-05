package main.java.shinoamakusa.selenium.pages.autotrader.ca.results.filters;

import main.java.shinoamakusa.selenium.core.elements.PageElement;

public class BaseFilterMenu {
	private PageElement container;
	private PageElement menuOption;
	
	public BaseFilterMenu(PageElement element)
	{
		this.container = element;
		
	}
	
	public PageElement container()
	{
		return container;
	}
	
	public PageElement getOption()
	{
		return menuOption;
	}
	
	public void setOption(String value)
	{
		menuOption =  container.findByAttribute("data-dropdownvalue", value);
	}
	
	public int getFilterMenuCount() {
		return Integer.parseInt(menuOption.findByClass("option-count").getText().replaceAll("[()]", ""));

	}

}
