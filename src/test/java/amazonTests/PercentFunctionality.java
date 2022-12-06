package amazonTests;

import amazon.ProductPage;
import amazon.SearchResultPage;
import amazonTests.BaseTestPage;
import createDriver.CommonActions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static amazon.CommonSteps.openHomePageAndChooseCategoryAndType;

public class PercentFunctionality extends BaseTestPage {
    @Test
    public void amazonTestOfPercentFunctionality() {

        openHomePageAndChooseCategoryAndType("Smart Home", "Smart Home Lighting");
        SearchResultPage searchResultPage = new SearchResultPage(CommonActions.getDriver());
        searchResultPage.waitForPageLoad();
        searchResultPage.chooseRandomItem();
        ProductPage productPage = new ProductPage(CommonActions.getDriver());
        productPage.waitForPageLoad();
        Assert.assertEquals(100, productPage.sumMarks());

    }

}
