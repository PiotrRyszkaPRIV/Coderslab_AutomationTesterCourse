package com.course.selenium.browserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    public static WebDriver initializeDriver(BrowserType browserType) {
        switch (browserType) {
            case CHROME: {
                WebDriver driver = new ChromeDriver();
                setUpDriver(driver);
                return driver;
            }
            case FIREFOX: {
                WebDriver driver = new FirefoxDriver();
                setUpDriver(driver);
                return driver;
            }
            default:
                throw new WebDriverException("-> error: Browser name not found! Cannot initialize browser driver");

        }
    }

    private static void setUpDriver(WebDriver driver){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
