package shinoamakusa.selenium.framework.drivers;

import java.util.HashSet;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import shinoamakusa.selenium.framework.drivers.PageDriver;
import shinoamakusa.selenium.framework.elements.PageElement;

/**
 * Class representing a browser instance Wrapper class for Selenium WebDriver
 * 
 * @author Oleg Kravenkov
 *
 */
public class BrowserDriver extends PageDriver {

	/**
	 * Default ChromeDriver location
	 */
	private static final String CHROME_DRIVER_PATH = "D:\\Projects\\Selenium\\Drivers\\chromedriver.exe";

	/**
	 * Default EdgeDriver location
	 */
	private static final String EDGE_DRIVER_PATH = "D:\\Projects\\Selenium\\Drivers\\MicrosoftWebDriver.exe";

	/**
	 * Default FirefoxDriver location
	 */
	private static final String FIREFOX_DRIVER_PATH = "D:\\Projects\\Selenium\\Drivers\\geckodriver.exe";

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
			System.setProperty("webdriver.chrome.driver",
					StringUtils.isBlank(driverPath) ? CHROME_DRIVER_PATH : driverPath);
			break;
		case Firefox:
			System.setProperty("webdriver.gecko.driver",
					StringUtils.isBlank(driverPath) ? FIREFOX_DRIVER_PATH : driverPath);
			break;
		case Edge:
			System.setProperty("webdriver.edge.driver",
					StringUtils.isBlank(driverPath) ? EDGE_DRIVER_PATH : driverPath);
			break;
		default:
			break;

		}
		this.type = type;
		history = new HashSet<String>();
	}

	/**
	 * Clicks the element provided
	 * 
	 * @param element
	 *            Web page element to click
	 * @return Url string if element is link, empty string otherwise
	 */
	public String click(final PageElement element) {
		if (element != null) {
			String link = StringUtils.EMPTY;
			if (element.getTag().equalsIgnoreCase("a")) {
				link = element.getAttribute("href");
			}

			if (element.isClickable())
				element.click();

			if (!StringUtils.isBlank(link))
				history.add(link);

			if (selectedElement != null && selectedElement.isStale()) {
				selectedElement = null;
			}

			if (parentElement != null && parentElement.isStale()) {
				parentElement = null;
			}
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
	 * @param element
	 *            Page element to perform code on
	 */
	public void executeJS(final String code, PageElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(code, element.getElement());
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
			select(null);
			setParentElement(null);
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
	 *            Search textarea element to fill in
	 * @param searchButton
	 *            Search submit button element
	 * @param searchQuery
	 *            Query to perform search on
	 */
	public void search(final PageElement searchBox, final PageElement searchButton, final String searchQuery) {
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
	 * Sends/types in keys into the element specified
	 * 
	 * @param element
	 *            Element to fill in
	 * @param keys
	 *            Text string to fill in
	 */
	public void typeInto(final PageElement element, final String keys) {
		if (element.getElement() != null && !StringUtils.isBlank(keys)) {
			element.click();
			element.getElement().clear();
			element.getElement().sendKeys(keys);
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
		wait = new WebDriverWait(driver, 30);
	}
}
