package com.course.selenium.helpers;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ScreenshotHelper {

    private WebDriver driver;

    public ScreenshotHelper(WebDriver driver) {
        this.driver = driver;
    }

    // Method to take a screenshot and save it as a file
    public void takeScreenshot(String screenshotName) {
        // Take the screenshot as a file
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            // Save the screenshot to the desired location
            FileUtils.copyFile(screenshot, new File("target/screenshots/" + screenshotName + ".png"));
            System.out.println("Screenshot saved: " + screenshotName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Optionally, method to add a screenshot to the Cucumber report
    public void attachScreenshotToReport(Scenario scenario, String screenshotName) {
        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", screenshotName);
    }

    public void takeFullPageScreenshot(String screenshotName) {
        Screenshot screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(1000))  // Wait 1 second between scrolls
                .coordsProvider(new WebDriverCoordsProvider())
                .takeScreenshot(driver);

        // Save the screenshot
        try {
            ImageIO.write(screenshot.getImage(), "PNG", new File("target/screenshots/" + screenshotName + ".png"));
            System.out.println("Full-page screenshot saved: " + screenshotName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}