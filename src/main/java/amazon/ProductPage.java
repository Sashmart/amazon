package amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//td[@class='a-text-right a-nowrap']/child::span/child::a")
    List<WebElement> productMarks;
    @FindBy(xpath = "//a[@data-hook='cr-ratings-explanation-expand']")
    protected WebElement howCustomerReviewsAndRatingsWorkButton;

    public int sumMarks() {
        int sumMarks = 0;
        for (int i = 0; i < productMarks.size(); i++) {
            String interestRate = productMarks.get(i).getAttribute("title").substring(18, 20).replaceAll("%", " ").replaceAll(" ", "");
            sumMarks += Integer.parseInt(interestRate);
        }
        return sumMarks;
    }

    public void waitForPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(howCustomerReviewsAndRatingsWorkButton));
    }
}
