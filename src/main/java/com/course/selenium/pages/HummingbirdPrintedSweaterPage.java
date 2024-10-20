package com.course.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.course.selenium.helpers.ElementHelper.clickButton;
import static com.course.selenium.helpers.ElementHelper.fillInput;
import static com.course.selenium.helpers.SeleniumHelper.waitForElementVisible;
import static com.course.selenium.helpers.SeleniumHelper.waitForPageLoaded;

public class HummingbirdPrintedSweaterPage {

    private final WebDriver driver;

    @FindBy(css = "span.discount")
    private WebElement discount;
    @FindBy(id = "group_1")
    private WebElement dropdownSize;
    @FindBy(xpath = "//*[@id='group_1']/option[2]")
    private WebElement optionM;
    @FindBy(id = "quantity_wanted")
    private WebElement quantity;
    @FindBy(css = "button.btn-primary:nth-child(1)")
    private WebElement addToCart;
    @FindBy(css = ".touchspin-up")
    private WebElement add1pc;
    @FindBy(css = ".cart-content-btn > a:nth-child(2)")
    private WebElement proceedToCheckout;


    public HummingbirdPrintedSweaterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitForPageLoaded(driver, By.cssSelector(".h1"), "rewrite=brown-bear-printed-sweater");
    }

    public String getSuccessMessage() {
        WebElement alert = waitForElementVisible(driver, discount, 10);
        return alert.getText().strip();
    }

    public void selectProductSize() {
        dropdownSize.click();
        optionM.click();
    }

    public void add4pcs() {
        clickButton(driver, add1pc);
        clickButton(driver, add1pc);
        clickButton(driver, add1pc);
        clickButton(driver, add1pc);
    }

    public void clickAddToCartButton() {
        clickButton(driver, addToCart);
    }

    public void proceedToCheckout(){
        clickButton(driver, proceedToCheckout);
    }
}
