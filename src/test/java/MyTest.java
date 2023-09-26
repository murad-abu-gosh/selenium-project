import POM.CartComponent;
import POM.SearchBarComponent;
import POM.SearchPage;
import api.ApiClient;
import infra.Account;
import infra.WrappHttpResponse;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;


public class MyTest {

    private static WebDriver driver;

    @BeforeEach
    public void setUp() throws IOException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.rami-levy.co.il/he");


    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

//    @Test
    // this Test check if rest function     
    public void testLogin() throws IOException {
        //Arrange
        Account account = new Account("aaaaa@gmail.com", "muradelevation123", false, null);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WrappHttpResponse<JSONObject> loginResponse = ApiClient.login(account);
        System.out.println("user=====>" + loginResponse.getData().get("user").toString());

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        // Get the "user" JSONObject
        JSONObject userObject = new JSONObject(loginResponse.getData().get("user").toString());

        // Get the "first_name" value from the "user" JSONObject
        String firstName = userObject.getString("first_name");
        String s = "{\"authuser\":{\"user\":" + userObject.toString() + "}}";
        jsExecutor.executeScript(String.format("window.localStorage.setItem('ramilevy','%s')", s));
        driver.navigate().refresh();
        WebElement visibleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text()," + userObject.get("first_name").toString() + ")]")));
        boolean elementIsExcite = visibleElement.isDisplayed();
        Assert.assertTrue(elementIsExcite);

        driver.navigate().refresh();

    }

    @Test
    public void testSearchBarComponent() {
        SearchBarComponent searchBarComponent = new SearchBarComponent(driver);
        String searchInput = "bamba";
        searchBarComponent.executeFullSearchSequence(searchInput);


//        BasePage
        Assertions.assertEquals("https://www.rami-levy.co.il/he/online/search?q=" + searchInput, driver.getCurrentUrl());
    }

    @Test
    public void testAddItemToCart(){
        SearchBarComponent searchBarComponent = new SearchBarComponent(driver);
        String searchInput = "bamba";
        searchBarComponent.executeFullSearchSequence(searchInput);


        SearchPage searchPage = new SearchPage(driver);
        driver.navigate().refresh();
        searchPage.addItemToCartXTimes(0,1);
        searchPage.addItemToCartXTimes(1,2);
        searchPage.addItemToCartXTimes(2,3);

        Assertions.assertEquals(3, searchPage.getCartItemsCount());
    }

    @Test
    public void testEmptyCart() {
        SearchBarComponent searchBarComponent = new SearchBarComponent(driver);
        String searchInput = "bamba";
        searchBarComponent.executeFullSearchSequence(searchInput);


        SearchPage searchPage = new SearchPage(driver);
        driver.navigate().refresh();
        searchPage.addItemToCart(0);
        searchPage.addItemToCartXTimes(1,2);


        CartComponent cart = new CartComponent(driver);
        cart.executeEmptyCartSequence();

        Assertions.assertTrue(cart.isCartEmpty());

    }

//    @Test
//    public void testApi() throws IOException {
//        testLogin();
//
//        SearchPage searchPage = new SearchPage(driver);
//        CartComponent cart = new CartComponent(driver);
//
//        cart.addItemsToCart();
//
//        driver.navigate().refresh();
//
//
//
//    }


}