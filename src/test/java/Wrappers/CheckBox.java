package Wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBox {
    WebDriver driver;
    String label;

    public CheckBox(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void checkBox(String text) {
        driver.findElement(By.xpath(String.format("//input[@name='%s']", label)))
                .click();
    }
}