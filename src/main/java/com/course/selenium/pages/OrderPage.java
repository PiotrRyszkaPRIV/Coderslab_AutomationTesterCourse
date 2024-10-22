package com.course.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.course.selenium.helpers.ElementHelper.clickButton;
import static com.course.selenium.helpers.ElementHelper.selectCheckbox;
import static com.course.selenium.helpers.SeleniumHelper.waitForPageLoaded;

public class OrderPage {

    private final WebDriver driver;
    @FindBy(css = "div.clearfix:nth-child(6) > button:nth-child(1)")
    WebElement continueToShippingButton;
    @FindBy(css = "div.delivery-option:nth-child(1)")
    WebElement selectPickUpInStore;
    @FindBy(css = "button.continue:nth-child(2)")
    WebElement continueToPaymentButton;
    @FindBy(css = "#payment-option-1-container > span:nth-child(1)")
    WebElement selectPayByCheck;
    @FindBy(css = ".custom-checkbox > span:nth-child(2)")
    WebElement confirmTermsOfService;
    @FindBy(css = "div.ps-shown-by-js > button:nth-child(1)")
    WebElement placeTheOrderButton;


    public OrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitForPageLoaded(driver, By.id("checkout-personal-information-step"), "controller=order");
    }

    public void continueToShipping() {
        clickButton(driver, continueToShippingButton);
    }

    public void selectPickUpInStore() {
        clickButton(driver, selectPickUpInStore);
    }

    public void continueToPayment() {
        clickButton(driver, continueToPaymentButton);
    }

    public void payByCheck() {
        clickButton(driver, selectPayByCheck);
    }

    public void confirmTermsOfService() {
        selectCheckbox(driver, confirmTermsOfService);
    }

    public void placeTheOrder() {
        clickButton(driver, placeTheOrderButton);
    }

}
