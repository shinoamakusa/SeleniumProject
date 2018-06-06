package shinoamakusa.selenium.core.pages;

import shinoamakusa.selenium.core.drivers.BrowserDriver;
import shinoamakusa.selenium.core.drivers.DriverType;

public class BasePage {
	protected BrowserDriver driver;
	protected String sourceHTML;
	protected String title;
	protected String url;
	protected String urlPart;
	
	public BasePage()
	{
		driver =  new BrowserDriver(DriverType.Chrome);
	}
	
	public void close()
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.close();
	}
	
	public boolean isValidPage()
	{
		return driver.urlContains(this.urlPart);
	}
	
	public void open()
	{
		driver.open();
	}

}
