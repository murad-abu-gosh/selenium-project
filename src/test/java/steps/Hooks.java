package steps;

import api.ApiClient;
import context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import logic.requests.Profile;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Hooks {
    @Getter
    private WebDriver driver;
    private TestContext context;
    private Scenario scenario;

    public Hooks(TestContext context) {
        this.context = context;
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        context.put("driver", this.driver);
    }



//    @After
//    public void tearDown() {
//
//        if (driver != null) {
//            driver.quit();
//        }
//
//    }

    @After("@searchTest")
        public void tearDownSearch() {

        if (driver != null) {
            driver.quit();
        }

    }

    @After("@cartTest")
    public void tearDownCart() {

        if (driver != null) {
            driver.quit();
        }

    }

    @After("@LoginTest")
    public void tearDownLogin() {

        if (driver != null) {
            driver.quit();
        }
    }

    @After("@ResetPasswordTest")
    public void tearDownResetPassword() {
        if (driver != null) {
            ResetSteps.onLoginPopupIClickOnDashboardPage();
            ResetSteps.onDashboardPageClickOnResetPassword();
            ResetSteps.onResetPasswordPopupIChangeMuradelevationTo("Zxasqw12--IDK2" , "Zxasqw12--IDK");
            driver.quit();
        }

    }

    @After("@ResetUpdateProfile")
    public void tearDownUpdateProfile() {
        if (driver != null) {
            Profile profile =new Profile(  "Murad","Elevation","020-2002024",null,"1",null);
            ApiClient.update_profile(profile);
            driver.quit();
        }

    }

    public WebDriver getDriver() {
        return driver;
    }
}