package main.java.shinoamakusa.selenium.pages.autotrader.ca.results.filters;

import main.java.shinoamakusa.selenium.core.drivers.BrowserDriver;

public class TotalCountFilter extends PageFilter {
	
	public TotalCountFilter(BrowserDriver driver) {
		this.driver = driver;
		this.filterElement =  driver.findByID("sbCount");
	}

	public boolean changedFrom(String text) {
		return filterElement.textNotEqual(text);
	}

	public boolean equalsTo(String text)
	{
		return filterElement.textContains(text);
	}

	public int getValue() {
		return Integer.parseInt(filterElement.getText().replaceAll(",", ""));

	}

}
