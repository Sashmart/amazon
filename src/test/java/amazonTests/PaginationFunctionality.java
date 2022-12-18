package amazonTests;

import amazon.AllSearchResultPage;
import amazon.SearchResultPage;
import createDriver.CommonActions;
import createDriver.Config;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static amazon.CommonSteps.openHomePageAndChooseCategoryAndType;
@Test(groups = {"functional","paginationFunctionality"})
public class PaginationFunctionality {
    @BeforeMethod
    public void createDriver() {
        CommonActions.createDriver(Config.PLATFORM_AND_BROWSER);
    }

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

    }@AfterMethod
    public void tearDown() {
        if (CommonActions.getDriver() != null) {
            CommonActions.getDriver().close();
        }
    }

}
