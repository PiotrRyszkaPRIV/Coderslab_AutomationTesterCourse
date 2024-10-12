package com.course.selenium.pages;

import com.course.selenium.fragments.AddressPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.course.selenium.helpers.SeleniumHelper.waitForElementVisible;
import static com.course.selenium.helpers.SeleniumHelper.waitForPageLoaded;

public class MyAddressesPage {


    By locatorAlertSuccess = By.cssSelector(".alert > ul:nth-child(1) > li:nth-child(1)");
    @FindBy(css = ".addresses-footer > a:nth-child(1) > span:nth-child(2)")
    private WebElement createNewAddress;

    @FindBy(css = "address-body")
    private List<WebElement> addresses;
    private Map<String, String> addressesByAlias;

    private final WebDriver driver;

    public MyAddressesPage(WebDriver driver) {
        this.driver = driver;
        waitForPageLoaded(driver, By.cssSelector("a.account-link:nth-child(2) > span:nth-child(2)"), "addresses");
        PageFactory.initElements(driver, this);
        this.addresses = addresses;
        this.addressesByAlias =new HashMap<>();
    }

    public void createNewAddress() {
        createNewAddress.click();
    }

    public String getSuccessMessage() {
        WebElement alert = waitForElementVisible(driver, locatorAlertSuccess, 10);
        return alert.getText().strip();
    }

    public Map<String, String> getAddressesByAlias(String alias) {
        addressesByAlias.clear();
        for (WebElement element : addresses) {
            String aliasText = element.findElement(By.cssSelector("h4")).getText();
            if (aliasText.equals(alias)) {
                String addressText = element.findElement(By.cssSelector(".address-body")).getText();
                addressesByAlias.put(alias, addressText);
            }
        }
        return addressesByAlias;
    }
}
