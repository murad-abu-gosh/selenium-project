package steps;

import POM.RamiLeviHomePage;
import api.ApiClient;
import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logic.requests.Address;
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
        Address address = new Address(null, 157, "יקנעם עילית", "בס", "21", "", "2", null, "5");
        ApiClient.add_address(address);


    }

    @Then("On Shipping address managment")
    public void onShippingAddressManagment() {
    }
}
