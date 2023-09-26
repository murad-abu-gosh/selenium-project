package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginComponent extends BaseComponent{
    private final By PROFILE_ICON = By.xpath("//*[@id=\"login-user\"]/div/div");
    private final By DASHBOARD = By.xpath(" //*[@id=\"dashboard\"]");

    //*[@id="__layout"]/div/div[1]/div[2]/div[3]/div[2]/div/div/div[4]/div[2]
    //*[@id=\"login-user\"]/div/div/div[2]/div/span"

    public LoginComponent(WebDriver driver) {
        super(driver);

    }

    @Override
    public void init() {

    }

    public String getLoginUserText(String firstName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        // Use the wait to wait until the username element is visible
        WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),\""+firstName+"\")]")));
        System.out.println("visibleElement.isDisplayed()" + usernameElement.isDisplayed());
        System.out.println("usernameElement.getText()" + usernameElement.getText());
        return usernameElement.getText();
    }

    public void clickOnProfile() {
        clickButton(PROFILE_ICON);
    }
    public void clickOnDashboard() {
        clickButton(DASHBOARD);
    }


}