package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RamiLeviHomePage extends BasePage {
    private LoginComponent loginComponent;
    private DashBoard dashBoard;
//    private String  PROFILE_ICON_BUTTON ="//div[@id=\"login-user\"]";
//    private WebElement profile_icon_button;

    public RamiLeviHomePage(WebDriver driver){
        super(driver);
        init();
    }


    public void init() {

        this.loginComponent = new LoginComponent(this.driver);
        this.dashBoard = new DashBoard(this.driver);
//        this.profile_icon_button = waitFunction(By.id("login-user"));
//        this.profile_icon_button = driver.findElement(By.id("login-user"));
    }
    public DashBoard getDashBoard() {
        return dashBoard;
    }

    public LoginComponent getLoginComponent() {
        return loginComponent;
    }

    public void setLoginComponent(LoginComponent loginComponent) {
        this.loginComponent = loginComponent;
    }
    public void openStatsPage() {
        driver.get("https://www.rami-levy.co.il/he");
    }

//    public void click_on_profile_icon(){
//    profile_icon_button.click();
//
//    }

}