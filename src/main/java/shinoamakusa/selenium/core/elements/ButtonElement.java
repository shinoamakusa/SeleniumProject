package shinoamakusa.selenium.core.elements;

public class ButtonElement extends BaseElement {
	public ButtonElement(BaseElement pageElement) {
		this.tag = pageElement.tag;
		this.element = pageElement.element;
		this.locator = pageElement.locator;
	}

	public boolean isButtonElement() {
		return element != null ? tag.equalsIgnoreCase("button") : false;
	}

}
