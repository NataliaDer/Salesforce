package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DropDown {
    WebDriver driver;
    String label;
    String option;

    public DropDown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;

    }

    public void pickOption(String option) {
        driver.findElement(By.xpath(String.format("//label[text()='%s']//ancestor::lightning-picklist//button", label))).click();
        new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.xpath(String.format("//label[text()='%s']//ancestor::lightning-picklist" +
                "//lightning-base-combobox-item//span[text()='%s']", label, option))).click();

    }
}