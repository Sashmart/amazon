package amazonTests;

import amazon.CostumerReviewsPage;
import amazon.HomePage;
import amazon.PaymentTypePage;
import amazon.ShopWithPointsPage;
import createDriver.CommonActions;
import createDriver.Config;
import org.testng.annotations.*;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

@Test(groups = {"functional","changesAfterRefresh"})

public class ChangesAfterRefreshFunctionality {

    @BeforeMethod
    public void createDriver() {
        CommonActions.createDriver(Config.PLATFORM_AND_BROWSER);
    }
    public void checkShoppingWithPointsReviews() {
        HomePage homePage = new HomePage(CommonActions.getDriver());
        homePage.goTo();
        homePage.waitForPageLoad();
        homePage.shopWithPointsButtonClick();
        ShopWithPointsPage shopWithPointsPage = new ShopWithPointsPage(CommonActions.getDriver());
        shopWithPointsPage.waitForPageLoad();
        shopWithPointsPage.choosePaymentType("Capital One");
        PaymentTypePage paymentTypePage = new PaymentTypePage(CommonActions.getDriver());
        paymentTypePage.goToLookCustomerRatings();
        CostumerReviewsPage costumerReviewsPage = new CostumerReviewsPage(CommonActions.getDriver());
        costumerReviewsPage.waitForPageLoad();
        costumerReviewsPage.selectFromCustomerReviewsByName(("Great"));
        costumerReviewsPage.waitForPageLoad();
        String costumerReviewsNameBeforePageRefresh = costumerReviewsPage.getCustomerReviewsName();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(costumerReviewsPage.countCostumerReviewsInPage() > 2);
        costumerReviewsPage.refreshPage();
        String costumerReviewsNameAfterPageRefresh = costumerReviewsPage.getCustomerReviewsName();
        softAssert.assertEquals(costumerReviewsNameBeforePageRefresh, costumerReviewsNameAfterPageRefresh);
        softAssert.assertAll();

    }@AfterMethod
    public void tearDown() {
        if (CommonActions.getDriver() != null) {
            CommonActions.getDriver().close();
        }
    }
}
