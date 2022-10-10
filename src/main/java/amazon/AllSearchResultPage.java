package amazon;

import org.openqa.selenium.By;
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

    @FindBy(xpath = "//span[@class='a-badge-text']")
    protected List<WebElement> listItemWhereWriteBestSeller;
    @FindBy(xpath = "//span[@class='navFooterBackToTopText']")
    protected WebElement buttonOfBackToTopText;
    @FindBy(xpath = "//span[contains(@id,'best-seller-supplementary')]")
    protected List<WebElement> textListWhenHoverOnBestSellerButton;
    @FindBy(xpath = "//a[contains(@class,' s-pagination-button')]")
    protected WebElement paginationButton;

    public boolean textVisibilityWhenHoverOnBestSellerButton() {

        Random random = new Random();
        int randomNumber = random.nextInt(listItemWhereWriteBestSeller.size());
        if (listItemWhereWriteBestSeller.get(randomNumber).isDisplayed()) {
            Actions act = new Actions(driver);
            act.moveToElement(listItemWhereWriteBestSeller.get(randomNumber)).build().perform();

        }
        return textListWhenHoverOnBestSellerButton.get(randomNumber).isDisplayed();

    }

    public boolean pageWithPagination() {
        return paginationButton.isEnabled();
    }

    public void waitForPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(buttonOfBackToTopText));
    }
}
