package amazonTests;

import createDriver.CommonActions;
import createDriver.Config;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTestPage {

    @BeforeMethod
    public void createDriver() {
        CommonActions.createDriver(Config.PLATFORM_AND_BROWSER);
    }

    @AfterMethod
    public void tearDown() {
        if (CommonActions.getDriver() != null) {
            CommonActions.getDriver().close();
        }
    }
}
