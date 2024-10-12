package com.course.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.course.selenium.helpers.ElementHelper.clickButton;
import static com.course.selenium.helpers.SeleniumHelper.waitForPageLoaded;

public class MyAccountPage {


    @FindBy(css = "#address-link > span:nth-child(1) > i:nth-child(1)")
    private WebElement addFirstAddressLink;
    @FindBy(css = "#addresses-link > span:nth-child(1) > i:nth-child(1)")
    private WebElement addresses;


    private final WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        waitForPageLoaded(driver, By.id("identity-link"), "my-account");
        PageFactory.initElements(driver, this);
    }

    public void addFirstAddress() {
        clickButton(driver, addFirstAddressLink);
    }

    public void addresses() {
        clickButton(driver, addresses);
    }


}

