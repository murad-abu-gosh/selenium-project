package steps;

import POM.Profile_Dashboard;
import POM.RamiLeviHomePage;
import api.ApiClient;
import context.TestContext;
import infra.WrappHttpResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logic.requests.Profile;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class UpdateProfile {
    private TestContext context;
    private RamiLeviHomePage homePage;
    private WrappHttpResponse<Profile> response;
    private WebDriver driver;
    public UpdateProfile(TestContext context){
        this.context=context;
    }


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
        if (first_name.equals("null") ) first_name = null;
        if (last_name.equals("null") ) {last_name =null;}
        if (phone.equals("null") ) {phone =null;}
        if (additional_phone.equals("null") ) {additional_phone =null;}
        if (sex_id.equals("null") ) {sex_id =null;}
        if (birth_date.equals("null") ) {birth_date =null;}

        Profile profile =new Profile( first_name, last_name, phone, additional_phone, sex_id, birth_date);
        response= ApiClient.update_profile(profile);
        driver.navigate().refresh();


    }


    @Then("On the profile dashboard page check the entered data if available {string} ,{string},{string},{string},{string},{string}")
    public void onTheProfileDashboardPageCheckTheEnteredData(String first_name, String last_name, String phone, String additional_phone, String sex_id, String birth_date) {
        if (first_name.equals("null") ) first_name = null;
        if (last_name.equals("null") ) last_name =null;
        if (phone.equals("null") ) phone =null;
        if (additional_phone.equals("null") ) additional_phone =null;
        if (sex_id.equals("null") ) sex_id =null;
        if (birth_date.equals("null") ) birth_date =null;

        Profile_Dashboard dashboard =new Profile_Dashboard(driver);
        dashboard.print();
        //response code validation
        Assert.assertEquals(response.getStatus(),200);

        // Required data
        Assert.assertNotNull(dashboard.getFirstName());
        Assert.assertNotNull(dashboard.getLastName());
        Assert.assertNotNull(dashboard.getPhone());

        //data validation
        Assert.assertEquals(first_name,dashboard.getFirstName());
        Assert.assertEquals(last_name,dashboard.getLastName());
        Assert.assertEquals(phone,dashboard.getPhone());
        Assert.assertEquals(additional_phone,dashboard.getAdditionalPhone());
        Assert.assertEquals(sex_id,dashboard.selected_gender());
        Assert.assertEquals(birth_date,dashboard.getBirthDate());

    }




}
