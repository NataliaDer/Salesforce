package pages;
/*
1. В проекте Salesforce реализовать структуру фреймворка с помощью
Page Object Model: LoginPage, MainPage, AccountsPage,
NewAccountModal и т.д.
2. Реализовать тесты для создания  сущностей Account
используя обертки над элементами
3. Выполнить проверки о том, что сущности созданы
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    protected final String BASE_URL = "https://tms9-dev-ed.develop.my.salesforce.com";
    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }
}