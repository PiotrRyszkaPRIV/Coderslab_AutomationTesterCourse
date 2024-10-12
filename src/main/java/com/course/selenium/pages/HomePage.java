package com.course.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.course.selenium.helpers.ElementHelper.clickButton;
import static com.course.selenium.helpers.ElementHelper.fillInput;
import static com.course.selenium.helpers.SeleniumHelper.waitForPageLoaded;

public class HomePage {

    private final WebDriver driver;
    @FindBy(css = ".user-info > a:nth-child(1) > span:nth-child(2)")
    WebElement singInLink;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitForPageLoaded(driver, By.cssSelector(".user-info > a:nth-child(1) > span:nth-child(2)"),"mystore-testlab.coderslab.pl");
    }

    public void clickSignInLink(){
        clickButton(driver,singInLink);
    }

}
