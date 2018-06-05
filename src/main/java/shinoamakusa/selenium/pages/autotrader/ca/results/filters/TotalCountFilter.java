package main.java.shinoamakusa.selenium.pages.autotrader.ca.results.filters;

import main.java.shinoamakusa.selenium.core.drivers.BrowserDriver;

public class TotalCountFilter extends BaseFilter {
	
	public TotalCountFilter(BrowserDriver driver) {
		this.driver = driver;
		this.container =  driver.findByID("sbCount");
	}

	public boolean changedFrom(String text) {
		return container.textNotEqual(text);
	}

	public boolean equalsTo(String text)
	{
		return container.textContains(text);
	}

	public int getValue() {
		return Integer.parseInt(container.getText().replaceAll(",", ""));

	}

}
