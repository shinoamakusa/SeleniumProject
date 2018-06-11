package shinoamakusa.selenium.core.elements;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Class representing a page container ( Selenium WebElement)
 * 
 * @author Oleg Kravenkov
 *
 */
public class BaseElement {

	protected static WebDriver driver;
	protected static WebDriverWait wait;

	/**
	 * Checks if certain number of elements exist in DOM
	 * 
	 * @param locator
	 *            ByLocator for elements
	 * @param count
	 *            Number of elements expected to exist
	 * @return true if specified number of elements exists, false otherwise
	 */
	public static boolean elementCountEquals(final By locator, final int count) {
		try {
			wait.until(ExpectedConditions.numberOfElementsToBe(locator, count));
			return true;
		} catch (TimeoutException t) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
	}

	/**
	 * Checks if number of elements existing in DOM is less than amount
	 * 
	 * @param locator
	 *            ByLocator for elements
	 * @param count
	 *            Number of elements
	 * @return true if less than specified number of elements exists, false
	 *         otherwise
	 */
	public static boolean elementCountLessThan(final By locator, final int count) {
		try {
			wait.until(ExpectedConditions.numberOfElementsToBeLessThan(locator, count));
			return true;
		} catch (TimeoutException t) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
	}

	/**
	 * Checks if number of elements existing in DOM is more than amount
	 * 
	 * @param locator
	 *            ByLocator for elements
	 * @param count
	 *            Number of elements
	 * @return true if more than specified number of elements exists, false
	 *         otherwise
	 */
	public static boolean elementCountMoreThan(final By locator, final int count) {
		try {
			wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, count));
			return true;
		} catch (TimeoutException t) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
	}

	/**
	 * Sets WebDriver and WebDriverWait fields
	 * 
	 * @param driver
	 *            WebDriver object
	 * @param wait
	 *            WebDriverwait object
	 */
	public static void setDriver(final WebDriver driver, final WebDriverWait wait) {
		BaseElement.driver = driver;
		BaseElement.wait = wait;
	}

	/**
	 * Selenium WebElement object
	 */
	protected WebElement element;

	/**
	 * Element locator
	 */
	protected By locator;
	/**
	 * WebElement's HTML tag
	 */
	protected String tag = "";

	/**
	 * PageElement class constructor
	 */
	public BaseElement() {

	}

	/**
	 * PageElement class constructor
	 * 
	 * @param container
	 *            Selenium WebElement object
	 */
	public BaseElement(final WebElement element) {
		this.element = element;
		if (this.element != null) {
			this.tag = element.getTagName();
		}
	}

	public BaseElement(final WebElement element, final By locator) {
		this.element = element;
		if (this.element != null) {
			this.tag = element.getTagName();
			this.locator = locator;
		}
	}

	/**
	 * PageElement class constructor
	 * 
	 * @param container
	 *            Selenium WebElement
	 * @param driver
	 *            Selenium WebDriver container
	 */
	public BaseElement(final WebElement element, final WebDriver driver) {
		this.element = element;
		BaseElement.driver = driver;
		BaseElement.wait = new WebDriverWait(BaseElement.driver, 30);
		if (this.element != null) {
			this.tag = element.getTagName();
		}
	}

	/**
	 * PageElement class constructor
	 * 
	 * @param container
	 *            Selenium WebElement
	 * @param driver
	 *            Selenium WebDriver container
	 * @param wait
	 *            Selenium WebDriverWait container
	 */
	public BaseElement(final WebElement element, final WebDriver driver, final WebDriverWait wait) {
		this.element = element;
		BaseElement.driver = driver;
		BaseElement.wait = wait;
		if (this.element != null) {
			this.tag = element.getTagName();
		}
	}

	/**
	 * Clicks element
	 */
	public void click() {
		if (element != null && this.isClickable())
			element.click();
	}

	/**
	 * Check if container actually exists
	 * 
	 * @return True if webelement is not null, false otherwise
	 */
	public boolean exists() {
		return element != null;
	}

	/**
	 * Finds all page elements by attribute value
	 * 
	 * @param attributeName
	 *            Attribute name
	 * @param attributeValue
	 *            Attribute value
	 * @return List of page elements matched
	 */
	public List<BaseElement> findAllByAttribute(final String attributeName, final String attributeValue) {
		return findAll(ByLocator.attribute(attributeName, attributeValue));
	}

	/**
	 * Finds all page elements by CSS class name
	 * 
	 * @param className
	 *            CSS class name
	 * @return List of page elements matched
	 */
	public List<BaseElement> findAllByClass(final String className) {
		return findAll(ByLocator.className(className));
	}

	/**
	 * Finds all page elements by CSS class name
	 * 
	 * @param cssSelector
	 *            CSS class name
	 * @return List of page elements matched
	 */
	public List<BaseElement> findAllByCssSelector(final String cssSelector) {
		return findAll(ByLocator.cssSelector(cssSelector));
	}

	/**
	 * Finds all page elements by ID attribute
	 * 
	 * @param id
	 *            Value of ID attribute
	 * @return List of page elements matched
	 */
	public List<BaseElement> findAllByID(final String id) {
		return findAll(ByLocator.id(id));
	}

	/**
	 * Finds page elements matched by a locator
	 * 
	 * @param locator
	 *            ByLocator
	 * @return List of matched elements, null otherwise
	 */
	public List<BaseElement> findAllByLocator(final By locator) {
		return findAll(locator);
	}

	/**
	 * Finds all page elements by NAME attribute
	 * 
	 * @param name
	 *            Value of NAME attribute
	 * @return List of page elements matched
	 */
	public List<BaseElement> findAllByName(final String name) {
		return findAll(ByLocator.name(name));
	}

	/**
	 * Finds all page elements by HTML tag
	 * 
	 * @param tag
	 *            HTML tag
	 * @return List of page elements matched
	 */
	public List<BaseElement> findAllByTag(final String tag) {
		return findAll(ByLocator.tag(tag));
	}

	/**
	 * Finds all page elements by text value
	 * 
	 * @param value
	 *            Element text value
	 * @return List of page elements matched
	 */
	public List<BaseElement> findAllByText(final String value) {
		return findAll(ByLocator.text(value));
	}
	
	/**
	 * Finds all page elements by text value
	 * 
	 * @param value
	 *            Element text value
	 * @return List of page elements matched
	 */
	public List<BaseElement> findAllByXPath(final String value) {
		return findAll(ByLocator.xpath(value));
	}

	/**
	 * Finds first page container by attribute value
	 * 
	 * @param attributeName
	 *            Attribute name
	 * @param attributeValue
	 *            Attribute value
	 * @return First page container matched
	 */
	public BaseElement findByAttribute(final String attributeName, final String attributeValue) {
		return findByAttribute(attributeName, attributeValue, 1);
	}

	/**
	 * Finds a page container by attribute value
	 * 
	 * @param attributeName
	 *            Attribute name
	 * @param attributeValue
	 *            Attribute value
	 * @param num
	 *            Number in the list of all elements matched
	 * @return Page container matched
	 */
	public BaseElement findByAttribute(final String attributeName, final String attributeValue, final int num) {
		return findBy(ByLocator.attribute(attributeName, attributeValue), num);
	}

	/**
	 * Finds first page container by CSS class name
	 * 
	 * @param className
	 *            CSS class name
	 * @return First page container matched
	 */
	public BaseElement findByClass(final String className) {
		return findByClass(className, 1);
	}

	/**
	 * Finds a page container by CSS class name
	 * 
	 * @param className
	 *            CSS class name
	 * @param num
	 *            Number in the list of all elements matched
	 * @return Page container matched
	 */
	public BaseElement findByClass(final String className, final int num) {
		return findBy(ByLocator.className(className), num);
	}

	/**
	 * Finds first page container by CSS class name
	 * 
	 * @param cssSelector
	 *            CSS class name
	 * @return First page container matched
	 */
	public BaseElement findByCssSelector(final String cssSelector) {
		return findByCssSelector(cssSelector, 1);
	}

	/**
	 * Finds a page container by CSS class name
	 * 
	 * @param cssSekector
	 *            CSS class name
	 * @param num
	 *            Number in the list of all elements matched
	 * @return Page container matched
	 */
	public BaseElement findByCssSelector(final String cssSekector, final int num) {
		return findBy(ByLocator.cssSelector(cssSekector), num);
	}

	/**
	 * Finds first page container by ID attribute
	 * 
	 * @param id
	 *            Value of ID attribute
	 * @return First page container matched
	 */
	public BaseElement findByID(final String id) {
		return findByID(id, 1);
	}

	/**
	 * Finds a page container by ID attribute
	 * 
	 * @param id
	 *            Value of ID attribute
	 * @param num
	 *            Number in the list off all elements matched
	 * @return List of page elements matched
	 */

	public BaseElement findByID(final String id, final int num) {
		return findBy(ByLocator.id(id), num);
	}

	/**
	 * Finds first page container matched by a locator
	 * 
	 * @param locator
	 *            ByLocator
	 * @return First elements matched
	 */
	public BaseElement findByLocator(final By locator) {
		return findByLocator(locator, 1);
	}

	/**
	 * Finds a page container matched by a locator
	 * 
	 * @param locator
	 *            Element locator
	 * @param num
	 *            Number in matched elements sequence
	 * @return Element matched, null otherwise
	 */
	public BaseElement findByLocator(final By locator, final int num) {
		return findBy(locator, num);
	}

	/**
	 * Finds first page container by NAME attribute
	 * 
	 * @param name
	 *            Value of NAME attribute
	 * @return First page container matched
	 */
	public BaseElement findByName(final String name) {
		return findByName(name, 1);
	}

	/**
	 * Finds a page container by NAME attribute
	 * 
	 * @param name
	 *            Value of NAME attribute
	 * @param num
	 *            Number in the list off all elements matched
	 * @return List of page elements matched
	 */
	public BaseElement findByName(final String name, final int num) {
		return findBy(ByLocator.name(name), num);
	}

	/**
	 * Finds first page container by HTML tag
	 * 
	 * @param tag
	 *            HTML tag
	 * @return First page container matched
	 */
	public BaseElement findByTag(final String tag) {
		return findByTag(tag, 1);
	}

	/**
	 * Finds a page container by HTML tag
	 * 
	 * @param tag
	 *            HTML tag
	 * @param num
	 *            Number in the list off all elements matched
	 * @return List of page elements matched
	 */
	public BaseElement findByTag(final String tag, final int num) {
		return findBy(ByLocator.tag(tag), num);
	}

	/**
	 * Finds first page container by text value
	 * 
	 * @param value
	 *            Element text value
	 * @return First page container matched
	 */
	public BaseElement findByText(final String value) {
		return findByText(value, 1);
	}

	/**
	 * Finds a page container by text value
	 * 
	 * @param value
	 *            Element text value
	 * @param num
	 *            Number in the list off all elements matched
	 * @return List of page elements matched
	 */
	public BaseElement findByText(final String value, final int num) {
		return findBy(ByLocator.text(value), num);
	}
	
	/**
	 * Finds first page container by XPath
	 * 
	 * @param value
	 *            XPath value
	 * @return First page container matched
	 */
	public BaseElement findByXPath(final String value) {
		return findByXPath(value, 1);
	}

	/**
	 * Finds a page container by XPath
	 * 
	 * @param value
	 *            XPath value
	 * @param num
	 *            Number in the list off all elements matched
	 * @return List of page elements matched
	 */
	public BaseElement findByXPath(final String value, final int num) {
		return findBy(ByLocator.xpath(value), num);
	}

	/**
	 * Gets value of specified attribute
	 * 
	 * @param name
	 *            Attribute name
	 * @return Attribute value on success or empty string on fail
	 */
	public String getAttribute(String name) {
		if (element != null)
			return element.getAttribute(name);
		else
			return StringUtils.EMPTY;
	}

	/**
	 * Gets a tag of container
	 * 
	 * @return Tag of page container
	 */
	public String getTag() {
		return tag;
	}

	/**
	 * Gets a text value of container
	 * 
	 * @return Element text value if container exists, empty string otherwise
	 */
	public String getText() {
		return element != null ? element.getText() : StringUtils.EMPTY;
	}

	/**
	 * Checks if container has specific attribute value
	 * 
	 * @param name
	 *            Attribute name
	 * @param value
	 *            Attribute value
	 * @return true if attribute with specified value exists in the container, false
	 *         otherwise
	 */
	public boolean hasAttribute(final String name, final String value) {

		try {
			if (this.locator != null) {
				return wait.until(ExpectedConditions.attributeToBe(this.locator, name, value));
			} else if (this.element != null) {
				return wait.until(ExpectedConditions.attributeToBe(this.element, name, value));
			} else {
				return false;
			}
		} catch (TimeoutException t) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
	}

	public boolean hasUpdated() {
		try {
			String html;
			WebDriverWait wait = new WebDriverWait(driver, 5);

			if (this.element == null && this.locator != null)
				this.element = findWebElement(this.locator);
			html = element.getAttribute("innerHTML");

			if (this.locator != null) {
				return wait.until(ExpectedConditions.not(ExpectedConditions.or(
						ExpectedConditions.refreshed(ExpectedConditions.attributeToBe(this.locator, "innerHTML", html)),
						ExpectedConditions
								.refreshed(ExpectedConditions.attributeContains(this.locator, "innerHTML", html)))));
			} else if (this.element != null) {
				return wait.until(ExpectedConditions.not(ExpectedConditions.or(
						ExpectedConditions.refreshed(ExpectedConditions.attributeToBe(this.element, "innerHTML", html)),
						ExpectedConditions
								.refreshed(ExpectedConditions.attributeContains(this.element, "innerHTML", html)))));
			} else {
				return false;
			}
		} catch (TimeoutException t) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
	}

	/**
	 * Checks if page container is clickable
	 * 
	 * @return True if container is clickable, false otherwise
	 */
	public boolean isClickable() {
		try {
			if (this.locator != null) {
				return wait.until(
						ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(this.locator))) != null;
			} else if (this.element != null) {
				return wait.until(
						ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(this.element))) != null;
			} else {
				return false;
			}
		} catch (TimeoutException t) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
	}

	/**
	 * Checks that given page container is present
	 * 
	 * @return True if present, false otherwise
	 */
	public boolean isPresent() {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		try {
			if (this.element != null) {
				return wait.until(ExpectedConditions.not(ExpectedConditions.stalenessOf(element)));
			} else {
				return false;
			}
		} catch (TimeoutException t) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
	}

	/**
	 * Checks that given page container is stale
	 * 
	 * @return True if stale, false otherwise
	 */
	public boolean isStale() {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		try {
			if (this.element != null) {
				return wait.until(ExpectedConditions.stalenessOf(element));
			} else {
				return true;
			}
		} catch (TimeoutException t) {
			return false;
		} catch (NullPointerException e) {
			return true;
		}
	}

	/**
	 * Checks if page container is visible
	 * 
	 * @return True if the container is visible, false otherwise
	 */
	public boolean isVisible() {
		try {
			if (this.locator != null) {
				return wait.until(ExpectedConditions.visibilityOfElementLocated(this.locator)) != null;
			} else if (this.element != null) {
				return wait.until(ExpectedConditions.visibilityOf(this.element)) != null;
			} else {
				return false;
			}
		} catch (TimeoutException t) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
	}

	/**
	 * Checks if page container contains specific text
	 * 
	 * @param value
	 *            Text value to check
	 * @return True on success, false otherwise
	 */
	public boolean textContains(final String value) {
		try {
			if (this.locator != null) {
				return wait.until(ExpectedConditions.textToBePresentInElementLocated(this.locator, value));
			} else if (this.element != null) {
				return wait.until(ExpectedConditions.textToBePresentInElement(this.element, value));
			} else {
				return false;
			}
		} catch (TimeoutException t) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
	}

	/**
	 * Checks that the text of page container is equal to specified value
	 * 
	 * @param value
	 *            Text value
	 * @return True on success, false otherwise
	 */
	public boolean textEqual(final String value) {
		try {
			if (this.locator != null) {
				return wait.until(ExpectedConditions.textToBePresentInElementLocated(this.locator, value));
			} else if (this.element != null) {
				return wait.until(ExpectedConditions.textToBePresentInElement(this.element, value));
			} else {
				return false;
			}
		} catch (TimeoutException t) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
	}

	/**
	 * Checks that the text of page container is no longer equal to specified value
	 * 
	 * @param value
	 *            Text value
	 * @return True on success, false otherwise
	 */
	public boolean textNotEqual(final String value) {
		try {
			if (this.locator != null) {
				return wait.until(ExpectedConditions
						.not(ExpectedConditions.textToBePresentInElementLocated(this.locator, value)));
			} else if (this.element != null) {
				return wait.until(
						ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(this.element, value)));
			} else {
				return false;
			}
		} catch (TimeoutException t) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
	}

	/**
	 * Gets a WebElement object
	 * 
	 * @return WebElement object
	 */
	public WebElement webElement() {
		return element;
	}

	/**
	 * Finds all elements within parent container's scope matched by specified
	 * locator
	 * 
	 * @param parent
	 *            Parent container
	 * @param locator
	 *            Element matching locator
	 * @return List of elements matched on success, null otherwise
	 */
	private List<BaseElement> findAll(final By locator) {
		if (wait != null && this.locator != null && locator != null) {
			try {
				List<BaseElement> list = new ArrayList<BaseElement>();
				List<WebElement> webList = wait.until(ExpectedConditions
						.refreshed(ExpectedConditions.presenceOfNestedElementsLocatedBy(this.locator, locator)));
				for (WebElement element : webList) {
					list.add(new BaseElement(element, new ByChained(this.locator, locator)));
				}
				return list;
			} catch (TimeoutException t) {
				return new ArrayList<BaseElement>();
			}
		}
		return null;
	}

	/**
	 * Finds a specific container within parent container's scope matched by locator
	 * and is specific number index in list of all elements matched
	 * 
	 * @param parent
	 *            Parent container
	 * @param locator
	 *            Element locator
	 * @param num
	 *            Number index in list of elements
	 * @return Matched container on success, null otherwise
	 */
	private BaseElement findBy(final By locator, final int num) {
		List<BaseElement> elementList = findAll(locator);
		if (elementList != null && elementList.size() >= num) {
			BaseElement element = elementList.get(num - 1);
			return element;
		} else
			return new BaseElement(null);
	}

	private WebElement findWebElement(final By locator) {
		if (wait != null && locator != null) {
			return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} else {
			return null;
		}
	}

	public SelectElement toSelectElement() {
		return toInputElement().toSelectElement();
	}

	public TextInputElement toTextInputElement() {
		return toInputElement().toTextInputElement();
	}

	public ButtonElement toButtonElement() {
		return new ButtonElement(this);
	}

	public RadioElement toRadioElement() {
		return toInputElement().toRadioElement();
	}
	
	public CheckboxElement toCheckboxElement()
	{
		return toInputElement().toCheckboxElement();
	}
	
	public InputElement toInputElement()
	{
		return new InputElement(this);
	}
	
	public LabelElement toLabelElement()
	{
		return new LabelElement(this);
	}

}
