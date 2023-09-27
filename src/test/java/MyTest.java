import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;


public class MyTest {

    private static WebDriver driver;

    @BeforeEach
    public void setUp() throws IOException {
        System.setProperty("webdriver.chrome.driver", "/Users/user/IdeaProjects/testing-with-selenium/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.rami-levy.co.il/he");


    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

//    @Test
    // this Test check if rest function     
//    public void test_create_resturant() throws IOException {
//        //Arrange
//        Account account = new Account("aaaaa@gmail.com" , "muradelevation123" , false , null);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        WrappHttpResponse<JSONObject> loginResponse = ApiClient.login(account);
//        System.out.println("user=====>" + loginResponse.getData().get("user").toString());
//
//        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//        // Get the "user" JSONObject
//        JSONObject userObject = new JSONObject (loginResponse.getData().get("user").toString());
//
//        // Get the "first_name" value from the "user" JSONObject
//        String firstName = userObject.getString("first_name");
//        String s ="{\"authuser\":{\"user\":" +  userObject.toString() +"}}";
//        jsExecutor.executeScript(String.format("window.localStorage.setItem('ramilevy','%s')",s));
//        driver.navigate().refresh();
//        WebElement visibleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),"+userObject.get("first_name").toString()+ ")]")));
//        boolean elementIsExcite = visibleElement.isDisplayed();
//        Assert.assertTrue(elementIsExcite);
//
//        driver.navigate().refresh();
//JAVA_TOOL_OPTIONS = -Dfile.encoding=UTF8JAVA_TOOL_OPTIONS = -Dfile.encoding=UTF8
//    }






}