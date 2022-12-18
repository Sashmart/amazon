package amazonTests;

import createDriver.CommonActions;
import createDriver.Config;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TakeScreenShootPage {
    @BeforeMethod
    public void createDriver() {
        CommonActions.createDriver(Config.PLATFORM_AND_BROWSER);
    }

    public  void getScreenShoot() throws IOException {
        Date currentData=new Date();
        String screenshotFileName=currentData.toString().replace(" ","-").replace(":","-");
        File screenShotFile=((TakesScreenshot)CommonActions.getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShotFile,new File(".//screenShoot//"+screenshotFileName+".jpg"));
    }
    @AfterMethod
    public  void tearDown() {
        if (CommonActions.getDriver() != null) {
            CommonActions.getDriver().close();
        }
    }
}
