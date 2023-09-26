package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashBoard extends  BaseComponent{
    private String SHIPPING_MANAGMENT ="//*[@id=\"dashboard-addresses\"]";

    private final By SAVE_PASSWORD = By.xpath("//*[@id=\"changePass___BV_modal_body_\"]/div[3]/div[2]/button[2]");
    private final By RESET_PASSWORD = By.xpath("//*[@id=\"main-content\"]/div/div[2]/div/div/div[1]/div/div[2]/div[1]/div[1]/div[5]/div/button");
    private final By OLD_PASSWORD_INPUT = By.xpath("//*[@id=\"old-pass\"]");
    private final By PASSWORD_INPUT = By.xpath("//*[@id=\"new-pass\"]");
    private final By PASSWORD_INPUT_CON = By.xpath("//*[@id=\"new-pass-con\"]");


    private final By LOG_OUT = By.xpath("//div[contains(text(),'התנתק/י')]");

    private WebElement Shipping_managment_button;
    private String  PROFILE_ICON_BUTTON ="login-user";
    private WebElement profile_icon_button;
    public DashBoard(WebDriver driver) {
        super(driver);
//        init();
    }

    @Override
    public void init() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        profile_icon_button = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-user"))) ;

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
    public void click_on_reset_password(){
    clickButton(RESET_PASSWORD);
    }
    public void write_on_password_input(String password){
        setInputValue(password , PASSWORD_INPUT);

    }
    public void write_on_confirm_password_input(String password){
        setInputValue(password , PASSWORD_INPUT_CON);

    }
    public void write_on_old_password_input(String password){
        setInputValue(password , OLD_PASSWORD_INPUT);

    }
    public void click_on_save_password(){
        clickButton(SAVE_PASSWORD);
        // Locate the popup element
        WebElement popup = driver.findElement(By.id("changePass___BV_modal_body_")); // Replace with the actual locator

        // Create a WebDriverWait instance with a timeout (e.g., 10 seconds)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for the popup to become invisible or not present
        wait.until(ExpectedConditions.invisibilityOf(popup));

    }
    public void click_on_log_out(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(LOG_OUT));
        usernameElement.click();


    }

}
