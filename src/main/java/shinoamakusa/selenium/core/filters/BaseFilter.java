package shinoamakusa.selenium.core.filters;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.elements.PageElement;

public class BaseFilter {
	
	protected BrowserDriver driver;
	protected PageElement container;

	public BaseFilter(PageElement element) {
		this.container = element;
	}
	
	public BaseFilter() {

	}

}
