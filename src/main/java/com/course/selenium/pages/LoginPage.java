package com.course.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.course.selenium.helpers.ElementHelper.fillInput;
import static com.course.selenium.helpers.SeleniumHelper.*;

public class LoginPage {

    private final WebDriver driver;

    @FindBy(id = "field-email")
    private WebElement emailInputField;

    @FindBy(id = "field-password")
    private WebElement passwordInputField;

    @FindBy(id = "submit-login")
    private WebElement signInButton;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        waitForPageLoaded(driver, By.id("field-email") ,"controller=authentication");
        PageFactory.initElements(driver, this);
    }
    public void typeEmailIntoLogin(String mail) {
        fillInput(driver,emailInputField,mail);
    }
    public void typePasswordIntoLogin(String password) {
        fillInput(driver,passwordInputField,password);
    }

    public void clickSingInButton() {
        signInButton.click();
    }

}
