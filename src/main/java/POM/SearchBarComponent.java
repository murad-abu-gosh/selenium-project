package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchBarComponent extends BaseComponent {

    private final By searchInput = By.id("destination");
    private final By showAllResultsButton = By.xpath("//*[@id=\"search\"]/div[2]/div/div[1]/div/div[2]/div/div/div[2]/div[2]/button");
    private final By testXpath = By.xpath("//button[(contains(@class,\"focus-item\")) and (contains(@class,\"online-full-btn\"))]");
    public SearchBarComponent(WebDriver driver) {
        super(driver);
    }

    @Override
    public void init() {

    }


    public void clickShowAllResultsButton(){
        clickButton(testXpath);
    }

    public void fillSearchBar(String input){
        setInputValue(input, searchInput);
    }

    public void executeFullSearchSequence(String input){
        fillSearchBar(input);
        clickShowAllResultsButton();
        waitPageLoad();

    }

    public void waitPageLoad(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.id("min-height-product-0")));
    }


}
