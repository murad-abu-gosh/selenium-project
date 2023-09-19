package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseComponent {

    private WebDriver driver;
    public BaseComponent(WebDriver driver) {
        this.driver = driver;

    }


    public void setInputValue(String value , By locator) {
        WebElement Input = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(locator));
        Input.sendKeys(value);
    }

    public void setDropDown(String value , By locator) {

    if(value != null) {
        WebElement keywords_options = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(locator));
        Select select1 = new Select(keywords_options);
        select1.selectByValue(value);
    }

    }

    public void clickButton(By locator){
        WebElement button = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(locator));
        button.click();
    }
    public WebElement waitFunction(By ele) {
        return new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(ele));

    }

}

