package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchBarComponent extends BaseComponent {

    private final By searchInput = By.id("destination");
    private final By showAllResultsButton = By.xpath("//*[@id=\"search\"]/div[2]/div/div[1]/div/div[2]/div/div/div[2]/div[2]/button[2]");

    public SearchBarComponent(WebDriver driver) {
        super(driver);
    }


    public void clickShowAllResultsButton(){
        clickButton(showAllResultsButton);
    }

    public void fillSearchBar(String input){
        setInputValue(input, searchInput);
    }

    public void executeFullSearchSequence(String input){
        fillSearchBar(input);
        clickShowAllResultsButton();
    }




}
