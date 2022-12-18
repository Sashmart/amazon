package amazonTests;

import amazon.ProductPage;
import amazon.SearchResultPage;
import createDriver.CommonActions;
import createDriver.Config;
import org.testng.Assert;
import org.testng.annotations.*;

import static amazon.CommonSteps.openHomePageAndChooseCategoryAndType;
@Test(groups = {"functional","percentFunctionality"})
public class PercentFunctionality {
    @BeforeMethod
    public void createDriver() {
        CommonActions.createDriver(Config.PLATFORM_AND_BROWSER);
    }
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



    @AfterMethod
    public void tearDown() {
        if (CommonActions.getDriver() != null) {
            CommonActions.getDriver().close();
        }
    }

}
