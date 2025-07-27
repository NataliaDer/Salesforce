package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountsPage extends BasePage{
    public AccountsPage(WebDriver driver) {
        super(driver);
    }

    protected final String ACCOUNTS_URL = BASE_URL + "/lightning/o/Account/list?filterName=__Recent";

    private final By ACCOUNTS_TITLE = By.xpath("//h1[contains(@class, 'slds-var-p-right_x-small') and text()='Accounts']");
    private final By NEW_BUTTON = By.cssSelector("[title=New]");

    public void openNewAccount_Page(){
        driver.get(ACCOUNTS_URL);
    }

    @Step("Проверка открытия страницы Аккаунты")
    public boolean isAccountsPageOpened(){
        return driver.findElement(ACCOUNTS_TITLE).isDisplayed();
    }

    @Step("Открытие страницы Создания нового аккаунта")
    public void openNewAccountPage(){
        //driver.findElement(NEW_BUTTON).click();
        //driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Account/new");
        driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Account/new?count=1");
        new WebDriverWait(driver, Duration.ofSeconds(50));
    }
}
