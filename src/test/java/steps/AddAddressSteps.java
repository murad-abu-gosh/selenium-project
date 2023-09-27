package steps;

import POM.RamiLeviHomePage;
import api.ApiClient;
import context.TestContext;
import infra.WrappHttpResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logic.requests.Account;
import logic.requests.Address;
import logic.response.LoginResponse;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class AddAddressSteps {
    private TestContext context;
    private RamiLeviHomePage homePage;
    private WebDriver driver;
    public AddAddressSteps(TestContext context){
        this.context=context;
    }
    @Given("I have navigated to Addresses managment")
    public void iHaveNavigatedToAddressesManagment() {
        driver = context.get("driver");
//        homePage= new RamiLeviHomePage(driver);
        homePage = context.get("main");
        homePage.getDashBoard().click_on_profile_icon();
        homePage.getDashBoard().click_Shipping_managment_button();
        driver.get("https://www.rami-levy.co.il/he/dashboard/addresses");


    }

    @When("I am now adding a new shipping address")
    public void iAmNowAddingANewShippingAddress() {

        Address address = new Address(
                null,
                1259,
                91988,
                " באר שבע ",
                " ביאליק ",
                "51",
                "8434105",
                "1",
                null,
                "3"
        );
//        Address address = new Address(
//                null,
//                1259,
//                91988,
//                "Beer shva",
//                "Bialek",
//                "51",
//                "8434105",
//                "1",
//                null,
//                "3"
//        );
        ApiClient.add_address(address);
        driver.navigate().refresh();

    }

    @Then("On Shipping address managment")
    public void onShippingAddressManagment() {
    }
}
