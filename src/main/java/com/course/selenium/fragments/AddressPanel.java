package com.course.selenium.fragments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddressPanel {

    public final String header;
    public final String content;

    public AddressPanel(WebElement root) {
        WebElement header = root.findElement(By.cssSelector(".address-body"));
        List<WebElement> spans = root.findElements(By.cssSelector("address"));

        this.header = header.getText();

        StringBuilder sb = new StringBuilder();


        for (WebElement span : spans) {
            String spanText = span.getText().strip();
            if (!spanText.isEmpty()) {
                sb.append(spanText).append(" ");
            }
        }

        content = sb.toString().strip();
    }
}
