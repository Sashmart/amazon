package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ShopWithPointsPage extends BasePage {
    public ShopWithPointsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(@class,'image--light')]")
    protected List<WebElement> kindsOfPaymentList;

    public void choosePaymentType(String paymentType) {
        driver.findElement(By.xpath("//img[@alt='" + paymentType + "']")).click();
    }

    public void waitForPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.elementToBeClickable(kindsOfPaymentList.get(kindsOfPaymentList.size() - 1)));
    }
}
