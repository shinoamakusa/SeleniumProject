package shinoamakusa.selenium.core.elements;

public class TextInputElement extends BaseElement {

	public TextInputElement(BaseElement pageElement) {
		this.tag = pageElement.tag;
		this.element = pageElement.element;
		this.locator = pageElement.locator;
	}

	public void enterText(String text) {
		if (this.isTextInputElement() && this.isClickable()) {
			element.click();
			element.clear();
			element.sendKeys(text);
		}
	}
	
	public boolean isTextInputElement() {
		return element != null ? tag.equalsIgnoreCase("input") && this.hasAttribute("type", "text") : false;
	}

}
