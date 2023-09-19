package steps;

import POM.LoginComponent;
import api.ApiClient;
import com.beust.ah.A;
import com.fasterxml.jackson.databind.ObjectMapper;
import infra.Account;
import infra.WrappHttpResponse;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logic.LoginResponse;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import context.TestContext;
import java.io.IOException;
import java.time.Duration;


public class LoginSteps {

    private static WebDriver driver;


//    @BeforeEach
//    public void setUp() throws IOException {
//        System.setProperty("webdriver.chrome.driver", "/Users/user/IdeaProjects/testing-with-selenium/chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.get("https://www.rami-levy.co.il/he");
//
//
//    }

//    @AfterEach
//    public void tearDown() {
//        driver.quit();
//    }

    public LoginSteps(Hooks hooks) {
        this.driver = hooks.getDriver();
    }

    @Given("I have navigated to Rami Levi")
    public void iHaveNavigatedToRamiLevi() {

        driver.get("https://www.rami-levy.co.il/he");
    }
    @When("I login with user 'aaaaa@gmail.com' and password 'muradelevation123")
    public void OnRamiLeviHomePageIClickLogin() throws IOException {
        Account account = new Account("aaaaa@gmail.com" , "muradelevation123" , false , null);
        WrappHttpResponse<LoginResponse> loginResponse = ApiClient.login(account);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String userObject = ApiClient.serializeToJson(loginResponse.getData().getUser());
        String s ="{\"authuser\":{\"user\":" + userObject +"}}";
        jsExecutor.executeScript(String.format("window.localStorage.setItem('ramilevy','%s')",s));
        driver.navigate().refresh();
    }

    @Then("On Rami Levi Home page - 'Murad'")
    public void OnRamiLeviHomepageMurad() {
        LoginComponent login = new LoginComponent(driver);
        Assert.assertTrue(login.waitUserName(driver , "Murad"));
    }
//
//    @Test
//    // this Test check if rest function
//    public void test_create_resturant() throws IOException {
//        //Arrange
//        Account account = new Account("aaaaa@gmail.com" , "muradelevation123" , false , null);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        WrappHttpResponse<LoginResponse> loginResponse = ApiClient.login(account);
//
//
//        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//
//        // Get the "first_name" value from the "user" JSONObject
//
//        String firstName =loginResponse.getData().getUser().getFirst_name();
//        String userObject = serializeToJson(loginResponse.getData().getUser());
//        System.out.println("user=====>" + userObject);
//        String s ="{\"authuser\":{\"user\":" + userObject +"}}";
//        jsExecutor.executeScript(String.format("window.localStorage.setItem('ramilevy','%s')",s));
//        driver.navigate().refresh();
////        WebElement visibleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),"+firstName+ ")]")));
////        boolean elementIsExcite = visibleElement.isDisplayed();
////        Assert.assertTrue(elementIsExcite);
//
//        driver.navigate().refresh();
//
//    }
//    private static String serializeToJson(Object obj) {
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            System.out.println(obj);
//            return objectMapper.writeValueAsString(obj);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }






}