package steps;

import POM.RamiLeviHomePage;
import POM.SearchBarComponent;
import context.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class SearchSteps {
    private TestContext context;

    private SearchBarComponent searchBarComponent;
    private WebDriver driver;
    public SearchSteps(TestContext context) {
        this.context = context;
        this.driver =context.get("driver");

    }
    @When("I type {string} in search bar")
    public void iClickOnSearchBar(String searchInput){
        SearchBarComponent newSearchBarComponent = new SearchBarComponent(driver);
        newSearchBarComponent.fillSearchBar(searchInput);
        context.put("searchBar",newSearchBarComponent);
        searchBarComponent = context.get("searchBar");

    }

    @When("I click on show all results button")
    public void iClickOnShowAllResultsButton(){
        searchBarComponent.clickShowAllResultsButton();
        searchBarComponent.waitPageLoad();
        driver.navigate().refresh();
    }

    @Then("I am on advanced search page for {string}")
    public void iAmOnAdvancedSearchPageForInput(String searchInput) {
        Assertions.assertEquals("https://www.rami-levy.co.il/he/online/search?q=" + searchInput, driver.getCurrentUrl());
    }
}
