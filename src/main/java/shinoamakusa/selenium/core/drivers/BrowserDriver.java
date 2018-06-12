package shinoamakusa.selenium.core.drivers;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import shinoamakusa.selenium.core.elements.BaseElement;
import shinoamakusa.selenium.core.elements.ButtonElement;
import shinoamakusa.selenium.core.elements.TextInputElement;

/**
 * Class representing a browser instance Wrapper class for Selenium WebDriver
 * 
 * @author Oleg Kravenkov
 *
 */
public class BrowserDriver extends BaseDriver {

	/**
	 * Page navigation history
	 */
	private HashSet<String> history;

	/**
	 * Browser type
	 */
	private DriverType type;

	/**
	 * Browser class constructor
	 */
	public BrowserDriver() {
		this(DriverType.Chrome);
	}

	/**
	 * Browser class constructor
	 * 
	 * @param type
	 *            Type of browser
	 */
	public BrowserDriver(final DriverType type) {
		this(type, null);
	}

	/**
	 * Browser class constructor
	 * 
	 * @param type
	 *            Type of browser
	 * @param driverPath
	 *            Browser WebDriver location
	 */
	public BrowserDriver(final DriverType type, final String driverPath) {
		switch (type) {
		case Chrome:
			WebDriverManager.chromedriver().version("2.40").setup();
			break;
		case Firefox:
			WebDriverManager.firefoxdriver().version("0.20.1").setup();
			break;
		case Edge:
			WebDriverManager.edgedriver().version("6.17134").setup();
			break;
		default:
			break;

		}
		this.type = type;
		history = new HashSet<String>();
	}

	/**
	 * Clicks the container provided
	 * 
	 * @param container
	 *            Web page container to click
	 * @return Url string if container is link, empty string otherwise
	 */
	public String click(final BaseElement element) {
		if (element != null) {
			String link = StringUtils.EMPTY;
			if (element.getTag().equalsIgnoreCase("a")) {
				link = element.getAttribute("href");
			}

			if (element.isVisible() && element.isClickable() && element.webElement().isEnabled())
				element.click();

			if (!StringUtils.isBlank(link))
				history.add(link);
			return link;
		}

		return StringUtils.EMPTY;

	}

	/**
	 * Closes browser window
	 */
	public void close() {
		if (driver != null) {
			driver.quit();
		}
	}

	public void takeScreenshot(String fileName) {
		TakesScreenshot sDriver = (TakesScreenshot) driver;
		File src = sDriver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File(fileName));
		} catch (IOException e)

		{
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Executes Javascript code
	 * 
	 * @param code
	 *            JS code
	 */
	public void executeJS(final String code) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(code);
	}

	/**
	 * Executes Javascript code
	 * 
	 * @param code
	 *            JS code
	 * 
	 * @param container
	 *            Page container to perform code on
	 */
	public void executeJS(final String code, BaseElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(code, element.webElement());
	}

	/**
	 * Gets URL history
	 * 
	 * @return url history hashset
	 */
	public HashSet<String> getHistory() {
		return history;
	}

	/**
	 * Navigates to specified Url
	 * 
	 * @param url
	 *            Url to navigate to
	 */
	public void goTo(final String url) {
		if (driver != null && !StringUtils.isBlank(url)) {
			driver.get(url);
			history.add(url);
		}
	}

	/**
	 * Opens browser window
	 */
	public void open() {
		switch (this.type) {
		case Chrome:
			initialize(new ChromeDriver());
			break;
		case Firefox:
			initialize(new FirefoxDriver());
			break;
		case Edge:
			initialize(new EdgeDriver());
			break;
		default:
			break;

		}
		if (driver != null) {
			driver.manage().window().maximize();
		}
	}

	/**
	 * Opens browser window in private mode
	 * 
	 * @param inPrivate
	 *            Browser private mode on/off
	 */
	public void open(final boolean inPrivate) {
		if (inPrivate) {
			switch (this.type) {
			case Chrome:
				ChromeOptions options = new ChromeOptions();
				options.addArguments("incognito");
				initialize(new ChromeDriver(options));
				break;
			case Firefox:
				FirefoxOptions opts = new FirefoxOptions();
				opts.addArguments("-private");
				initialize(new FirefoxDriver(opts));
				break;
			case Edge:
				initialize(new EdgeDriver()); // No way to run Edge inPrivate from WD yet so open normal window
				break;
			default:
				break;

			}
			if (driver != null) {
				driver.manage().window().maximize();
			}
		} else {
			open();
		}
	}

	/**
	 * Performs a search action on the page
	 * 
	 * @param searchBox
	 *            Search textarea container to fill in
	 * @param searchButton
	 *            Search submit button container
	 * @param searchQuery
	 *            Query to perform search on
	 */
	public void search(final TextInputElement searchBox, final ButtonElement searchButton, final String searchQuery) {
		typeInto(searchBox, searchQuery);
		click(searchButton);
	}

	/**
	 * Switches driver to iframe document
	 * 
	 * @param iframe
	 *            Iframe Element
	 */
	public void switchTo(final WebElement iframe) {
		if (driver != null)
			driver.switchTo().frame(iframe);
	}

	/**
	 * Switches driver back to main document
	 */
	public void switchToMain() {
		if (driver != null)
			driver.switchTo().defaultContent();
	}

	/**
	 * Sends/types in keys into the container specified
	 * 
	 * @param container
	 *            Element to fill in
	 * @param keys
	 *            Text string to fill in
	 */
	public void typeInto(final TextInputElement element, final String keys) {
		if (element != null && !StringUtils.isBlank(keys)) {
			element.enterText(keys);
		}
	}

	/**
	 * Initialize WebDriver
	 * 
	 * @param webDriver
	 *            Selenium WebDriver object
	 */
	private void initialize(final WebDriver webDriver) {
		driver = webDriver;
		wait = new WebDriverWait(driver, 10);
		BaseElement.setDriver(driver, wait);
	}
}
