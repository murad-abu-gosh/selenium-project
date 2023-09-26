package steps;


import POM.LoginComponent;
import POM.RamiLeviHomePage;
import api.ApiClient;

import infra.WrappHttpResponse;
import logic.requests.Account;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logic.response.LoginResponse;

import org.junit.Assert;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import context.TestContext;


import java.io.IOException;


import logic.requests.Account;



public class LoginSteps {

    private  WebDriver driver;

    private TestContext context;
    private RamiLeviHomePage homePage;

public LoginSteps(TestContext context) {
    this.context=context;
    this.driver =context.get("driver");
}


    @Given("I have navigated to Rami Levi")
    public void iHaveNavigatedToRamiLevi() {
        RamiLeviHomePage ramiLeviHomePage = new RamiLeviHomePage(driver);
        ramiLeviHomePage.openStatsPage();
        context.put("main",ramiLeviHomePage);
        homePage = context.get("main");
        context.print();

    }
    @When("I login with user '{}' and password '{}'")
    public void OnRamiLeviHomePageIClickLogin(String user , String password) throws IOException {
        Account account = new Account(user , password , false , null);
        WrappHttpResponse<LoginResponse> loginResponse = ApiClient.login(account);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String userObject = ApiClient.serializeToJson(loginResponse.getData().getUser());
        String s ="{\"authuser\":{\"user\":" + userObject +"}}";
        jsExecutor.executeScript(String.format("window.localStorage.setItem('ramilevy','%s')",s));
        driver.navigate().refresh();
    }

    @Then("On Rami Levi Home page - '{}'")

    public void OnRamiLeviHomepageMurad(String firstName) throws InterruptedException {

//        RamiLeviHomePage ramiLeviHomePage = new RamiLeviHomePage(driver);
        System.out.println("firstName" + firstName);

        String currentText = homePage.getLoginComponent().getLoginUserText(firstName);

        Assert.assertEquals(firstName, currentText);
        Assert.assertEquals(firstName, currentText);

    }





}