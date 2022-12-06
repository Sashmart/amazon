package amazonTests;

import amazon.*;
import createDriver.CommonActions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SearchResultsFunctionality extends BaseTestPage {
    @Test
    public void checkSearchResultFunctionality() {
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


}
