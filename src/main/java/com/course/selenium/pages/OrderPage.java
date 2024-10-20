package com.course.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.course.selenium.helpers.ElementHelper.clickButton;
import static com.course.selenium.helpers.SeleniumHelper.waitForPageLoaded;

public class OrderPage {

    private final WebDriver driver;
    @FindBy(css = "div.clearfix:nth-child(6) > button:nth-child(1)")
    WebElement continueToShippingButton;
    @FindBy(css = "div.delivery-option:nth-child(1)")
    WebElement selectPickUpInStore;
    @FindBy(css = "button.continue:nth-child(2)")
    WebElement continueToPaymentButton;


    public OrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitForPageLoaded(driver, By.id("checkout-personal-information-step"),"controller=order");
    }

    public void continueToShipping(){
        clickButton(driver,continueToShippingButton);
    }

    public void selectPickUpInStore(){
        clickButton(driver,selectPickUpInStore);
    }
    public void continueToPayment(){
        clickButton(driver,continueToPaymentButton);
    }

}
