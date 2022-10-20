package amazon;

import createDriver.CommonActions;

public class CommonSteps {
    public static void openHomePageAndChooseCategoryAndType() {

        HomePage homePage = new HomePage(CommonActions.getDriver());
        homePage.goTo();
        homePage.waitForPageLoad();
        homePage.selectATopicFromTheEntireSection();
        homePage.chooseCategory("Smart Home");
        homePage.chooseType("Smart Home Lighting");


    }

    public static void openHomePageAndChooseDealsOfToday() {
        HomePage homePage = new HomePage(CommonActions.getDriver());
        homePage.goTo();
        homePage.waitForPageLoad();
        homePage.dealsOfTodayButtonClick();
    }
}
