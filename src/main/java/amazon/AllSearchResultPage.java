package amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    @FindBy(xpath = "//*[text()='Best Seller']")
    protected List<WebElement> listItemWhereWriteBestSeller;
    @FindBy(xpath = "//*[text()='Next']")
    protected WebElement nextPageButton;
    @FindBy(xpath = "//*[@class='a-badge-supplementary-text a-text-ellipsis']")
    List<WebElement> textListWhenClickOnBestSellerButton;
    @FindBy(xpath = "//div[@class='a-section a-spacing-none puis-padding-right-small s-title-instructions-style']")
    protected List<WebElement> allItemListInPage;
    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']/span")
    protected WebElement resultCount;


    public boolean textVisibilityWhenClickOnBestSellerButton() {
        boolean textVisibility = false;
        Random random=new Random();
        int randomNumber=random.nextInt(1, listItemWhereWriteBestSeller.size());
        listItemWhereWriteBestSeller.get(randomNumber).click();
        boolean textContains = textListWhenClickOnBestSellerButton.get(randomNumber).getText().contains("in");
        if (textVisibility == false) {
            return textVisibility;
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
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(nextPageButton));
    }
}
