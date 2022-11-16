package amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentTypePage extends BasePage {
    public PaymentTypePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'customer ratings')]")
    protected WebElement customerRatingsButton;
    @FindBy(id = "a-autoid-10-announce")
    protected WebElement writeACostumerReviewButton;

    public void goToLookCustomerRatings() {
        customerRatingsButton.click();
    }

    public void waitForPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(writeACostumerReviewButton));
    }
}
