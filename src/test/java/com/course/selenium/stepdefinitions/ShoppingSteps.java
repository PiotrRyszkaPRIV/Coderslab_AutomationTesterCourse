package com.course.selenium.stepdefinitions;

import com.course.selenium.hooks.Hooks;
import com.course.selenium.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class ShoppingSteps {

    private final WebDriver driver = Hooks.getDriver();

    private HomePage homePage;
    private LoginPage loginPage;
    private MyAccountPage myAccountPage;
    private MyAddressesPage myAddressesPage;
    private AddressFormPage addressFormPage;
    private SearchResultsPage searchResultsPage;
    private HummingbirdPrintedSweaterPage hummingbirdPrintedSweaterPage;
    private ShoppingCartPage shoppingCartPage;
    private OrderPage orderPage;

    private String addressAlias;

    @When("the user types item name into search bar")
    public void theUserTypesItemNameIntoSearchBar() {
        myAccountPage = new MyAccountPage(driver);
        myAccountPage.typeItemToSearch("Hummingbird Printed Sweater");
    }

    @And("the user search for this item")
    public void theUserSearchForThisItem() {
        myAccountPage.searchItem();
    }

    @And("the user clicks on searched item")
    public void theUserClicksOnSearchedItem() {
        searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.openSearchedItem();
    }

    @And("the user is on the product page and the Product Page should display confirmation message {string}")
    public void theUserIsOnTheProductPageAndTheProductPageShouldDisplayConfirmationMessage(String arg0) {
        hummingbirdPrintedSweaterPage = new HummingbirdPrintedSweaterPage(driver);
        Assert.assertEquals(arg0, hummingbirdPrintedSweaterPage.getSuccessMessage());
    }

    @Then("the user select M size")
    public void theUserSelectMSize() {
        hummingbirdPrintedSweaterPage.selectProductSize();
    }

    @And("the user add required number of product to the cart")
    public void theUserAddRequiredNumberOfProductToTheCart() {
        hummingbirdPrintedSweaterPage.add4pcs();
        hummingbirdPrintedSweaterPage.clickAddToCartButton();
    }

    @And("the user clicks on proceed to checkout")
    public void theUserClicksOnProceedToCheckout() {
        hummingbirdPrintedSweaterPage.proceedToCheckout();
    }

    @Then("the user is in shopping cart page")
    public void theUserIsInShoppingCartPage() {
        shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.proceedToCheckout();
    }

    @And("the user confirm address by clicking on continue button")
    public void theUserConfirmAddressByClickingOnContinueButton() {
        orderPage = new OrderPage(driver);
        orderPage.continueToShipping();
    }

    @And("the user confirm shipping method and clicking continue button")
    public void theUserConfirmShippingMethodAndClickingContinueButton() {
        orderPage.selectPickUpInStore();
        orderPage.continueToPayment();
    }
}