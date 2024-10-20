package com.course.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.course.selenium.helpers.ElementHelper.clickButton;
import static com.course.selenium.helpers.SeleniumHelper.waitForPageLoaded;

public class ShoppingCartPage {

    private final WebDriver driver;
    @FindBy(css = "a.btn:nth-child(1)")
    WebElement proceedToCheckoutButton;


    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitForPageLoaded(driver, By.cssSelector("a.btn:nth-child(1)"),"controller=cart");
    }

    public void proceedToCheckout(){
        clickButton(driver,proceedToCheckoutButton);
    }

}
