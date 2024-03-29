package amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class AllSearchResultPage extends BasePage {

    public AllSearchResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[contains(@id,'best-seller-supplementary')]")
    protected List<WebElement> textWhenHoverBestSeller;
    @FindBy(xpath = "//span[@class='navFooterBackToTopText']")
    protected WebElement buttonOfBackToTopText;
    @FindBy(xpath = "//span[@class='a-badge-label-inner a-text-ellipsis']//span[text()='Best Seller']")
    protected List<WebElement> bestSellerProductList;
    @FindBy(xpath = "//a[contains(@class,' s-pagination-button')]")
    protected WebElement paginationButton;


    public boolean textVisibilityWhenHoverOnBestSellerButton() {

        Random random = new Random();
        int randomNumber = random.nextInt(1, bestSellerProductList.size() - 1);
        Actions act = new Actions(driver);
        act.moveToElement(bestSellerProductList.get(randomNumber)).build().perform();

        return textWhenHoverBestSeller.get(randomNumber).isDisplayed();

    }

    public boolean pageWithPagination() {
        return paginationButton.isDisplayed();
    }

    public int theNumberOfTheBestSellingItemOnThePage() {
        return bestSellerProductList.size();
    }


    public void waitForPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(buttonOfBackToTopText));
    }
}
