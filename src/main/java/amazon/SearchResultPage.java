package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class SearchResultPage extends BasePage {

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small'][span]")
    private WebElement numberOfElementsOnPage;
    @FindBy(xpath = "//span[@class='navFooterBackToTopText']")
    protected WebElement buttonOfBackToTopText;
    @FindBy(xpath = "//div[@data-component-type='s-search-result']")
    protected List<WebElement> countOfItem;
    @FindBy(xpath = "//span[@class='a-color-state a-text-bold']")
    protected WebElement searchResultName;
    @FindBy(xpath = "//div[@class='nav-search-field ']/child::input")
    protected WebElement theValueOfTheNameToSearchFor;

    @FindBy(xpath = "//div[contains(@class,'search-result-card')]")
    List<WebElement> itemList;
    @FindBy(xpath = "//*[text()='See all results']")
    protected WebElement seeAllSearchResultButton;



    public int totalNumberOfElementsInPage() {
        String count = numberOfElementsOnPage.getText().substring(2, 4);
        return Integer.parseInt(count);
    }

    public int countOfItemInPage() {
        int countItem = 0;
        for (int i = 0; i < countOfItem.size(); i++) {
            ++countItem;
        }
        return countItem;
    }

    public String searchResultName() {
        return searchResultName.getText().substring(1, 8);
    }

    public String theValueOfTheNameToSearchFor() {
        return theValueOfTheNameToSearchFor.getAttribute("value");
    }

    public void chooseRandomItem() {
        Random random = new Random();
        int randomNumber = random.nextInt(1, itemList.size()-1);
        WebElement chooseRandomItem = driver.findElement
                (By.xpath("//div[contains(@class,'search-result-card')]" + "[" + randomNumber + "]"));
        chooseRandomItem.click();

    }

    public void waitForPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(buttonOfBackToTopText));
    }

    public void seeAllProductsInPaga() {
        seeAllSearchResultButton.click();
    }



}
