package amazonTests;

import amazon.AllSearchResultPage;
import amazon.SearchResultPage;
import amazonTests.BaseTestPage;
import createDriver.CommonActions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static amazon.CommonSteps.openHomePageAndChooseCategoryAndType;

public class PaginationFunctionality extends BaseTestPage {
    @Test
    public void checkPaginationAndHoveringOnBestSeller() {

        openHomePageAndChooseCategoryAndType("Smart Home", "Smart Home Lighting");
        SearchResultPage searchResultPage = new SearchResultPage(CommonActions.getDriver());
        searchResultPage.waitForPageLoad();
        searchResultPage.seeAllProductsInPaga();
        AllSearchResultPage allSearchResultPage = new AllSearchResultPage(CommonActions.getDriver());
        allSearchResultPage.waitForPageLoad();
        SoftAssert softAssert = new SoftAssert();
        if (allSearchResultPage.theNumberOfTheBestSellingItemOnThePage() > 0) {
            softAssert.assertTrue(allSearchResultPage.textVisibilityWhenHoverOnBestSellerButton());

        }
        softAssert.assertTrue(allSearchResultPage.pageWithPagination());
        softAssert.assertAll();

    }
}
