package createDriver;

import createDriver.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;


public class CommonActions {
    private static WebDriver driver;

    public static void createDriver(String type) {

        switch (Config.PLATFORM_AND_BROWSER) {
            case "win_chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
            case "win_firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
            default:
                throw new RuntimeException("You do not choose direct driver");
        }
    }

    public static WebDriver getDriver() {

        return driver;
    }
}
