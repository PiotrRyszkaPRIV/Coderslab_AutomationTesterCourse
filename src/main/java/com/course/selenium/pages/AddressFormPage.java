package com.course.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.course.selenium.helpers.ElementHelper.clickButton;
import static com.course.selenium.helpers.ElementHelper.fillInput;
import static com.course.selenium.helpers.SeleniumHelper.waitForPageLoaded;

public class AddressFormPage {

    @FindBy(id = "field-alias")
    private WebElement aliasInput;
    @FindBy(id = "field-firstname")
    private WebElement firstNameInput;
    @FindBy(id = "field-lastname")
    private WebElement lastNameInput;
    @FindBy(id = "field-address1")
    private WebElement addressLineInput;
    @FindBy(id = "field-city")
    private WebElement cityInput;
    @FindBy(id = "field-postcode")
    private WebElement zipPostalCodeInput;
//    @FindBy(id = "field-id_country")
//    private WebElement countryInput;
    @FindBy(id = "field-phone")
    private WebElement phoneNumberInput;
    @FindBy(css = ".form-footer .form-control-submit")
    private WebElement saveButton;

    private WebDriver driver;

    public AddressFormPage(WebDriver driver) {
        this.driver = driver;
        waitForPageLoaded(driver, By.id("field-alias"), "address");
        PageFactory.initElements(driver, this);
    }
    public void typeAlias(String alias) {
        fillInput(driver,aliasInput,alias);
    }
    public void typeAddressLine(String line) {
        fillInput(driver,addressLineInput,line);
    }
    public void typeCity(String city) {
        fillInput(driver,cityInput,city);
    }
    public void typePostalCode(String postalCode) {
        fillInput(driver,zipPostalCodeInput,postalCode);
    }
    public void typePhone(String phone) {
        fillInput(driver,phoneNumberInput,phone);
    }
    public void clickSaveButton() {
        clickButton(driver,saveButton);
    }
}
