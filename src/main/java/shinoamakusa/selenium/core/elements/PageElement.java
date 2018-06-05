package main.java.shinoamakusa.selenium.core.elements;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import main.java.shinoamakusa.selenium.core.CustomExpectedConditions;

/**
 * Class representing a page element ( Selenium WebElement)
 * 
 * @author Oleg Kravenkov
 *
 */
public class PageElement {

	private static WebDriver driver;
	private static WebDriverWait wait;

	/**
	 * Checks if certain number of elements exist in DOM
	 * 
	 * @param locator
	 *            Locator for elements
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
	 *            Locator for elements
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
	 *            Locator for elements
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
	public static void setDriver(WebDriver driver, WebDriverWait wait) {
		PageElement.driver = driver;
		PageElement.wait = wait;
	}

	/**
	 * Checks if page element contains specific text
	 * 
	 * @param locator
	 *            Page element locator
	 * @param value
	 *            Text value to check
	 * @return True on success, false otherwise
	 */
	public static boolean textContains(final By locator, final String value) {
		try {
			wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, value));
			return true;
		} catch (TimeoutException t) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
	}

	/**
	 * Selenium WebElement object
	 */
	private WebElement element;

	/**
	 * WebElement's HTML tag
	 */
	private String tag = "";

	/**
	 * PageElement class constructor
	 * 
	 * @param element
	 *            Selenium WebElement object
	 */
	public PageElement(final WebElement element) {
		this.element = element;
		if (this.element != null) {
			this.tag = element.getTagName();
		}
	}

	/**
	 * PageElement class constructor
	 * 
	 * @param element
	 *            Selenium WebElement
	 * @param driver
	 *            Selenium WebDriver element
	 */
	public PageElement(final WebElement element, final WebDriver driver) {
		this.element = element;
		PageElement.driver = driver;
		PageElement.wait = new WebDriverWait(PageElement.driver, 30);
		if (this.element != null) {
			this.tag = element.getTagName();
		}
	}

	/**
	 * PageElement class constructor
	 * 
	 * @param element
	 *            Selenium WebElement
	 * @param driver
	 *            Selenium WebDriver element
	 * @param wait
	 *            Selenium WebDriverWait element
	 */
	public PageElement(final WebElement element, final WebDriver driver, final WebDriverWait wait) {
		this.element = element;
		PageElement.driver = driver;
		PageElement.wait = wait;
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
	 * Finds all page elements by attribute value
	 * 
	 * @param attributeName
	 *            Attribute name
	 * @param attributeValue
	 *            Attribute value
	 * @return List of page elements matched
	 */
	public List<PageElement> findAllByAttribute(final String attributeName, final String attributeValue) {
		return findAll(ElementLocator.byAttribute(attributeName, attributeValue));
	}

	/**
	 * Finds all page elements by CSS class name
	 * 
	 * @param className
	 *            CSS class name
	 * @return List of page elements matched
	 */
	public List<PageElement> findAllByClass(final String className) {
		return findAll(ElementLocator.byClass(className));
	}

	/**
	 * Finds all page elements by CSS class name
	 * 
	 * @param cssSelector
	 *            CSS class name
	 * @return List of page elements matched
	 */
	public List<PageElement> findAllByCssSelector(final String cssSelector) {
		return findAll(ElementLocator.byCssSelector(cssSelector));
	}

	/**
	 * Finds all page elements by ID attribute
	 * 
	 * @param id
	 *            Value of ID attribute
	 * @return List of page elements matched
	 */
	public List<PageElement> findAllByID(final String id) {
		return findAll(ElementLocator.byID(id));
	}

	/**
	 * Finds page elements matched by a locator
	 * 
	 * @param locator
	 *            Locator
	 * @return List of matched elements, null otherwise
	 */
	public List<PageElement> findAllByLocator(final By locator) {
		return findAll(locator);
	}

	/**
	 * Finds all page elements by NAME attribute
	 * 
	 * @param name
	 *            Value of NAME attribute
	 * @return List of page elements matched
	 */
	public List<PageElement> findAllByName(final String name) {
		return findAll(ElementLocator.byName(name));
	}

	/**
	 * Finds all page elements by HTML tag
	 * 
	 * @param tag
	 *            HTML tag
	 * @return List of page elements matched
	 */
	public List<PageElement> findAllByTag(final String tag) {
		return findAll(ElementLocator.byTag(tag));
	}

	/**
	 * Finds all page elements by text value
	 * 
	 * @param value
	 *            Element text value
	 * @return List of page elements matched
	 */
	public List<PageElement> findAllByText(final String value) {
		return findAll(ElementLocator.byText(value));
	}

	/**
	 * Finds first page element by attribute value
	 * 
	 * @param attributeName
	 *            Attribute name
	 * @param attributeValue
	 *            Attribute value
	 * @return First page element matched
	 */
	public PageElement findByAttribute(final String attributeName, final String attributeValue) {
		return findByAttribute(attributeName, attributeValue, 1);
	}

	/**
	 * Finds a page element by attribute value
	 * 
	 * @param attributeName
	 *            Attribute name
	 * @param attributeValue
	 *            Attribute value
	 * @param num
	 *            Number in the list of all elements matched
	 * @return Page element matched
	 */
	public PageElement findByAttribute(final String attributeName, final String attributeValue, final int num) {
		return findBy(ElementLocator.byAttribute(attributeName, attributeValue), num);
	}

	/**
	 * Finds first page element by CSS class name
	 * 
	 * @param className
	 *            CSS class name
	 * @return First page element matched
	 */
	public PageElement findByClass(final String className) {
		return findByClass(className, 1);
	}

	/**
	 * Finds a page element by CSS class name
	 * 
	 * @param className
	 *            CSS class name
	 * @param num
	 *            Number in the list of all elements matched
	 * @return Page element matched
	 */
	public PageElement findByClass(final String className, final int num) {
		return findBy(ElementLocator.byClass(className), num);
	}

	/**
	 * Finds first page element by CSS class name
	 * 
	 * @param cssSelector
	 *            CSS class name
	 * @return First page element matched
	 */
	public PageElement findByCssSelector(final String cssSelector) {
		return findByCssSelector(cssSelector, 1);
	}

	/**
	 * Finds a page element by CSS class name
	 * 
	 * @param cssSekector
	 *            CSS class name
	 * @param num
	 *            Number in the list of all elements matched
	 * @return Page element matched
	 */
	public PageElement findByCssSelector(final String cssSekector, final int num) {
		return findBy(ElementLocator.byCssSelector(cssSekector), num);
	}

	/**
	 * Finds first page element by ID attribute
	 * 
	 * @param id
	 *            Value of ID attribute
	 * @return First page element matched
	 */
	public PageElement findByID(final String id) {
		return findByID(id, 1);
	}

	/**
	 * Finds a page element by ID attribute
	 * 
	 * @param id
	 *            Value of ID attribute
	 * @param num
	 *            Number in the list off all elements matched
	 * @return List of page elements matched
	 */

	public PageElement findByID(final String id, final int num) {
		return findBy(ElementLocator.byID(id), num);
	}

	/**
	 * Finds first page element matched by a locator
	 * 
	 * @param locator
	 *            Locator
	 * @return First elements matched
	 */
	public PageElement findByLocator(final By locator) {
		return findByLocator(locator, 1);
	}

	/**
	 * Finds a page element matched by a locator
	 * 
	 * @param locator
	 *            Element locator
	 * @param num
	 *            Number in matched elements sequence
	 * @return Element matched, null otherwise
	 */
	public PageElement findByLocator(final By locator, final int num) {
		return findBy(locator, num);
	}

	/**
	 * Finds first page element by NAME attribute
	 * 
	 * @param name
	 *            Value of NAME attribute
	 * @return First page element matched
	 */
	public PageElement findByName(final String name) {
		return findByName(name, 1);
	}

	/**
	 * Finds a page element by NAME attribute
	 * 
	 * @param name
	 *            Value of NAME attribute
	 * @param num
	 *            Number in the list off all elements matched
	 * @return List of page elements matched
	 */
	public PageElement findByName(final String name, final int num) {
		return findBy(ElementLocator.byName(name), num);
	}

	/**
	 * Finds first page element by HTML tag
	 * 
	 * @param tag
	 *            HTML tag
	 * @return First page element matched
	 */
	public PageElement findByTag(final String tag) {
		return findByTag(tag, 1);
	}

	/**
	 * Finds a page element by HTML tag
	 * 
	 * @param tag
	 *            HTML tag
	 * @param num
	 *            Number in the list off all elements matched
	 * @return List of page elements matched
	 */
	public PageElement findByTag(final String tag, final int num) {
		return findBy(ElementLocator.byTag(tag), num);
	}

	/**
	 * Finds first page element by text value
	 * 
	 * @param value
	 *            Element text value
	 * @return First page element matched
	 */
	public PageElement findByText(final String value) {
		return findByText(value, 1);
	}

	/**
	 * Finds a page element by text value
	 * 
	 * @param value
	 *            Element text value
	 * @param num
	 *            Number in the list off all elements matched
	 * @return List of page elements matched
	 */
	public PageElement findByText(final String value, final int num) {
		return findBy(ElementLocator.byText(value), num);
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
	 * Gets options of select tag element
	 * 
	 * @return List of options of select tag element if exist
	 */
	public List<PageElement> getSelectOptions() {
		if (isSelectTagElement()) {
			List<PageElement> elementList = new ArrayList<PageElement>();
			List<WebElement> list = new Select(element).getOptions();
			for (WebElement el : list) {
				elementList.add(new PageElement(el));
			}
			return elementList;
		} else {
			return new ArrayList<PageElement>();
		}
	}

	/**
	 * Gets a tag of element
	 * 
	 * @return Tag of page element
	 */
	public String getTag() {
		return tag;
	}

	/**
	 * Gets a text value of element
	 * 
	 * @return Element text value if element exists, empty string otherwise
	 */
	public String getText() {
		return element != null ? element.getText() : StringUtils.EMPTY;
	}

	/**
	 * Checks if element has specific attribute value
	 * 
	 * @param name
	 *            Attribute name
	 * @param value
	 *            Attribute value
	 * @return true if attribute with specified value exists in the element, false
	 *         otherwise
	 */
	public boolean hasAttribute(final String name, final String value) {

		try {
			wait.until(ExpectedConditions.or(ExpectedConditions.attributeToBe(element, name, value),
					ExpectedConditions.attributeContains(element, name, value)));
			return true;
		} catch (TimeoutException t) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
	}

	/**
	 * Checks to see if page element located has specific selected state
	 * 
	 * @param selected
	 *            Selection state
	 * @return True on success, false otherwise
	 */
	public boolean hasSelectedState(boolean selected) {

		try {
			wait.until(ExpectedConditions.elementSelectionStateToBe(element, selected));
			return true;
		} catch (TimeoutException t) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}

	}

	/**
	 * Checks if page element is clickable
	 * 
	 * @return True if element is clickable, false otherwise
	 */
	public boolean isClickable() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		} catch (TimeoutException t) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
	}

	/**
	 * Checks to see if page element is selected
	 * 
	 * @return True if element is selected, false otherwise
	 */
	public boolean isSelected() {

		try {
			wait.until(ExpectedConditions.elementToBeSelected(element));
			return true;
		} catch (TimeoutException t) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}

	}

	/**
	 * Determines if specific element is element of SELECT tag
	 * 
	 * @param element
	 *            Page element
	 * @return True on success, false otherwise
	 */
	public boolean isSelectTagElement() {
		return element != null ? tag.equalsIgnoreCase("select") : false;
	}

	/**
	 * Checks that given page element is not stale (exists)
	 * 
	 * @return True if not stale, false otherwise
	 */
	public boolean isStale() {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		try {
			wait.until(ExpectedConditions.not(ExpectedConditions.stalenessOf(element)));
			return false;
		} catch (TimeoutException t) {
			return true;
		} catch (NullPointerException e) {
			return false;
		}
	}

	/**
	 * Checks if page element is visible
	 * 
	 * @return True if the element is visible, false otherwise
	 */
	public boolean isVisible() {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (TimeoutException t) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
	}

	/**
	 * Checks if page element contains specific text
	 * 
	 * @param value
	 *            Text value to check
	 * @return True on success, false otherwise
	 */
	public boolean textContains(final String value) {
		try {
			wait.until(ExpectedConditions.textToBePresentInElement(element, value));
			return true;
		} catch (TimeoutException t) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
	}

	/**
	 * Checks that the text of page element is equal to specified value
	 * 
	 * @param value
	 *            Text value
	 * @return True on success, false otherwise
	 */
	public boolean textEqual(final String value) {
		try {
			wait.until(ExpectedConditions.textToBePresentInElement(element, value));
			return true;
		} catch (TimeoutException t) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
	}

	/**
	 * Checks that the text of page element is no longer equal to specified value
	 * 
	 * @param value
	 *            Text value
	 * @return True on success, false otherwise
	 */
	public boolean textNotEqual(final String value) {
		try {
			wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(element, value)));
			return true;
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
	 * Finds all elements within parent element's scope matched by specified locator
	 * 
	 * @param parent
	 *            Parent element
	 * @param locator
	 *            Element matching locator
	 * @return List of elements matched on success, null otherwise
	 */
	private List<PageElement> findAll(final By locator) {
		if (wait != null && element != null && locator != null) {
			try {
				List<PageElement> list = wait
						.until(CustomExpectedConditions.presenceOfNestedElementsLocatedBy(element, locator, wait));
				return list;
			} catch (TimeoutException t) {
				return null;
			}
		}
		return null;
	}

	/**
	 * Finds a specific element within parent element's scope matched by locator and
	 * is specific number index in list of all elements matched
	 * 
	 * @param parent
	 *            Parent element
	 * @param locator
	 *            Element locator
	 * @param num
	 *            Number index in list of elements
	 * @return Matched element on success, null otherwise
	 */
	private PageElement findBy(final By locator, final int num) {
		List<PageElement> elementList = findAll(locator);
		if (elementList != null && elementList.size() >= num) {
			PageElement element = elementList.get(num - 1);
			return element;
		} else
			return new PageElement(null);
	}

}
