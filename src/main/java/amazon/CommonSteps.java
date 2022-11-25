package amazon;

import createDriver.CommonActions;

public class CommonSteps {
    public static void openHomePageAndChooseCategoryAndType(String category, String type) {

        HomePage homePage = new HomePage(CommonActions.getDriver());
        homePage.goTo();
        homePage.waitForPageLoad();
        homePage.selectATopicFromTheEntireSection();
        homePage.chooseCategory(category);
        homePage.chooseType(type);


    }

    public static void openHomePageAndChooseDealsOfToday() {
        HomePage homePage = new HomePage(CommonActions.getDriver());
        homePage.goTo();
        homePage.waitForPageLoad();
        homePage.dealsOfTodayButtonClick();
    }

}
