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
import java.util.NoSuchElementException;
import java.util.Random;

public class DealsOfTodayPage extends BasePage {
    public DealsOfTodayPage(WebDriver driver) {
        super(driver);
    }

    private final String theNameOfItemClass = "//div[contains(@class,'DealGridItem-module__dealItemContent')]";

    @FindBy(xpath = "//li[contains(@class,'CheckboxFilter-module')]")
    protected List<WebElement> checkBoxFilterList;
    @FindBy(xpath = "//a[@aria-label='Select all departments']")
    protected WebElement checkBoxFilterAboveText;
    @FindBy(xpath = "//a[@aria-label='Clear departments filter']")
    protected WebElement checkBoxFilterAboveTextWhenChooseItem;


    public void chooseTwoRandomItemAtOnce() {

        Random rand = new Random();
        Actions act = new Actions(driver);
        act.click(checkBoxFilterList.
                get(rand.nextInt(1, checkBoxFilterList.size() / 2))).click(checkBoxFilterList.
                get(rand.nextInt(checkBoxFilterList.size() / 2 + 1, checkBoxFilterList.size()))).build().perform();
    }

    public String checkBoxFilterAboveText() {
        return checkBoxFilterAboveText.getText();
    }

    public String checkBoxFilterAboveTextAfterChooseItem() {
        return checkBoxFilterAboveTextWhenChooseItem.getText();
    }

    public void clickOnButtonClearAll() {
        checkBoxFilterAboveTextWhenChooseItem.click();
    }

    public boolean anyOfTheItemsIsSelected() {
        for (int i = 0; i < checkBoxFilterList.size(); i++) {
            if (checkBoxFilterList.get(i).isSelected()) {
                return true;
            }

        }
        return false;

    }

    public void clickTheElementThatHasTheFollowingText(String name) {

        try {
            driver.findElement(By.linkText(name)).click();

        } catch (Exception e) {

            System.out.println("The requested product is not available on the page");
        }
    }

    public void waitForPageLoad() {
        WebElement itemClassName = driver.findElement(By.xpath(theNameOfItemClass));
        new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className(theNameOfItemClass), 0));
        new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.visibilityOfAllElements(itemClassName));

        super.waitForPageLoad();
    }

}
