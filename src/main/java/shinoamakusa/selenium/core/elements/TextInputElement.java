package shinoamakusa.selenium.core.elements;

public class TextInputElement extends InputElement {

	public TextInputElement(BaseElement pageElement) {
		super(pageElement);
	}

	public void enterText(String text) {
		if (this.isTextInputElement() && this.isClickable() && element.isEnabled()) {
			element.click();
			element.clear();
			element.sendKeys(text);
		}
	}

}
