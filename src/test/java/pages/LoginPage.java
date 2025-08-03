package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage extends BasePage {

    private final By USERNAME_FIELD = By.id("username");
    private final By PASSWORD_FIELD = By.id("password");
    private final By ENTER_BUTTON = By.id("Login");
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы Авторизации")
    public LoginPage openLoginPage() {
        driver.get(BASE_URL);
        return this;
    }

    @Step("Авторизация с именем пользователя:{user} и паролем:{password}")
    public LoginPage isPageOpened(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME_FIELD));
        return this;
    }
    public LoginPage enterUserName(String user){
        driver.findElement(USERNAME_FIELD).sendKeys(user);
        return this;
    }

    public LoginPage enterPassword(String password) {
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        new WebDriverWait(driver, Duration.ofSeconds(50));
        return this;
    }

    public MainPage clickLogin() {
        driver.findElement(ENTER_BUTTON).click();
        new WebDriverWait(driver, Duration.ofSeconds(50));
        return new MainPage(driver);
    }

}

/*
public LoginPage logIn(String user, String password) {
        driver.findElement(USERNAME_FIELD).sendKeys(user);
        new WebDriverWait(driver, Duration.ofSeconds(50));
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        new WebDriverWait(driver, Duration.ofSeconds(50));
        driver.findElement(ENTER_BUTTON).click();
        new WebDriverWait(driver, Duration.ofSeconds(30));
    }
 */