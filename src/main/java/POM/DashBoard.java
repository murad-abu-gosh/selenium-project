package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashBoard extends  BaseComponent{
    private String SHIPPING_MANAGMENT ="//*[@id=\"dashboard-addresses\"]";
    private WebElement Shipping_managment_button;
    private String  PROFILE_ICON_BUTTON ="login-user";
    private WebElement profile_icon_button;
    private WebElement profile_dashboard;
    private String PROFILE_DASHBOARD="dashboard";
    //*[@id="dashboard"]
    public DashBoard(WebDriver driver) {
        super(driver);
//        init();
    }

    @Override
    public void init() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        profile_icon_button = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-user"))) ;

    }
    public void click_profile_dashboard_button(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        profile_dashboard = wait.until(ExpectedConditions.elementToBeClickable(By.id(PROFILE_DASHBOARD))) ;
        profile_dashboard.click();
    }

    public void click_Shipping_managment_button(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Shipping_managment_button = wait.until(ExpectedConditions.elementToBeClickable(By.id("dashboard-addresses"))) ;
        Shipping_managment_button.click();
    }
    public void click_on_profile_icon(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        profile_icon_button = wait.until(ExpectedConditions.elementToBeClickable(By.id(PROFILE_ICON_BUTTON))) ;
        profile_icon_button.click();

    }

}
