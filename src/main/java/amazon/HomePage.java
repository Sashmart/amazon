package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "searchDropdownBox")
    private WebElement chooseTopic;
    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchName;
    @FindBy(id = "glow-ingress-line2")
    private WebElement defaultCountry;
    @FindBy(id = "nav-cart")
    private WebElement shopsBasket;
    @FindBy(xpath = "//a[@aria-label='Open Menu']")
    private WebElement chooseTopicAll;
    @FindBy(xpath = "//a[@aria-label='Open Menu']")
    private WebElement chooseType;
    @FindBy(xpath = "//div[@class='nav-logo-base nav-sprite']")
    protected WebElement logo;
    @FindBy(xpath = "//a[text()='Sign in']")
    protected WebElement signInButton;
    @FindBy(xpath = "//a[text()='Other Solutions']")
    protected WebElement itemTopic;

    public void goTo() {
        driver.get(SITE_URL);
    }

    public void chooseTopic(String topicName) {
        chooseTopic.click();
        chooseTopic.sendKeys(topicName);
    }

    public void searchByName(String favoriteName) {
        searchName.click();
        searchName.sendKeys(favoriteName);
    }

    public void searchButtonClick() {
        searchName.sendKeys(Keys.ENTER);
    }

    public String defaultCountry() {
        String country = defaultCountry.getText();
        return country;
    }

    public void chooseTopicButton() {
        chooseTopicAll.click();

    }

    public void chooseCategory(String category) {
        WebElement chooseType = driver.findElement(By.xpath("//div[text()='" + category + "']"));
        chooseType.click();

    }

    public void chooseType(String type) {
        WebElement chooseCategory = driver.findElement(By.xpath("//a[text()='" + type + "']"));
        chooseCategory.click();
    }

    public void waitForLastCategoryItemVisibility() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(signInButton));

    }

    public void waitWhileLastTopicItemVisibility() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(itemTopic));
    }

    public void waitForPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(shopsBasket));
    }
}
