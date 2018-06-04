package shinoamakusa.selenium.pages.vpl.home;

import shinoamakusa.selenium.pages.BrowserPage;
import shinoamakusa.selenium.pages.vpl.results.ResultsPage;

public class HomePage extends BrowserPage {
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
