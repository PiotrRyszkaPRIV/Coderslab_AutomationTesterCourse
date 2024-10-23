package com.course.selenium.pages;

import com.course.selenium.helpers.ScreenshotHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static com.course.selenium.helpers.SeleniumHelper.waitForPageLoaded;

public class OrderConfirmationPage {

    private final WebDriver driver;
    private ScreenshotHelper screenshotHelper;

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
        this.screenshotHelper = new ScreenshotHelper(driver);
        PageFactory.initElements(driver, this);
        waitForPageLoaded(driver, By.id("content-hook_order_confirmation"), "controller=order-confirmation");
    }

    public void takeScreenshot() {
        screenshotHelper.takeScreenshot("VisiblePageOrderConfirmation");
    }

    public void takeFullPageScreenshot() {
        screenshotHelper.takeFullPageScreenshot("FullPageOrderConfirmation");
    }

}

