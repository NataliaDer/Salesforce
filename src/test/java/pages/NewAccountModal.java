package pages;

import wrappers.DropDown;
import wrappers.Input;
import wrappers.TextArea;
import dto.Account;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewAccountModal extends BasePage {
    private final By NEW_ACCOUNTMODAL_TITLE = By.xpath("//h2[contains(@class, 'slds-modal__title') and contains (text(), 'New Account')]");
    private final By SAVE_BUTTON = By.xpath("//button[@name='SaveEdit']");

    public NewAccountModal(WebDriver driver) {
        super(driver);
    }

    @Step("Проверка открытия страницы Модального окна создания новго аккаунта")
    public NewAccountModal isNewAccountModalOpened() {
         driver.findElement(NEW_ACCOUNTMODAL_TITLE).isDisplayed();
         return this;
    }

    public NewAccountPage createAccount(Account account) {
        new Input(driver, "Account Name").write(account.getName());
        new Input(driver, "Phone").write(account.getPhone());
        new Input(driver, "Fax").write(account.getFax());
        new Input(driver, "Account Number").write(account.getAccount_number());
        new Input(driver, "Website").write(account.getWebsite());
        new Input(driver, "Account Site").write(account.getAccount_site());
        new Input(driver, "Ticker Symbol").write(account.getTicker_symbol());
        new Input(driver, "Employees").write(account.getEmployees());
        new Input(driver, "Annual Revenue").write(account.getAnnual_revenue());
        new Input(driver, "SIC Code").write(account.getSic_code());
        new TextArea(driver, "Billing Street").complete(account.getBilling_street());
        new TextArea(driver, "Shipping Street").complete(account.getShipping_street());
        new DropDown(driver, "Rating").pickOption(account.getRating());
        new DropDown(driver, "Type").pickOption(account.getType());
        new DropDown(driver, "Industry").pickOption(account.getIndustry());
        new DropDown(driver, "Ownership").pickOption(account.getOwnership());
        new WebDriverWait(driver, Duration.ofSeconds(50));
        driver.findElement(SAVE_BUTTON).click();
        new WebDriverWait(driver, Duration.ofSeconds(20));
        return new NewAccountPage(driver);
    }
}