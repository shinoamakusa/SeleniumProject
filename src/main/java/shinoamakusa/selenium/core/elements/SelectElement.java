package shinoamakusa.selenium.core.elements;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectElement extends BaseElement {
	
	public SelectElement(BaseElement pageElement)
	{
		this.tag = pageElement.tag;
		this.element = pageElement.element;
		this.locator = pageElement.locator;
	}
	
	public BaseElement getSelectedOption() {
		if (isSelectTagElement() && element.isEnabled()) {
			WebElement selected = new Select(element).getFirstSelectedOption();
			return new BaseElement(selected);

		} else {
			return new BaseElement();
		}
	}
	
	/**
	 * Gets options of select tag container
	 * 
	 * @return List of options of select tag container if exist
	 */
	public List<BaseElement> getSelectOptions() {
		if (isSelectTagElement() && element.isEnabled()) {
			List<BaseElement> elementList = new ArrayList<BaseElement>();
			List<WebElement> list = new Select(element).getOptions();
			for (WebElement el : list) {
				elementList.add(new BaseElement(el));
			}
			return elementList;
		} else {
			return new ArrayList<BaseElement>();
		}
	}

	/**
	 * Selects dropdown list option by id
	 * 
	 * @param num
	 *            Option tag index
	 */
	public void selectOptionByIndex(final int num) {
		if (this.isSelectTagElement() && element.isEnabled()) {
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
		if (this.isSelectTagElement() && element.isEnabled()) {
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
		if (this.isSelectTagElement() && element.isEnabled()) {
			Select listElement = new Select(element);
			listElement.selectByValue(value);

		}
	}

	/**
	 * Determines if specific container is container of SELECT tag
	 * 
	 * @param container
	 *            Page container
	 * @return True on success, false otherwise
	 */
	private boolean isSelectTagElement() {
		return element != null ? tag.equalsIgnoreCase("select") : false;
	}

}
