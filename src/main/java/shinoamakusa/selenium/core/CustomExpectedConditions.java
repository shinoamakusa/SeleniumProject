package shinoamakusa.selenium.core;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class CustomExpectedConditions {

	/**
	 * Gets a list of all elements matched by child selector within parent container
	 * 
	 * @param parent
	 *            Parent container
	 * @param childLocator
	 *            ByLocator for container to match within parent container
	 * @return List of elements matched, null otherwise
	 */
	public static final ExpectedCondition<List<WebElement>> presenceOfNestedElementsLocatedBy(final WebElement parent,
			final By childLocator) {
		return new ExpectedCondition<List<WebElement>>() {

			@Override
			public List<WebElement> apply(WebDriver driver) {
				List<WebElement> list = parent.findElements(childLocator);
				return list;
			}
		};
	}

}
