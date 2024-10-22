package com.course.selenium.stepdefinitions;

import com.course.selenium.hooks.Hooks;
import com.course.selenium.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class AddAddressSteps {

    private final WebDriver driver = Hooks.getDriver();

    private HomePage homePage;
    private LoginPage loginPage;
    private MyAccountPage myAccountPage;
    private MyAddressesPage myAddressesPage;
    private AddressFormPage addressFormPage;

    private String addressAlias;

    @Given("the user is on the HomePage")
    public void theUserIsOnTheHomePage() {
        driver.get("https://mystore-testlab.coderslab.pl/");
        homePage = new HomePage(driver);
    }

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        homePage.clickSignInLink();
        loginPage = new LoginPage(driver);
    }

    @When("the user types an email and password into login input field")
    public void theUserTypesAnEmailAndPasswordIntoLoginInputField() {
        loginPage.typeEmailIntoLogin("zaliczenie1@test.com");
        loginPage.typePasswordIntoLogin("Haslo1234?");
    }

    @And("the user clicks on Sign In button")
    public void theUserClicksOnSignInButton() {
        loginPage.clickSingInButton();
    }

    @Given("the user is on My Account page")
    public void theUserIsOnMyAccountPage() {
        myAccountPage = new MyAccountPage(driver);
    }

    @When("the user clicks on Addresses button")
    public void theUserClicksOnAddressesButton() {
        myAccountPage.addresses();
    }

    @Given("the user is on My Addresses page")
    public void theUserIsOnMyAddressesPage() {
        myAddressesPage = new MyAddressesPage(driver);
    }

    @When("the user clicks on Create New Address button")
    public void theUserClicksOnCreateNewAddressButton() {
        myAddressesPage.createNewAddress();
    }

//    @And("the user clicks on Add First Address button")
//    public void theUserClicksOnAddFirstAddressButton() {
//        myAccountPage.addFirstAddress();
//    }

    @And("the user fills the address form with {string}, {string}, {string}, {string}")
    public void theUserFillsTheAddressFormWith(String address, String city, String zipCode, String phone) {
        addressAlias = "Alias" + System.currentTimeMillis();
        addressFormPage = new AddressFormPage(driver);

        addressFormPage.typeAlias(addressAlias);
        addressFormPage.typeAddressLine(address);
        addressFormPage.typeCity(city);
        addressFormPage.typePostalCode(zipCode);
        addressFormPage.typePhone(phone);
    }

    @And("the user click the Save button")
    public void theUserClickTheSaveButton() {
        addressFormPage.clickSaveButton();
    }

    @Then("the user should be on My Addresses page and the My Addresses Page should display confirmation message {string}")
    public void theUserShouldBeOnMyAddressesPageAndTheMyAddressesPageShouldDisplayConfirmationMessage(String arg0) {
        Assert.assertEquals(arg0, myAddressesPage.getSuccessMessage());
    }

    @And("My addresses page should include the New Address")
    public void myAddressesPageShouldIncludeTheNewAddress() {
        myAddressesPage = new MyAddressesPage(driver);

        Map<String, String> addressesByAlias = myAddressesPage.getAddressesByAlias(addressAlias);
        String key = addressAlias.toUpperCase();
        assertTrue(addressesByAlias.containsKey(key));

        assertEquals("Zadanie ZaliczenioweJeden\n" +
                "Kasztanowa 6\n" +
                "Krakow\n" +
                "30-011\n" +
                "United Kingdom\n" +
                "666777888", addressesByAlias.get(key));
    }
}