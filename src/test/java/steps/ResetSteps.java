package steps;

import POM.RamiLeviHomePage;
import api.ApiClient;
import infra.Account;
import infra.WrappHttpResponse;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logic.LoginResponse;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class ResetSteps {

    private WebDriver driver;


    public ResetSteps(Hooks hooks) {
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

    @And("On login popup - I click on  dashboard page")
    public void onLoginPopupIClickOnDashboardPage() {
        RamiLeviHomePage ramiLeviHomePage = new RamiLeviHomePage(driver);
        ramiLeviHomePage.getLoginComponent().clickOnDashboard();
    }

    @When("On dashboard page - click on reset password")
    public void onDashboardPageClickOnResetPassword() {
    }


    @And("On Rami Levi home page - I click on {string} profile")
    public void onRamiLeviHomePageIClickOnMuradProfile(String firstName) {
        RamiLeviHomePage ramiLeviHomePage = new RamiLeviHomePage(driver);
        ramiLeviHomePage.getLoginComponent().getLoginUserText(firstName);
        ramiLeviHomePage.getLoginComponent().clickOnProfile();
    }
}
