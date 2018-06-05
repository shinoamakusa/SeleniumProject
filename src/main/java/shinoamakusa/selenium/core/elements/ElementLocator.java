package main.java.shinoamakusa.selenium.core.elements;

import org.openqa.selenium.By;

public final class ElementLocator {
	/**
	 * Gets a XPath locator for matching elements by attribute
	 * 
	 * @param attributeName
	 *            Attribute name
	 * @return XPath locator
	 */
	public static final By byAttribute(final String attributeName) {
		return By.xpath(new StringBuilder("//*[@").append(attributeName).append("]").toString());
	}

	/**
	 * Gets a XPath locator for matching elements by attribute value
	 * 
	 * @param attributeName
	 *            Attribute name
	 * @param attributeValue
	 *            Attribute value
	 * @return XPath locator
	 */
	public static final By byAttribute(final String attributeName, final String attributeValue) {
		return By.xpath(new StringBuilder("//*[@").append(attributeName).append("='").append(attributeValue)
				.append("']").toString());
	}

	/**
	 * Gets a XPath locator for matching elements by CSS class name
	 * 
	 * @param className
	 *            CSS class name
	 * @return XPath locator
	 */
	public static final By byClass(final String className) {
		return By.className(className);
	}

	/**
	 * Gets a XPath locator for matching elements by CSS class name
	 * 
	 * @param selector
	 *            CSS class name
	 * @return XPath locator
	 */
	public static final By byCssSelector(final String selector) {
		return By.cssSelector(selector);
	}

	/**
	 * Gets a XPath locator for matching elements by ID attribute value
	 * 
	 * @param id
	 *            Value of ID attribute
	 * @return XPath locator
	 */
	public static final By byID(final String id) {
		return By.id(id);
	}

	/**
	 * Gets a XPath locator for matching elements by NAME attribute value
	 * 
	 * @param name
	 *            Value of NAME attribute
	 * @return XPath locator
	 */
	public static final By byName(final String name) {
		return By.name(name);
	}

	/**
	 * Gets a XPath locator for matching elements by HTML tag
	 * 
	 * @param tag
	 *            HTML tag
	 * @return XPath locator
	 */
	public static final By byTag(final String tag) {
		return By.tagName(tag);
	}

	/**
	 * Gets a XPath locator for matching elements by text value
	 * 
	 * @param value
	 *            Element text value
	 * @return XPath locator
	 */
	public static final By byText(final String value) {
		return By.xpath(new StringBuilder("//*[text() = '").append(value).append("']").toString());
	}

}
