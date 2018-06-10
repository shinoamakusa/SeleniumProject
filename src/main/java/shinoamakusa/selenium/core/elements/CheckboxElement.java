package shinoamakusa.selenium.core.elements;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckboxElement extends BaseElement {
	public CheckboxElement(BaseElement pageElement) {
		this.tag = pageElement.tag;
		this.element = pageElement.element;
		this.locator = pageElement.locator;
	}

	public boolean isChecked(final boolean state) {
		if (isCheckboxElement()) {
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
		return false;
	}

	private boolean isCheckboxElement() {
		return element != null ? tag.equalsIgnoreCase("input") && this.hasAttribute("type", "checkbox") : false;
	}

}
