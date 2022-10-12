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


    public void chooseTwoRandomItemAtOnce() {

        Random rand = new Random();
        int randNumber = rand.nextInt(1, checkBoxFilterList.size());
        Random random = new Random();
        int randomNumber = random.nextInt(1, checkBoxFilterList.size());
        Actions act = new Actions(driver);
        if (randomNumber == randNumber) {
            if (randomNumber == checkBoxFilterList.size()) {
                act.click(checkBoxFilterList.get(randomNumber)).click(checkBoxFilterList.get(randomNumber - 1)).build().perform();
            } else if (randomNumber == 1) {
                act.click(checkBoxFilterList.get(randomNumber)).click(checkBoxFilterList.get(randomNumber + 1)).build().perform();
            }
        } else
            act.click(checkBoxFilterList.get(randNumber)).click(checkBoxFilterList.get(randomNumber)).build().perform();
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
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(buttonOfBackToTopText));
    }
}
