package amazonTests;

import amazon.DealsOfTodayPage;
import amazon.FashionOfWomenFromRitualPage;
import createDriver.CommonActions;
import createDriver.Config;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static amazon.CommonSteps.openHomePageAndChooseDealsOfToday;
@Test(groups ={ "functional","filterFunctionality"})
public class FilterFunctionalityTest  {

    @BeforeMethod
    public void createDriver() {
        CommonActions.createDriver(Config.PLATFORM_AND_BROWSER);
    }


    public void checkPriceFilterFunctionality() {
        openHomePageAndChooseDealsOfToday();
        DealsOfTodayPage dealsOfTodayPage = new DealsOfTodayPage(CommonActions.getDriver());
        dealsOfTodayPage.chooseCategory("Women's Fashion from Daily Ritual");
        FashionOfWomenFromRitualPage fashionOfWomenFromRitualPage = new FashionOfWomenFromRitualPage(CommonActions.getDriver());
        fashionOfWomenFromRitualPage.waitForPageLoad();
        fashionOfWomenFromRitualPage.chooseFilterPrice("Up to $25");
        fashionOfWomenFromRitualPage.waitForPageLoad();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(fashionOfWomenFromRitualPage.firstPageOfThePaginationIsEnabled(), "Front page is not enabled");
        softAssert.assertTrue(fashionOfWomenFromRitualPage.inFirsPageThereIsProductWhichIsLessOrEqualThanToTwentyFive(),
                "There is a product on the page with a price greater than or equal to the asking price");
        softAssert.assertAll();
    }
    @Test
    public void dealsOfTodayPageGrammarFunctionality() {
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
        softAssert.assertFalse(dealsOfTodayPage.anyOfTheItemsIsSelected());
        softAssert.assertAll();


    }
    @AfterMethod
    public  void tearDown() {
        if (CommonActions.getDriver() != null) {
            CommonActions.getDriver().close();
        }
    }}
