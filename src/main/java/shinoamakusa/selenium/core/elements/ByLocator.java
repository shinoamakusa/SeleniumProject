package shinoamakusa.selenium.core.elements;

import org.openqa.selenium.By;

public final class ByLocator {
	/**
	 * Gets a XPath locator for matching elements by attribute
	 * 
	 * @param attributeName
	 *            Attribute name
	 * @return XPath locator
	 */
	public static final By attribute(final String attributeName) {
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
	public static final By attribute(final String attributeName, final String attributeValue) {
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
	public static final By className(final String className) {
		return By.className(className);
	}

	/**
	 * Gets a XPath locator for matching elements by CSS class name
	 * 
	 * @param selector
	 *            CSS class name
	 * @return XPath locator
	 */
	public static final By cssSelector(final String selector) {
		return By.cssSelector(selector);
	}

	/**
	 * Gets a XPath locator for matching elements by ID attribute value
	 * 
	 * @param id
	 *            Value of ID attribute
	 * @return XPath locator
	 */
	public static final By id(final String id) {
		return By.id(id);
	}

	/**
	 * Gets a XPath locator for matching elements by NAME attribute value
	 * 
	 * @param name
	 *            Value of NAME attribute
	 * @return XPath locator
	 */
	public static final By name(final String name) {
		return By.name(name);
	}

	/**
	 * Gets a XPath locator for matching elements by HTML tag
	 * 
	 * @param tag
	 *            HTML tag
	 * @return XPath locator
	 */
	public static final By tag(final String tag) {
		return By.tagName(tag);
	}

	/**
	 * Gets a XPath locator for matching elements by text value
	 * 
	 * @param value
	 *            Element text value
	 * @return XPath locator
	 */
	public static final By text(final String value) {
		return By.xpath(new StringBuilder("//*[text() = '").append(value).append("']").toString());
	}

}
