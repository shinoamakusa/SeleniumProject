package main.java.shinoamakusa.selenium.pages;

import main.java.shinoamakusa.selenium.core.drivers.BrowserDriver;
import main.java.shinoamakusa.selenium.core.drivers.DriverType;

public class BrowserPage {
	protected BrowserDriver driver;
	protected String sourceHTML;
	protected String title;
	protected String url;
	protected String urlPart;
	
	public BrowserPage()
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
