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

    private  WrappHttpResponse<LoginResponse> loginResponse;

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
        String recaptcha ="03AFcWeA7ZPc-5FVSYee7sYcDVkymTwYO5FV6Rihk3J3loz0lKG3D58f_2ZnrbXM17rpgh7RXORSh421FXeLmXP1zImj1iRyb52RY-npi7pySr3H9y-XMqNsswPPhHgSm8VY-ti0mX4uMNhUfgbnb_ZzRwALDqllDYl9ZmurDjpD2g-Y2xV4V6GWlr4YUywd8SsT25dSeSsTgtmaxH6EypltxfaLVW0pZUWnkR89lohqrNhXFpHBdyTc0_EBPBSngO33RESYa3lK9eHUSGYYhN-0KpgWDrBoq8DBMQ2RbFqjehB8ZiUDDALDyggYLYqwaYYLw_bkTIr-s4uGTmW4kLZgPG5hE8teA2cC_BLhfD3o10-FOyTcqBc4k8g_kkSynJL91TDZP-MGxKjPKJ2yOSxjygDIsbz_spk5NQaDGLgh7OOsVEYm7R0ITDRBHYe3Kw8hHwTJgJLQ_X8op7qTlJ4eqWeGasc0rikgAYUQXjbZ1FJZD-9ffqBRKHsgXZZCwZ2Bx1VwonIC1BMSJ0KiSDz1ACqx-L2FG2cOTcxja0wGeE3wfdUMI1FIuHneWf6wnOWk3J5h2QE7o76qmUHgI2PtqMDKNp36w1KhpJFX3UaQcDM1q6j-sfT598jWeJdOl-Ao1J_5dJ0hT_UtZqAh1kWLRafM254zMNP1rBifT92uc07BkCHcE2eisbvVNvcMoQvvcBU_4AW9xn2kFgcMCChYOEtMo1UHsQZvpN4a4kkOwYlimCAerxtSdTakXSTExXvdOq_r52Fmw6gv9PBc-lRhUWgE20pgkCmRzcBY_aEtnlZhUsewp0X3hU1nRhMJ8ELKzoJ8h0q2sS3XccIlJd32CZnnozYtymlggoUl_u1MDThwN_v7qleSbqDKInPIH_wLZ0Q1SDbOhVPRq5Jhqc92WnQnzAv2clDAkt407pTuQLu4mA5rVnRfi6zrUlUTou6YSwZXiB7A1P9wJyad2Z-OFLH7styYloI5OcxuwvmJ9NYcywvQFc01tHvnsWBv3-8f3IGdXO2dPlc4PKyuxSRMN9vao_P6U6ltMZCHIkHUIKPZlcoc3WwU53ly2UTYCZ01Gvn0R7M7h2jmUyzTLUsyPa1mIrOFHXXiTqGZARcF_etyldGaVHCGGFdnwrMPQfyqS2Pjb5l5pOsX157LYtcKCWkRzXHpfc8iKxJfM-8DRnB7ddCLaLy8IjfD0PXR8hK9IfnT9-2WtmUdpjLlfT5XLFWApDNM_4dZjmuDTlP_wZjiJU7W6uBg0AxpB1WyO3ko8KCqpp7sx1BLIt9O5T2PMrityONPhAhX6pfCFR-B5H9xENl1gbZui7NqR6o6NLgdH_rZL_mIQsIS1U_01NUXs-rri-wW0LiTvjrjIsv0VEL6inFsVgSOg5xjev7e_iVhURqfXJPb7bVSWjFklo9X8mBXVeD9S-0233GKQ8aqyFGdly6BiFyryIr9Ulxu8cGnVrU-LrHvVjHpyuIlfbCW1tlHm4umdJwWkQtqbWxvA72zHbPuTfi8-w56KtUDTJqob7gNSdBEcg";
        Account account = new Account(user , password , false , recaptcha,null);
        loginResponse = ApiClient.login(account);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String userObject = ApiClient.serializeToJson(loginResponse.getData().getUser());
        String s ="{\"authuser\":{\"user\":" + userObject +"}}";
        jsExecutor.executeScript(String.format("window.localStorage.setItem('ramilevy','%s')",s));
        driver.navigate().refresh();
    }

    @Then("On Rami Levi Home page - '{}'")

    public void OnRamiLeviHomepageMurad(String firstName) throws InterruptedException {


        String currentText = homePage.getLoginComponent().getLoginUserText(firstName);

        Assert.assertEquals(loginResponse.getStatus() , 200);
        Assert.assertEquals(firstName, currentText);

    }





}


//{ "username": "aaaaa@gmail.com", "password": "muradelevation123", "restore_account": false, "recaptcha": "", "id_delivery_times": null }