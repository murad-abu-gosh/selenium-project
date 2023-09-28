package steps;

import POM.RamiLeviHomePage;
import POM.ShippingAddressManagment;
import api.ApiClient;
import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logic.requests.Address;
import logic.requests.Profile;
import org.openqa.selenium.WebDriver;

public class UpdateProfile {
    private TestContext context;
    private RamiLeviHomePage homePage;
    private WebDriver driver;
    public UpdateProfile(TestContext context){
        this.context=context;
    }
//    @Given("I have navigated to Addresses managment")
//    public void iHaveNavigatedToAddressesManagment() {
//        driver = context.get("driver");
////        homePage= new RamiLeviHomePage(driver);
//        homePage = context.get("main");
//        homePage.getDashBoard().click_on_profile_icon();
//        homePage.getDashBoard().click_Shipping_managment_button();
//        driver.get("https://www.rami-levy.co.il/he/dashboard/addresses");
//
//
//    }
//
//    @When("I am now adding a new shipping address")
//    public void iAmNowAddingANewShippingAddress() {
//
////        Address address = new Address(
////                null,
////                1259,
////                91988,
////                "באר שבע",
////                "ביאליק",
////                "51",
////                "8434105",
////                "1",
////                null,
////                "3"
////        );
//
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
//        ApiClient.add_address(address);
//        driver.navigate().refresh();
//        ShippingAddressManagment addressManagment =new ShippingAddressManagment(driver);
//        addressManagment.print();
//        addressManagment.check_address_name_if_exists("");
//
//    }

//    @Then("On Shipping address managment")
//    public void onShippingAddressManagment() {
//
//    }

    @Given("I have navigated to profile dashboard")
    public void iHaveNavigatedToProfileDashboard() {
        driver = context.get("driver");
//        homePage= new RamiLeviHomePage(driver);
        homePage = context.get("main");
        homePage.getDashBoard().click_on_profile_icon();
        homePage.getDashBoard().click_profile_dashboard_button();
        driver.get("https://www.rami-levy.co.il/he/dashboard");
    }

    @When("I am updating the profile data {string} ,{string},{string},{string},{string},{string}")
    public void iAmUpdatingTheProfileData(String first_name, String last_name, String phone, String additional_phone, String sex_id, String birth_date) {
        Profile profile =new Profile( first_name, last_name, phone, additional_phone, sex_id, birth_date);
        ApiClient.update_profile(profile);
        driver.navigate().refresh();


    }

    @Then("On the profile dashboard")
    public void onTheProfileDashboard() {
    }
}