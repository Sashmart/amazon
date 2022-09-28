package amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchResultPage extends BasePage {

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small'][span]")
    private WebElement numberOfElementsOnPage;

    @FindBy(xpath = "//div[@data-component-type='s-search-result']")
    protected List<WebElement> countOfItem;
    @FindBy(xpath = "//span[@class='a-color-state a-text-bold']")
    protected WebElement searchResultName;
    @FindBy(xpath = "//div[@class='nav-search-field ']/child::input")
    protected WebElement theValueOfTheNameToSearchFor;

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

    public void waitForPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.elementToBeClickable(countOfItem.get(countOfItemInPage() - 1)));
    }
}
