package com.course.selenium.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class SeleniumHelper {

    public static void waitForPageLoaded(WebDriver driver, By locator, String url){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.ignoring(StaleElementReferenceException.class)
                .until(
                        and(
                                visibilityOfElementLocated(locator),
                                urlContains(url)
                        )
                );
    }

    public static void waitForPageLoaded(WebDriver driver, By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.ignoring(StaleElementReferenceException.class)
                .until(visibilityOfElementLocated(locator));
    }


    public static WebElement waitForElementVisible(WebDriver driver, By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForElementVisible(WebDriver driver, WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static Boolean waitForUrlContains(WebDriver driver, int seconds, String urlTest) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.urlContains(urlTest));
    }
    public static Boolean waitParentAttribute(WebDriver driver, WebElement element, String artibute, String artibuteValue) {

        WebElement divParent = element.findElement(By.xpath(".."));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.attributeContains(divParent, artibute, artibuteValue));
    }
}
