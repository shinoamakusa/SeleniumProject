package shinoamakusa.selenium.core.elements;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RadioElement extends BaseElement {
	public RadioElement(BaseElement pageElement) {
		this.tag = pageElement.tag;
		this.element = pageElement.element;
		this.locator = pageElement.locator;
	}

	public boolean isSelected(final boolean state) {
		if (isRadioElement()) {
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

	private boolean isRadioElement() {
		return element != null ? tag.equalsIgnoreCase("input") && this.hasAttribute("type", "radio") : false;
	}

}
