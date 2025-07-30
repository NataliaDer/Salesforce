package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountsPage extends BasePage {
    protected final String ACCOUNTS_URL = BASE_URL + "/lightning/o/Account/list?filterName=__Recent";
    private final By ACCOUNTS_TITLE = By.xpath("//h1[contains(@class, 'slds-var-p-right_x-small') and text()='Accounts']");
    private final By NEW_BUTTON = By.cssSelector("[title=New]");
    public AccountsPage(WebDriver driver) {
        super(driver);
    }

    public AccountsPage openNewAccount_Page() {
        driver.get(ACCOUNTS_URL);
        return this;
    }

    @Step("Проверка открытия страницы Аккаунты")
    public AccountsPage isAccountsPageOpened() {
         driver.findElement(ACCOUNTS_TITLE).isDisplayed();
         return this;
    }

    @Step("Открытие страницы Создания нового аккаунта")
    public NewAccountModal openNewAccountPage() {
        driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Account/new?count=1");
        new WebDriverWait(driver, Duration.ofSeconds(50));
        return new NewAccountModal(driver);
    }
}