package shinoamakusa.selenium.core.elements;

import org.openqa.selenium.By;

public class LabelElement extends BaseElement {
	public LabelElement(BaseElement pageElement) {
		this.tag = pageElement.tag;
		this.element = pageElement.element;
		this.locator = pageElement.locator;
	}

	private boolean isLabelElement() {
		return element != null ? tag.equalsIgnoreCase("label") : false;
	}

	public boolean hasSelectedState(final boolean state) {
		if (isLabelElement()) {
			String idFor = getAttribute("for");
			By locator = ByLocator.id(idFor);
			InputElement input = this.findByLocator(locator).toInputElement();

			return input.hasSelectedState(state);
		}
		return false;
	}

}
