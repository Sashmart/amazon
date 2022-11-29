package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CostumerReviewsPage extends BasePage {
    public CostumerReviewsPage(WebDriver driver) {
        super(driver);
    }

    private String aWordInCostumerReviews;
    private String dataHookOfCostumerReviewsInPage = "//div[@data-hook='review']";
    @FindBy(xpath = "//input[@type='search']")
    protected WebElement searchCostumerReviewsButton;
    @FindBy(id = "cm_cr-footer_dp_link")
    protected WebElement seeAllDetailsForShopWithPointsButton;
    @FindBy(xpath = "//div[@data-hook='review']")
    protected List<WebElement> costumersReviewsInPage;


    public void selectFromCustomerReviewsByName(String name) {
        searchCostumerReviewsButton.click();
        searchCostumerReviewsButton.sendKeys(name);
        searchCostumerReviewsButton.sendKeys(Keys.ENTER);
    }

    public String getCustomerReviewsName() {
        return searchCostumerReviewsButton.getAttribute("value");
    }

    public int countCostumerReviewsInPage() {
        return costumersReviewsInPage.size();
    }


    public void refreshPage() {

        driver.navigate().refresh();
    }


    public void waitForPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.elementToBeClickable(seeAllDetailsForShopWithPointsButton));
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(dataHookOfCostumerReviewsInPage), 0));
    }
}
