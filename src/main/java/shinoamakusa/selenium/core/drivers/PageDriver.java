package shinoamakusa.selenium.core.drivers;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import shinoamakusa.selenium.core.elements.ElementLocator;
import shinoamakusa.selenium.core.elements.PageElement;

/**
 * Class representing a browser page and its elements Wrapper class for Selenium
 * WebDriver
 * 
 * @author Oleg Kravenkov
 *
 */
public class PageDriver {

	/**
	 * Selenium WebDriver
	 */
	protected WebDriver driver;

	/**
	 * Parent container for container matching
	 */
	protected PageElement parentElement;

	/**
	 * Current selected page container
	 */
	protected PageElement selectedElement;

	/**
	 * Selenium WebDriver wait
	 */
	protected WebDriverWait wait;

	/**
	 * PageDriver class constructor
	 */
	public PageDriver() {

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
	 * Finds first page container by attribute value
	 * 
	 * @param attributeName
	 *            Attribute name
	 * @param attributeValue
	 *            Attribute value
	 * @return First page container matched
	 */
	public PageElement findByAttribute(final String attributeName, final String attributeValue) {
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
	public PageElement findByAttribute(final String attributeName, final String attributeValue, final int num) {
		return findBy(ElementLocator.byAttribute(attributeName, attributeValue), num);
	}

	/**
	 * Finds first page container by CSS class name
	 * 
	 * @param className
	 *            CSS class name
	 * @return First page container matched
	 */
	public PageElement findByClass(final String className) {
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
	public PageElement findByClass(final String className, final int num) {
		return findBy(ElementLocator.byClass(className), num);
	}

	/**
	 * Finds first page container by CSS class name
	 * 
	 * @param cssSelector
	 *            CSS class name
	 * @return First page container matched
	 */
	public PageElement findByCssSelector(final String cssSelector) {
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
	public PageElement findByCssSelector(final String cssSekector, final int num) {
		return findBy(ElementLocator.byCssSelector(cssSekector), num);
	}

	/**
	 * Finds first page container by ID attribute
	 * 
	 * @param id
	 *            Value of ID attribute
	 * @return First page container matched
	 */
	public PageElement findByID(final String id) {
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

	public PageElement findByID(final String id, final int num) {
		return findBy(ElementLocator.byID(id), num);
	}

	/**
	 * Finds first page container matched by a locator
	 * 
	 * @param locator
	 *            Locator
	 * @return First elements matched
	 */
	public PageElement findByLocator(final By locator) {
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
	public PageElement findByLocator(final By locator, final int num) {
		return findBy(locator, num);
	}

	/**
	 * Finds first page container by NAME attribute
	 * 
	 * @param name
	 *            Value of NAME attribute
	 * @return First page container matched
	 */
	public PageElement findByName(final String name) {
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
	public PageElement findByName(final String name, final int num) {
		return findBy(ElementLocator.byName(name), num);
	}

	/**
	 * Finds first page container by HTML tag
	 * 
	 * @param tag
	 *            HTML tag
	 * @return First page container matched
	 */
	public PageElement findByTag(final String tag) {
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
	public PageElement findByTag(final String tag, final int num) {
		return findBy(ElementLocator.byTag(tag), num);
	}

	/**
	 * Finds first page container by text value
	 * 
	 * @param value
	 *            Element text value
	 * @return First page container matched
	 */
	public PageElement findByText(final String value) {
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
	public PageElement findByText(final String value, final int num) {
		return findBy(ElementLocator.byText(value), num);
	}

	/**
	 * Gets the current set parent page container
	 * 
	 * @return Selected parent page container
	 */
	public PageElement parentElement() {
		return parentElement;
	}

	/**
	 * Gets the current selected page container
	 * 
	 * @return Selected page container
	 */
	public PageElement selectedElement() {
		return selectedElement;
	}

	/**
	 * Gets page title
	 * 
	 * @return Page title
	 */
	public String getTitle() {
		if (driver != null) {
			return driver.getTitle();
		}
		return StringUtils.EMPTY;
	}

	/**
	 * Gets page Url
	 * 
	 * @return Page Url
	 */
	public String getUrl() {
		if (driver != null) {
			return driver.getCurrentUrl();
		}
		return StringUtils.EMPTY;
	}

	/**
	 * Resets parent page container to null
	 */
	public void resetParent() {
		this.parentElement = null;
	}

	/**
	 * Selects specified container
	 * 
	 * @param container
	 *            Element to select
	 */
	public void select(final PageElement element) {
		selectedElement = element;
	}


	/**
	 * Sets current parent page container
	 * 
	 * @param container
	 *            Page container to set to be a parent container
	 */
	public void setParentElement(final PageElement element) {
		parentElement = element;
	}

	/**
	 * Determines if correct page has been loaded based on Url part
	 * 
	 * @param urlPart
	 *            Part of Url that must exist in full Url
	 * @return true if correct page is loaded, false otherwise
	 */
	public boolean urlContains(final String urlPart) {
		if (wait != null && !StringUtils.isBlank(urlPart)) {
			return wait.until(ExpectedConditions.urlContains(urlPart));
		}
		return false;
	}

	/**
	 * Determines if current page URL is equal to one expected
	 * 
	 * @param url
	 *            Full expected page url
	 * @return true if correct page is loaded, false otherwise
	 */
	public boolean urlIs(final String url) {
		if (wait != null && !StringUtils.isBlank(url)) {
			return wait.until(ExpectedConditions.urlToBe(url));
		}
		return false;
	}

	/**
	 * Generates a wait timeout
	 * 
	 * @param seconds
	 *            Seconds to wait
	 */
	public void waitFor(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Finds all elements matched by specified locator
	 * 
	 * @param locator
	 *            Element matching locator
	 * @return List of elements matched on success, null otherwise
	 */
	private List<PageElement> findAll(final By locator) {
		if (wait != null && locator != null) {
			try {
				List<PageElement> list = new ArrayList<PageElement>();
				List<WebElement> webList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
				for (WebElement element : webList) {
					list.add(new PageElement(element, locator));

				}

				return list;
			} catch (TimeoutException t) {
				return new ArrayList<PageElement>();
			}
		}
		return null;
	}

	/**
	 * Finds a specific container matched by locator and is specific number index in
	 * list of all elements matched
	 * 
	 * @param locator
	 *            Element locator
	 * @param num
	 *            Number index in list of elements
	 * @return Matched container on success, null otherwise
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
