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
    public CartComponent(WebDriver driver) {
        super(driver);
    }


    private void clickEmptyCartButton(){
        clickButton(emptyCartButton);
    }

    private void clickConfirmEmptyCartButton(){
        clickButton(confirmEmptyCartButton);
    }

    public void executeEmptyCartSequence(){
        clickEmptyCartButton();
        clickConfirmEmptyCartButton();
    }

    public boolean isCartEmpty(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(emptyCartDiv));
        return !driver.findElements(emptyCartDiv).isEmpty();
    }

    public void addItemsToCart(){
        HttpFacade.makeHttpRequest(JSONObject.class, "https://www.rami-levy.co.il/api/v2/cart", HttpMethod.POST, "{\"store\":331,\"isClub\":0,\"supplyAt\":\"2023-09-21T16:22:33.754Z\",\"items\":{\"292\":\"1.00\"},\"meta\":null}");
    }




}
