package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class FashionOfWomenFromRitualPage extends BasePage {

    public FashionOfWomenFromRitualPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='a-declarative']/span[contains(text(),'Up to $25')]")
    protected WebElement upToTwentyFIveDollarsButton;
    @FindBy(xpath = "//span[@class='a-price-whole']")
    protected List<WebElement> listOfIntegerPriceOfTheItem;
    @FindBy(xpath = "//span[@class='a-price-fraction']")
    protected List<WebElement> listOfDoublePriceOfTheItem;
    @FindBy(xpath = "//div[contains(@class,'a-box-inner')]")
    protected WebElement shopAllDealsButton;
    @FindBy(xpath = "//li[@data-page-number='1']")
    protected WebElement firstPageOfThePagination;

    public void filterPrice(String price)
    {
        try {
            driver.findElement(By.linkText(price)).click();

        } catch (Exception e) {

            System.out.println("There is no such filter on the page ");

        }

    }

    public boolean inFirsPageThereIsProductWhichIsLessOrEqualThanToTwentyFive() {
        boolean productPriceLessThanOrEqualToTwentyFive = true;

        for (int i = 0; i < listOfIntegerPriceOfTheItem.size(); i++) {
            String productPrice = listOfIntegerPriceOfTheItem.get(i).getText() + "." + listOfDoublePriceOfTheItem.get(i).getText();
            if (Double.parseDouble(productPrice) >= 25) {
                productPriceLessThanOrEqualToTwentyFive = false;
                return productPriceLessThanOrEqualToTwentyFive;
            }

        }
        return productPriceLessThanOrEqualToTwentyFive;
    }

    public boolean firstPageOfThePaginationIsEnabled() {
        return firstPageOfThePagination.isEnabled();
    }

    public void waitForPageLoad() {

        new WebDriverWait(driver, Duration.ofSeconds(20)).
                    until(ExpectedConditions.elementToBeClickable(shopAllDealsButton));
        super.waitForPageLoad();


    }
}
