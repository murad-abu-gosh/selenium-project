package steps;

import POM.RamiLeviHomePage;
import api.ApiClient;
import context.TestContext;
import logic.requests.Account;
import infra.WrappHttpResponse;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logic.response.LoginResponse;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class ResetSteps {

    private TestContext context;
    private RamiLeviHomePage homePage;
    private WebDriver driver;
    public ResetSteps(TestContext context){
        this.context=context;
    }

    @Given("On Rami Levi home page - I click on {string} profile")
    public void onRamiLeviHomePageIClickOnMuradProfile(String firstName) {
        driver = context.get("driver");
        homePage = context.get("main");
        homePage.getLoginComponent().getLoginUserText(firstName);
        homePage.getLoginComponent().clickOnProfile();
    }
    @And("On login popup - I click on  dashboard page")
    public void onLoginPopupIClickOnDashboardPage() {

        homePage.getLoginComponent().clickOnDashboard();
    }


    @When("On dashboard page - click on reset password")
    public void onDashboardPageClickOnResetPassword() {
        homePage.getDashBoard().click_on_reset_password();
    }




    @And("On dashboard page - I do logout")
    public void onDashboardPageIDoLogout() {
        homePage.getDashBoard().click_on_log_out();
    }

    @And("On reset password popup - I change {string} to {string}")
    public void onResetPasswordPopupIChangeMuradelevationTo(String  oldPass, String newPass) {
        homePage.getDashBoard().write_on_old_password_input(oldPass);
        homePage.getDashBoard().write_on_password_input(newPass);
        homePage.getDashBoard().write_on_confirm_password_input(newPass);
        homePage.getDashBoard().click_on_save_password();

    }
}
