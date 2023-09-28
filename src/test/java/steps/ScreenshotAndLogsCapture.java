package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class ScreenshotAndLogsCapture {
    private WebDriver driver;

    // Constructor to initialize the WebDriver (you can set it up based on your actual setup)
    public ScreenshotAndLogsCapture(WebDriver driver) {
        this.driver = driver;
    }

    @AfterMethod
    public void takeScreenshotAndLogs(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        if (result.getStatus() == ITestResult.FAILURE) {
            // Capture a screenshot on test failure
            captureScreenshot(testName);
        }

        // Print browser logs
        printBrowserLogs();
    }

    private void captureScreenshot(String testName) {
        try {
            // Capture the screenshot
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotFileName = "screenshots/" + testName + "_" + new Date().getTime() + ".png";
            File destination = new File(screenshotFileName);
            org.apache.commons.io.FileUtils.copyFile(screenshot, destination);
            System.out.println("Screenshot saved to: " + screenshotFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printBrowserLogs() {
        LogEntries logs = driver.manage().logs().get("browser");
        for (LogEntry logEntry : logs) {
            System.out.println(logEntry.getMessage());
        }
    }
}
