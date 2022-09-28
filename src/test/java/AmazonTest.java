import amazon.HomePage;
import amazon.SearchResultPage;
import createDriver.CommonActions;
import createDriver.Config;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AmazonTest {

    @Test
    public void TestAmazon() {
        CommonActions.createDriver(Config.PLATFORM_AND_BROWSER);
        HomePage homePage = new HomePage(CommonActions.getDriver());
        homePage.goTo();
        homePage.waitForPageLoad();
        homePage.chooseCategory("Books");
        homePage.writeByName("Grammar");
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

    @AfterMethod(alwaysRun = true)
    public void close() {
        if (Config.HOLD_BROWSER_OPEN) {
            CommonActions.getDriver().quit();
        }
    }
}
