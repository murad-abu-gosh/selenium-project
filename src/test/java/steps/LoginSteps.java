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
import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import context.TestContext;

import java.io.BufferedReader;
import java.io.DataOutputStream;

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
    public void OnRamiLeviHomepageMurad(String firstName) {
        RamiLeviHomePage ramiLeviHomePage = new RamiLeviHomePage(driver);
        boolean currentText = ramiLeviHomePage.getLoginComponent().getLoginUserText(firstName);
        Assert.assertTrue(currentText);
    }




//    @Test
//    public void checkIfUserLogin() throws IOException {
//        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//        JSONObject loginResponse = null;
//        driver = new ChromeDriver();
//        RamiLeviHomePage ramiLeviHomePage = new RamiLeviHomePage(driver);
//          driver.get(URL);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        String jsonBodyLogin = "{\"username\": \"tzahi@tzahi.com\",\"password\": \"Aa123123\",\"restore_account\": false,\"id_delivery_times\": null}";
//        loginResponse = post("https://api-prod.rami-levy.co.il/api/v2/site/auth/login", jsonBodyLogin);
//        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//        String s ="{\"authuser\":{\"user\":" + loginResponse.get("user").toString() +"}}";
//        System.out.println("s"+ s);
//        jsExecutor.executeScript(String.format("window.localStorage.setItem('ramilevy','%s')",s));
//        driver.navigate().refresh();
//        WebElement visibleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),\"Tzahi\")]")));
//        boolean elementIsExcite = visibleElement.isDisplayed();
//        Assert.assertTrue(elementIsExcite);
//
//        driver.close();
//    }
//
//    public static JSONObject post(String url, String body) throws IOException {
//        java.net.URL urlObj = new URL(url);
//        HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
//        connection.setRequestMethod("POST");
//        connection.setRequestProperty("Content-Type", "application/json");
//        connection.setDoOutput(true);
//        connection.setDoInput(true);
//        try (DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream())) {
//            outputStream.writeBytes(body);
//            outputStream.flush();
//        }
//        connection.getResponseCode();
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
//            StringBuilder response = new StringBuilder();
//            String line;
//            while ((line = reader.readLine()) != null) {
//                response.append(line);
//            }
//            return new JSONObject(response.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            connection.disconnect();
//        }
//        return null;
//    }

//{"authuser":{"user":{"subscribe_at":"2023-07-23 15:40:41","addresses":[],"cards":[],"birth_date":null,"additional_phone":null,
// "deactivated_at":null,"edit_order":null,"locale":null,"area_id":null,"identity_card":"021911904","club_accept_at":"2023-07-23 15:40:41",
// "club_accept":1,"sex_id":null,"features":[],"coupons":{"birthday":"1986-06-15","default_print":{"action":"ask","type":"phone","value":"0528635700"},
// "wallet":null,"channels":[{"name":"חברתי","id":1}],"coupons":[],"last_name":"אנידגאר","id":878331,"identity_number":"021911904","first_name":"צחי"},
// "id":867656,"first_name":"Tzahi","email":"tzahi@tzahi.com","store_id":null,"send_club_database":0,"accounting_card_id":null,"business":0,"popularProducts":"",
// "disabled_at":null,"last_name":"Anidgar","send_email":1,"deleted_at":null,"token":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczpcL1wvYXBpLXByb2QucmFtaS1sZXZ5LmNvLmlsIiwiYXVkIjoiaHR0cHM6XC9cL2FwaS1wcm9kLnJhbWktbGV2eS5jby5pbCIsImlhdCI6MTY5NTMwODEwMCwibmJmIjoxNjk1MzA4MTYwLCJleHAiOjE2OTUzOTQ1MDAsImlkIjo4Njc2NTYsImVtYWlsIjoidHphaGlAdHphaGkuY29tIiwiY2lkIjoiOTkwMDE1MjU4NzkifQ.XVsBeUAN6pe143qtRoNZFidI9kpgOKFlBMyg3CECGkw","customer_id_club":878331,"activated_at":null,"user_id":"99001525879","phone":null,"meta":null,"subscribe_ip":"172.69.128.131","name":"Tzahi Anidgar","orders":[],"club_accept_ip":"172.69.128.131","send_sms":1}}}




}