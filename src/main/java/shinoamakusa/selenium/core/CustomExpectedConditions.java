package main.java.shinoamakusa.selenium.core;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import main.java.shinoamakusa.selenium.core.elements.PageElement;

public class CustomExpectedConditions {
	
	/**
	 * Gets a list of all elements matched by child selector within parent filterElement
	 * 
	 * @param parent
	 *            Parent filterElement
	 * @param childLocator
	 *            Locator for filterElement to match within parent filterElement
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
					list.add(new PageElement(element));
				}
				return list.isEmpty() ? null : list;
			}
		};
	}

}
