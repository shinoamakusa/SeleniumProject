package shinoamakusa.selenium.pages.vpl.results;

import static org.testng.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;

import shinoamakusa.selenium.framework.drivers.BrowserDriver;
import shinoamakusa.selenium.pages.BrowserPage;
import shinoamakusa.selenium.pages.vpl.details.DetailsPage;

public class ResultsPage extends BrowserPage {

	public String author;
	public String itemTitle;
	public String subtitle;

	public ResultsPage(BrowserDriver driver) {
		this.driver = driver;
		this.urlPart = "vpl.bibliocommons.com";
		this.title = this.driver.getTitle();
	}

	public ResultsPage broadenSearch() {
		driver.click(driver.findByClass("extendSearch"));
		return new ResultsPage(driver);

	}

	public void getResultInfo(int num) {
		driver.setParentElement(driver.findByClass("listItem", num));

		driver.select(driver.getParentElement().findByAttribute("testid", "bib_link"));
		itemTitle = driver.getSelectedElement().getText().trim();

		driver.select(driver.getParentElement().findByClass("subTitle"));
		subtitle = driver.getSelectedElement().getText().trim();

		driver.select(driver.getParentElement().findByAttribute("testid", "author_search"));
		author = driver.getSelectedElement().getText().trim();
	}

	/**
	 * Gets search results count
	 * 
	 * @return Number of search results
	 */
	public int getResultsCount() {
		driver.select(driver.findByClass("items_showing_count", 1));
		assertTrue(driver.getSelectedElement() != null, "Results count element does not exist");

		String[] elementParts = driver.getSelectedElement().getText().split(" ");
		assertTrue(elementParts.length >= 5, "Results count element format is invalid");
		assertTrue(StringUtils.isNumeric(elementParts[4]), "Selected results count element part is not numeric");
		return Integer.parseInt(elementParts[4]);
	}

	public DetailsPage goToFirstResult() {
		goToResult(1);
		return new DetailsPage(driver);
	}

	public boolean searchResultsExist() {
		return getResultsCount() > 0;
	}

	/**
	 * Follows the link of the first search result
	 */
	private void goToResult(int num) {
		if (driver.getParentElement() == null)
			driver.setParentElement(driver.findByClass("listItem", num));

		driver.select(driver.getParentElement().findByAttribute("testid", "bib_link"));

		driver.click(driver.getSelectedElement());
	}

}
