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

        context.put("first_name",first_name);
        context.put("last_name",last_name);
        context.put("phone",phone);
        context.put("additional_phone",additional_phone);
        context.put("sex_id",sex_id);
        context.put("birth_date",birth_date);


    }

    @Then("On the profile dashboard")
    public void onTheProfileDashboard() {
        Profile_Dashboard dashboard =new Profile_Dashboard(driver);
        dashboard.print();
        //response code validation
        Assert.assertEquals(response.getStatus(),200);
//        System.out.println(context.get("first_name"));
//        System.out.println(context.get("last_name").toString());
//        System.out.println(context.get("phone").toString());
//        System.out.println(context.get("additional_phone").toString());
//        System.out.println(context.get("sex_id").toString());
//        System.out.println(context.get("birth_date").toString());


        //data validation
        Assert.assertEquals(context.get("first_name"),dashboard.getFirstName());
        Assert.assertEquals(context.get("last_name"),dashboard.getLastName());
        Assert.assertEquals(context.get("phone"),dashboard.getPhone());
        Assert.assertEquals(context.get("additional_phone"),dashboard.getAdditionalPhone());
        Assert.assertEquals(context.get("sex_id"),dashboard.selected_gender());
        Assert.assertEquals(context.get("birth_date"),dashboard.getBirthDate());
        // Required data
        Assert.assertNotNull(dashboard.getFirstName());
        Assert.assertNotNull(dashboard.getLastName());
        Assert.assertNotNull(dashboard.getPhone());

    }
}
