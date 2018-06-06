package main.java.shinoamakusa.selenium.core.filters;

import main.java.shinoamakusa.selenium.core.drivers.BrowserDriver;
import main.java.shinoamakusa.selenium.core.elements.PageElement;

public class BaseFilter {
	
	protected BrowserDriver driver;
	protected PageElement container;

	public BaseFilter(PageElement element) {
		this.container = element;
	}
	
	public BaseFilter() {

	}

}
