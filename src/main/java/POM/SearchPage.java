package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchPage extends BasePage {

    //    private final By productBoxes = By.xpath("//*[@id=\"min-height-product-X\"]");
    private final By plusButton = By.className("plus");
    //    private final By testXpath = By.xpath("//button[(contains(@class,\"plus\"))]");
    private final By plusButtonXpath = By.xpath("//*[@id=\"min-height-product-0\"]/div/div/div[4]/div/div/div/button");
    private final By minusButton = By.className("minus");

    private final By deliveryTimePopup = By.id("delivery-modal___BV_modal_body_");
    private final By closePopupButton = By.id("close-popup");
    private final By cartBadge = By.xpath("//*[@id=\"onlineCartHeader\"]/div[1]/div[1]/span[1]");

    public SearchPage(WebDriver driver) {
        super(driver);
        init();
    }

    @Override
    public void init() {
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);


    }

    public void addItemToCart(int itemIndex) {
        hoverOverItem(itemIndex);
        clickPlusButton();

    }

    public void addItemToCartXTimes(int itemIndex, int n) {
        for (int i = 0; i < n; i++) {
            hoverOverItem(itemIndex);
            clickPlusButton();

        }
    }

    private void hoverOverItem(int itemIndex) {
        By productBox = By.xpath("//*[@id=\"min-height-product-X\"]".replace("X", String.valueOf(itemIndex)));

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(productBox));

//        wait1();
        WebElement itemBox = driver.findElement(productBox);
//        WebElement itemBox = itemsBoxes.get(itemIndex);
        Actions actions = new Actions(driver);
        actions.moveToElement(itemBox).perform();


    }

    public void clickPlusButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(plusButton));
        driver.findElement(plusButton).click();
        if (isDeliveryPopupVisible()) {
//            wait1();
            closePopup();
        }
    }

    private void closePopup() {
        driver.findElement(closePopupButton).click();

    }

    private boolean isDeliveryPopupVisible() {
        return !driver.findElements(deliveryTimePopup).isEmpty();
    }

    public WebElement findItemBox(int itemIndex) {
        By productBoxes = By.xpath("//*[@id=\"min-height-product-X\"]".replace("X", String.valueOf(itemIndex)));
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(productBoxes));
        return driver.findElements(productBoxes).get(itemIndex);

    }

    public int getCartItemsCount() {
        return Integer.parseInt(driver.findElement(cartBadge).getText());

    }

    public void wait1() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void waitPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.id("min-height-product-0")));
    }


}
