package shinoamakusa.selenium.pageobjects.autotrader.ca.results.filters;

import shinoamakusa.selenium.core.elements.BaseElement;

public class PageFilterMenu {
	private BaseElement container;
	private BaseElement menuOption;
	
	public PageFilterMenu(BaseElement element)
	{
		this.container = element;
		
	}
	
	public BaseElement container()
	{
		return container;
	}
	
	public BaseElement getOption()
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
