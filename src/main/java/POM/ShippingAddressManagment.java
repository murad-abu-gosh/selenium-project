package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ShippingAddressManagment extends BasePage {
    WebElement My_address;
    String MY_ADDRESS = "//div[contains(text(), 'הכתובות שלי')]//..//../..//..//div[2]//div";
                         //div[contains(text(), 'הכתובות שלי')]//..//../..//..//div[2]//div //div//div//label//div
    public ShippingAddressManagment(WebDriver driver) {
        super(driver);
        init();
    }

    @Override
    public void init() {
    My_address = waitFunction(By.xpath(MY_ADDRESS));
    }

    public void print(){
        System.out.println(My_address.isDisplayed());
    }

    public void check_address_name_if_exists(String name){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.withTimeout(Duration.ofSeconds(20));
        List<WebElement> elementList= My_address.findElements(By.xpath("//div[contains(text(), 'הכתובות שלי')]//..//../..//..//div[2]//div //div//div//label//div"));
        for (WebElement i : elementList){
            List<WebElement> sub_element =  i.findElements(By.name("span"));
            for (WebElement j : sub_element){
                System.out.println(j.getText());
            }

        }




    }




}
