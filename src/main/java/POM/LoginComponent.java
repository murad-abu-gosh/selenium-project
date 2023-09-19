package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginComponent extends BaseComponent{

    public LoginComponent(WebDriver driver) {
        super(driver);

    }

    public boolean waitUserName(WebDriver driver,String firstName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement visibleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text()," + firstName + ")]")));
        return visibleElement.isDisplayed();
    }

}
