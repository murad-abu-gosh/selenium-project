package steps;

import POM.LoginComponent;
import POM.RamiLeviHomePage;
import api.ApiClient;

import infra.Account;
import infra.WrappHttpResponse;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logic.LoginResponse;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import context.TestContext;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class LoginSteps {

    private  WebDriver driver;




    public LoginSteps(Hooks hooks) {
        this.driver = hooks.getDriver();
    }

    @Given("I have navigated to Rami Levi")
    public void iHaveNavigatedToRamiLevi() {
        RamiLeviHomePage ramiLeviHomePage = new RamiLeviHomePage(driver);
        ramiLeviHomePage.openStatsPage();

    }
    @When("I login with user '{}' and password '{}'")
    public void OnRamiLeviHomePageIClickLogin(String user , String password) throws IOException {
        Account account = new Account(user , password , false , null);
        WrappHttpResponse<LoginResponse> loginResponse = ApiClient.login(account);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String userObject = ApiClient.serializeToJson(loginResponse.getData().getUser());
        String s ="{\"authuser\":{\"user\":" + userObject +"}}";
        System.out.println("s" + s );
        jsExecutor.executeScript(String.format("window.localStorage.setItem('ramilevy','%s')",s));
        driver.navigate().refresh();

    }

    @Then("On Rami Levi Home page - '{}'")
    public void OnRamiLeviHomepageMurad(String firstName) throws InterruptedException {

        RamiLeviHomePage ramiLeviHomePage = new RamiLeviHomePage(driver);

        String currentText = ramiLeviHomePage.getLoginComponent().getLoginUserText(firstName);

        Assert.assertEquals(firstName, currentText);
    }




}