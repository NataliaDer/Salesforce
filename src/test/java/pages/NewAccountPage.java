package pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class NewAccountPage extends BasePage{

    public NewAccountPage (WebDriver driver) {
        super(driver);
    }

    private final By TITLE_NEW_ACCOUNT = By.xpath("//p[contains(@class, 'slds-text-title') and contains(text(), 'Account Owner')]");

    public  NewAccountPage checkAccountIsCreated() {
        driver.findElement(TITLE_NEW_ACCOUNT).isDisplayed();
        return this;
    }
}
