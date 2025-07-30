package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPage extends BasePage {
    private final By HOME_TITLE = By.xpath("//span[contains(@class, 'breadcrumbDetail uiOutputText') and text()='Home']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие Главной страницы")
    public MainPage openHomePage() {
        driver.get(BASE_URL + "/lightning/setup/SetupOneHome/home");
        new WebDriverWait(driver, Duration.ofSeconds(50));
        return this;
    }

    @Step("Проверка открытия Главной страницы")
    public MainPage IsMainPageOpened() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(HOME_TITLE));
        driver.findElement(HOME_TITLE).isDisplayed();
        return this;
    }
}