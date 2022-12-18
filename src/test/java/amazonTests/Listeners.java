package amazonTests;


import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;


public class Listeners implements ITestListener {


    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("TestCase Started and details are " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("TestCase Success and details are " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        TakeScreenShootPage takeScreenShootPage = new TakeScreenShootPage();
        try {
            takeScreenShootPage.getScreenShoot();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("TestCase skipped and details are" + result.getName());
    }

}
