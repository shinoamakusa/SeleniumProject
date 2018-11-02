package shinoamakusa.selenium.core.elements;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InputElement extends BaseElement {
	public InputElement() {

	}

	public InputElement(BaseElement pageElement) {
		this.tag = pageElement.tag;
		this.element = pageElement.element;
		this.locator = pageElement.locator;
	}

	public boolean hasSelectedState(final boolean state) {

		WebDriverWait wait = new WebDriverWait(driver, 0);
		try {
			if (this.locator != null) {
				return wait.until(ExpectedConditions.elementSelectionStateToBe(this.locator, state));
			} else if (this.element != null) {
				return wait.until(ExpectedConditions.elementSelectionStateToBe(this.element, state));
			} else {
				return false;
			}
		} catch (TimeoutException t) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
	}

	public CheckboxElement toCheckboxElement() {
		return new CheckboxElement(this);
	}

	public RadioElement toRadioElement() {
		return new RadioElement(this);
	}

	public SelectElement toSelectElement() {
		return new SelectElement(this);
	}

	public TextInputElement toTextInputElement() {
		return new TextInputElement(this);
	}

	protected boolean isCheckboxElement() {
		return element != null ? tag.equalsIgnoreCase("input") && this.getAttribute("type").equalsIgnoreCase("checkbox")  : false;
	}

	protected boolean isRadioElement() {
		return element != null ? tag.equalsIgnoreCase("input") && this.getAttribute("type").equalsIgnoreCase("radio")  : false;
	}

	/**
	 * Determines if specific container is container of SELECT tag
	 * 
	 * @param container
	 *            Page container
	 * @return True on success, false otherwise
	 */
	protected boolean isSelectTagElement() {
		return element != null ? tag.equalsIgnoreCase("select") : false;
	}

	protected boolean isTextInputElement() {
		return element != null
				? tag.equalsIgnoreCase("input")
						&& (this.getAttribute("type").equalsIgnoreCase("text") || this.getAttribute("type").equalsIgnoreCase("search"))
				: false;
	}

}
