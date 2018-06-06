package shinoamakusa.selenium.pageobjects.vpl.home;

import shinoamakusa.selenium.core.pages.BasePage;
import shinoamakusa.selenium.pageobjects.vpl.results.ResultsPage;

public class HomePage extends BasePage {
	public HomePage()
	{
		this.urlPart = "vpl.ca";
	}
	public void open() {
		super.open();
		String homeUrl = new StringBuilder("https://").append(this.urlPart).toString();
		driver.goTo(homeUrl);
		this.title = driver.getTitle();

	}
	
	public ResultsPage searchFor(final String searchQuery) {
		String searchBoxID = "edit-search";
		String searchBtnID = "edit-submit";

		driver.search(driver.findByID(searchBoxID), driver.findByID(searchBtnID), searchQuery);
		
		return new ResultsPage(driver);

	}

}
