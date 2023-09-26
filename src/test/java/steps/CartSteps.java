package steps;

import POM.CartComponent;
import POM.SearchBarComponent;
import POM.SearchPage;
import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class CartSteps {
    private TestContext context;

    private CartComponent cartComponent;

    private SearchPage searchPage;
    private WebDriver driver;
    public CartSteps(TestContext context) {
        this.context = context;
        this.driver =context.get("driver");
        CartComponent cart = new CartComponent(driver);
        SearchPage newSearchPage = new SearchPage(driver);
        context.put("cart", cart);
        context.put("searchPage",newSearchPage);
        cartComponent = context.get("cart");
        searchPage = context.get("searchPage");
    }



    @When("I empty the cart")
    public void iEmptyTheCart(){
        driver.navigate().refresh();
        cartComponent.executeEmptyCartSequence();
        Assume.assumeTrue("Cart is empty", cartComponent.isCartEmpty());
    }

    @When("I click on plus button {int} times for item index {int}")
    public void iClickPlusForItemIndex(int addCount, int itemIndex){
        searchPage.addItemToCartXTimes(itemIndex, addCount);
    }



    @Then("I have {int} items in cart")
    public void iHaveItemsInCart(int itemsCount){
        Assertions.assertEquals(itemsCount, cartComponent.getCartItemsCount());
    }

    @Then("Cart is empty")
    public void cartIsEmpty() {
        Assertions.assertTrue(cartComponent.isCartEmpty());
    }
}
