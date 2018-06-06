package shinoamakusa.selenium.core.elements;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectElement extends PageElement {
	
	public SelectElement(PageElement pageElement)
	{
		this.tag = pageElement.tag;
		this.element = pageElement.element;
	}
	
	/**
	 * Determines if specific container is container of SELECT tag
	 * 
	 * @param container
	 *            Page container
	 * @return True on success, false otherwise
	 */
	public boolean isSelectTagElement() {
		return element != null ? tag.equalsIgnoreCase("select") : false;
	}
	
	/**
	 * Selects dropdown list option by id
	 * 
	 * @param num
	 *            Option tag index
	 */
	public void selectOptionByIndex(final int num) {
		if (this.isSelectTagElement()) {
			Select listElement = new Select(element);
			listElement.selectByIndex(num);

		}
	}

	/**
	 * Selects dropdown list option by visible text
	 * 
	 * @param text
	 *            Option tag visible text
	 */
	public void selectOptionByText(final String text) {
		if (this.isSelectTagElement()) {
			Select listElement = new Select(element);
			listElement.selectByVisibleText(text);

		}
	}

	/**
	 * Selects dropdown list option by value
	 * 
	 * @param value
	 *            Option tag value
	 */
	public void selectOptionByValue(final String value) {
		if (this.isSelectTagElement()) {
			Select listElement = new Select(element);
			listElement.selectByValue(value);

		}
	}
	
	public PageElement getSelectedOption() {
		if (isSelectTagElement()) {
			WebElement selected = new Select(element).getFirstSelectedOption();
			return new PageElement(selected);

		} else {
			return new PageElement(null);
		}
	}

	/**
	 * Gets options of select tag container
	 * 
	 * @return List of options of select tag container if exist
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

}
