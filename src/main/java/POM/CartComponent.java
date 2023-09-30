package POM;

import infra.HttpFacade;
import infra.HttpMethod;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class CartComponent extends BaseComponent{

    private final By cartDiv = By.className("demo-cart");
    private final By emptyCartButton = By.id("remove-cart");
    private final By confirmEmptyCartButton = By.id("delete-cart-btn");
    private final By emptyCartDiv = By.className("empty-cart-main");

    private final By cartBadge = By.xpath("//*[@id=\"onlineCartHeader\"]/div[1]/div[1]/span[1]");

    public CartComponent(WebDriver driver) {
        super(driver);
    }

    @Override
    public void init() {

    }


    private void clickEmptyCartButton(){
        clickButton(emptyCartButton);
    }

    private void clickConfirmEmptyCartButton(){
        clickButton(confirmEmptyCartButton);
    }

    public void executeEmptyCartSequence(){
        if (isCartEmpty()){
            return;
        }
        clickEmptyCartButton();
        clickConfirmEmptyCartButton();
    }

    public boolean isCartEmpty(){
        try{
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(emptyCartDiv));

        } catch (org.openqa.selenium.TimeoutException exception){
            exception.printStackTrace();
        }
        return !driver.findElements(emptyCartDiv).isEmpty();
    }

    public int getCartItemsCount() {
        return Integer.parseInt(driver.findElement(cartBadge).getText());

    }




}
