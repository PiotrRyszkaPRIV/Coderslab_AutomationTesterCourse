package com.course.selenium.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static com.course.selenium.helpers.SeleniumHelper.waitForElementVisible;

public class ElementHelper {

    public static void fillInput(WebDriver driver, By locator, String text){
        WebElement ele = waitForElementVisible(driver, locator, 10);
        ele.clear();
        ele.sendKeys(text);
    }

    public static void fillInput(WebDriver driver, WebElement element, String text){
        waitForElementVisible(driver,element, 5);
        element.clear();
        element.sendKeys(text);
    }

    public static void clickButton(WebDriver driver, By locator){
        WebElement ele = waitForElementVisible(driver, locator, 10);
        ele.click();
    }

    public static void clickButton(WebDriver driver, WebElement element){
        waitForElementVisible(driver,element, 5);
        element.click();
    }



    public static String getText(WebDriver driver, By locator) {
        WebElement ele = waitForElementVisible(driver, locator, 10);
        return ele.getText();
    }

    public static String getText(WebDriver driver, WebElement element) {
        waitForElementVisible(driver,element, 5);
        return element.getText().strip();
    }

    public static void selectRadioButton(WebDriver driver,By locator,String parentText){

        WebElement  element = driver.findElement(locator);

        WebElement parent = element.findElement(By.xpath(".."));

        String parentAttribute = parent.getAttribute("class");

        if(!parentAttribute.contains(parentText)){
            element.click();
        }else{
            System.out.println("radioButton is selected");
        }
    }
    public static void fillSelect(WebDriver driver, By locator, String text) {

        WebElement selectDays = driver.findElement(locator);
        Select select = new Select(selectDays);
        select.selectByValue(text);
    }

}
