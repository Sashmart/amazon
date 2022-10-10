import amazon.*;
import createDriver.CommonActions;
import createDriver.Config;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AmazonTest {

    @Test
    public void testAmazon() {
        CommonActions.createDriver(Config.PLATFORM_AND_BROWSER);
        HomePage homePage = new HomePage(CommonActions.getDriver());
        homePage.goTo();
        homePage.waitForPageLoad();
        homePage.chooseTopic("Books");
        homePage.searchByName("Grammar");
        homePage.searchButtonClick();
        String myCountryOfResidence = "Armenia";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(myCountryOfResidence, homePage.defaultCountry());
        SearchResultPage searchResultPage = new SearchResultPage(CommonActions.getDriver());
        searchResultPage.waitForPageLoad();
        softAssert.assertEquals(searchResultPage.countOfItemInPage(), searchResultPage.totalNumberOfElementsInPage());
        softAssert.assertEquals(searchResultPage.theValueOfTheNameToSearchFor(), searchResultPage.searchResultName());
        softAssert.assertAll();
    }

    @Test
    public void amazonTestOfPercentFunctionality() {
        CommonActions.createDriver(Config.PLATFORM_AND_BROWSER);
        HomePage homePage = new HomePage(CommonActions.getDriver());
        homePage.goTo();
        homePage.waitForPageLoad();
        homePage.selectATopicFromTheEntireSection();
        homePage.waitForPageLoad();
        homePage.chooseCategory("Smart Home");
        homePage.waitForPageLoad();
        homePage.chooseType("Smart Home Lighting");
        SearchResultPage searchResultPage = new SearchResultPage(CommonActions.getDriver());
        searchResultPage.waitForPageLoad();
        searchResultPage.chooseRandomItem();
        ProductPage productPage = new ProductPage(CommonActions.getDriver());
        productPage.waitForPageLoad();
        Assert.assertEquals(100, productPage.sumMarks());

    }

    @Test
    public void checkPaginationAndHoveringOnBestSeller() {
        CommonActions.createDriver(Config.PLATFORM_AND_BROWSER);
        HomePage homePage = new HomePage(CommonActions.getDriver());
        homePage.goTo();
        homePage.waitForPageLoad();
        homePage.selectATopicFromTheEntireSection();
        homePage.waitForPageLoad();
        homePage.chooseCategory("Smart Home");
        homePage.waitForPageLoad();
        homePage.chooseType("Smart Home Lighting");
        SearchResultPage searchResultPage = new SearchResultPage(CommonActions.getDriver());
        searchResultPage.waitForPageLoad();
        searchResultPage.seeAllProductsInPaga();
        AllSearchResultPage allSearchResultPage = new AllSearchResultPage(CommonActions.getDriver());
        allSearchResultPage.waitForPageLoad();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(allSearchResultPage.textVisibilityWhenHoverOnBestSellerButton());
        softAssert.assertTrue(allSearchResultPage.pageWithPagination());
        softAssert.assertAll();


    }

    @AfterMethod
    public void tearDown() {
        if (CommonActions.getDriver()!=null) {
            CommonActions.getDriver().quit();
        }
    }
}
