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

public class DealsOfTodayPage extends BasePage {
    public DealsOfTodayPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//li[contains(@class,'CheckboxFilter-module')]")
    protected List<WebElement> checkBoxFilterList;
    @FindBy(xpath = "//a[@aria-label='Select all departments']")
    protected WebElement checkBoxFilterAboveText;
    @FindBy(xpath = "//a[@aria-label='Clear departments filter']")
    protected WebElement checkBoxFilterAboveTextWhenChooseItem;
    @FindBy(xpath = "//div[@class='a-row a-spacing-small']")
    protected List <WebElement> listOfItemsInPage;


    public void chooseTwoRandomItemAtOnce() {

        Random rand = new Random();
        Actions act = new Actions(driver);
        act.click(checkBoxFilterList.
                get(rand.nextInt(1,checkBoxFilterList.size()/2))).click(checkBoxFilterList.
                get(rand.nextInt(checkBoxFilterList.size()/2+1,checkBoxFilterList.size()))).build().perform();
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

    public boolean itemSelect() {
        boolean itemSelect = true;
        for (int i = 0; i < checkBoxFilterList.size(); i++) {
            itemSelect = checkBoxFilterList.get(i).isSelected();
            if (itemSelect == true) {
                return itemSelect;
            }

        }
        return itemSelect;
    }

    public void waitForPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.
                elementToBeClickable(listOfItemsInPage.get(listOfItemsInPage.size()-1)));
    }
}
