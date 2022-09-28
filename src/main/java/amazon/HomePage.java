package amazon;

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

    public void goTo() {
        driver.get(SITE_URL);
    }

    public void chooseCategory(String topicName) {
        chooseTopic.click();
        chooseTopic.sendKeys(topicName);
    }

    public void writeByName(String favoriteName) {
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

    public void waitForPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(shopsBasket));
    }
}
