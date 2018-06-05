package main.java.shinoamakusa.selenium.core.drivers;

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

import main.java.shinoamakusa.selenium.core.elements.ElementLocator;
import main.java.shinoamakusa.selenium.core.elements.PageElement;

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
	 * Parent element for element matching
	 */
	protected PageElement parentElement;

	/**
	 * Current selected page element
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
	 * Gets the current set parent page element
	 * 
	 * @return Selected parent page element
	 */
	public PageElement parentElement() {
		return parentElement;
	}

	/**
	 * Gets the current selected page element
	 * 
	 * @return Selected page element
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
	 * Resets parent page element to null
	 */
	public void resetParent() {
		this.parentElement = null;
	}

	/**
	 * Selects specified element
	 * 
	 * @param element
	 *            Element to select
	 */
	public void select(final PageElement element) {
		selectedElement = element;
	}

	/**
	 * Selects dropdown list option by id
	 * 
	 * @param element
	 *            Select tag element
	 * @param num
	 *            Option tag index
	 */
	public void selectOptionByIndex(final PageElement element, final int num) {
		if (element.isSelectTagElement()) {
			Select listElement = new Select(element.webElement());
			listElement.selectByIndex(num);
			selectedElement = new PageElement(listElement.getFirstSelectedOption());

		}
	}

	/**
	 * Selects dropdown list option by visible text
	 * 
	 * @param element
	 *            Select tag element
	 * @param text
	 *            Option tag visible text
	 */
	public void selectOptionByText(final PageElement element, final String text) {
		if (element.isSelectTagElement()) {
			Select listElement = new Select(element.webElement());
			listElement.selectByVisibleText(text);
			selectedElement = new PageElement(listElement.getFirstSelectedOption());

		}
	}

	/**
	 * Selects dropdown list option by value
	 * 
	 * @param element
	 *            Select tag element
	 * @param value
	 *            Option tag value
	 */
	public void selectOptionByValue(final PageElement element, final String value) {
		if (element.isSelectTagElement()) {
			Select listElement = new Select(element.webElement());
			listElement.selectByValue(value);
			selectedElement = new PageElement(listElement.getFirstSelectedOption());

		}
	}

	/**
	 * Sets current parent page element
	 * 
	 * @param element
	 *            Page element to set to be a parent element
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
					list.add(new PageElement(element));

				}

				return list;
			} catch (TimeoutException t) {
				return new ArrayList<PageElement>();
			}
		}
		return null;
	}

	/**
	 * Finds a specific element matched by locator and is specific number index in
	 * list of all elements matched
	 * 
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
