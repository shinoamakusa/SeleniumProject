package shinoamakusa.selenium.tests.vpl;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import shinoamakusa.selenium.pages.vpl.details.DetailsPage;

public class DetailsPaginationCheck extends BaseTest {
	@Test
	public void detailsPaginationCheck() {
		DetailsPage detailsPage = resultsPage.goToFirstResult();

		detailsPage = detailsPage.goToNextItem();
		assertTrue(detailsPage != null);
		detailsPage = detailsPage.goToNextItem();
		assertTrue(detailsPage != null);

		detailsPage = detailsPage.goToPreviousItem();
		assertTrue(detailsPage != null);
		assertTrue(detailsPage.visitedBefore(), "Previous link page was not visited before");
		detailsPage = detailsPage.goToPreviousItem();
		assertTrue(detailsPage != null);
		assertTrue(detailsPage.visitedBefore(), "Previous link page was not visited before");

	}

}
