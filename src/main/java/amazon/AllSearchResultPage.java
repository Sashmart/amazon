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

    @FindBy(xpath = "//span[@class='a-badge-text']")
    protected List<WebElement> listItemWhereWriteBestSeller;
    @FindBy(xpath = "//span[@class='navFooterBackToTopText']")
    protected WebElement buttonOfBackToTopText;
    @FindBy(xpath = "//span[contains(@id,'best-seller-supplementary')]")
    protected List<WebElement> textListWhenClickOnBestSellerButton;
    @FindBy(xpath = "//div[contains(@class,'puis-padding-right-small')]")
    protected List<WebElement> allItemListInPage;
    @FindBy(xpath = "//div[contains(@class,' a-spacing-top-small')]/span")
    protected WebElement resultCount;


    public boolean textVisibilityWhenClickOnBestSellerButton() {
        boolean textVisibility = false;
        Random random=new Random();
        int randomNumber=random.nextInt(1, listItemWhereWriteBestSeller.size());
        Actions act=new Actions(driver);
        act.moveToElement(listItemWhereWriteBestSeller.get(randomNumber)).build().perform();
        boolean textContains = textListWhenClickOnBestSellerButton.get(randomNumber).getText().contains("in");
        textVisibility=textContains;
        if (textVisibility == false) {
            return false;
        }

        return textVisibility;
    }

    public int itemsCountInPage() {
        return allItemListInPage.size();
    }

    public int numberOfItemsAcrossPages() {
        String generalItemCount = resultCount.getText().substring(8, 11);
        return Integer.parseInt(generalItemCount);
    }

    public void waitForPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(buttonOfBackToTopText));
    }
}
