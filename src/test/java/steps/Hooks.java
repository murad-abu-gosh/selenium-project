package steps;

import context.TestContext;
import infra.HttpFacade;
import infra.WrappHttpResponse;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import java.io.File;
import java.io.IOException;

public class Hooks {
    private WebDriver driver;
    private TestContext context;
    private Scenario scenario;

    public Hooks(TestContext context){
        this.context=context;
    }
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        context.put("driver",this.driver);
    }
@AfterTest
public void AfterMethod(ITestResult ITestResult){
    ScreenshotAndLogsCapture capture = new ScreenshotAndLogsCapture(driver);
    capture.takeScreenshotAndLogs(ITestResult);
}

    @After
    public void tearDown(Scenario scenario) {
        this.scenario = scenario;
        if (driver != null) {
            if (scenario.isFailed()) {
                captureScreenshot(scenario.getName());
            }
            driver.quit();
        }
    }

    private void captureScreenshot(String screenshotName) {
        try {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", screenshotName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {

        if (driver != null) {
//            driver.quit();
        }

    }

    public WebDriver getDriver() {
        return driver;
    }
}