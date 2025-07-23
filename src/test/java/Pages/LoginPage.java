package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By USERNAME_FIELD = By.id("username");
    private final By PASSWORD_FIELD = By.id("password");
    private final By ENTER_BUTTON = By.id("Login");

    @Step("Открытие страницы Авторизации")
    public  void openLoginPage (){
        driver.get(BASE_URL);
    }
    @Step("Авторизация с именем пользователя:{user} и паролем:{password}")
    public void logIn (String user, String password){
        driver.findElement(USERNAME_FIELD).sendKeys(user);
        new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(ENTER_BUTTON).click();
         new WebDriverWait(driver, Duration.ofSeconds(30));
    }
}