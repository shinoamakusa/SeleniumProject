package shinoamakusa.selenium.framework;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import shinoamakusa.selenium.framework.elements.PageElement;

public class CustomExpectedConditions {
	
	/**
	 * Gets a list of all elements matched by child selector within parent element
	 * 
	 * @param parent
	 *            Parent element
	 * @param childLocator
	 *            Locator for element to match within parent element
	 * @return List of elements matched, null otherwise
	 */
	public static final ExpectedCondition<List<PageElement>> presenceOfNestedElementsLocatedBy(final WebElement parent,
			final By childLocator, final WebDriverWait wait) {
		return new ExpectedCondition<List<PageElement>>() {

			@Override
			public List<PageElement> apply(WebDriver driver) {
				List<PageElement> list = new ArrayList<PageElement>();
				List<WebElement> childrenList = parent.findElements(childLocator);
				for (WebElement element : childrenList)
				{
					list.add(new PageElement(element, driver, wait));
				}
				return list.isEmpty() ? null : list;
			}
		};
	}

}
