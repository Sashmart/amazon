import amazon.*;
import createDriver.CommonActions;
import createDriver.Config;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static amazon.CommonSteps.openHomePageAndChooseCategoryAndType;
import static amazon.CommonSteps.openHomePageAndChooseDealsOfToday;

public class AmazonTest {


    @BeforeMethod
    public void createDriver() {
        CommonActions.createDriver(Config.PLATFORM_AND_BROWSER);
    }

    @Test
    public void testAmazon() {
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

        openHomePageAndChooseCategoryAndType();
        SearchResultPage searchResultPage = new SearchResultPage(CommonActions.getDriver());
        searchResultPage.waitForPageLoad();
        searchResultPage.chooseRandomItem();
        ProductPage productPage = new ProductPage(CommonActions.getDriver());
        productPage.waitForPageLoad();
        Assert.assertEquals(100, productPage.sumMarks());

    }

    @Test
    public void checkPaginationAndHoveringOnBestSeller() {

        openHomePageAndChooseCategoryAndType();
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

    @Test
    public void dealsOfTodayPageFunctionality() {
        openHomePageAndChooseDealsOfToday();
        DealsOfTodayPage dealsOfTodayPage = new DealsOfTodayPage(CommonActions.getDriver());
        dealsOfTodayPage.waitForPageLoad();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("Select All", dealsOfTodayPage.checkBoxFilterAboveText());
        dealsOfTodayPage.chooseTwoRandomItemAtOnce();
        dealsOfTodayPage.waitForPageLoad();
        softAssert.assertEquals("Clear All ", dealsOfTodayPage.checkBoxFilterAboveTextAfterChooseItem());
        dealsOfTodayPage.clickOnButtonClearAll();
        dealsOfTodayPage.waitForPageLoad();
        softAssert.assertFalse(dealsOfTodayPage.itemSelect());
        softAssert.assertAll();


    }

    @Test
    public void checkPriceFilterFunctionality() {
        openHomePageAndChooseDealsOfToday();
        DealsOfTodayPage dealsOfTodayPage = new DealsOfTodayPage(CommonActions.getDriver());
        dealsOfTodayPage.clickItemWhichHaveTextFashionOfWomenFromRitual();
        FashionOfWomenFromRitualPage fashionOfWomenFromRitualPage = new FashionOfWomenFromRitualPage(CommonActions.getDriver());
        fashionOfWomenFromRitualPage.waitForPageLoad();
        fashionOfWomenFromRitualPage.chooseProductWhichUpToTwentyFiveDollars();
        fashionOfWomenFromRitualPage.waitForPageLoad();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(fashionOfWomenFromRitualPage.firstPageOfThePaginationIsEnabled());
        softAssert.assertTrue(fashionOfWomenFromRitualPage.inFirsPageThereIsProductWhichIsLessOrEqualThanToTwentyFive());
        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown() {
        if (CommonActions.getDriver() != null) {
            CommonActions.getDriver().close();
        }
    }
}
