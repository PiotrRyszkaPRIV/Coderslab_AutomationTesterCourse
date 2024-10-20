package com.course.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.course.selenium.helpers.ElementHelper.clickButton;
import static com.course.selenium.helpers.SeleniumHelper.waitForPageLoaded;

public class SearchResultsPage {

    private final WebDriver driver;
    @FindBy(css = "div.js-product:nth-child(1) > article:nth-child(1) > div:nth-child(1) > div:nth-child(2) > h2:nth-child(1) > a")
    WebElement hummingbirdPrintedSweater;


    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitForPageLoaded(driver, By.id("js-product-list-header"),"controller=search");
    }

    public void openSearchedItem(){
        clickButton(driver,hummingbirdPrintedSweater);
    }

}
