package pages;

import Wrappers.CheckBox;
import Wrappers.DropDown;
import Wrappers.Input;
import Wrappers.TextArea;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewAccountModal extends BasePage {
    private final By NEW_ACCOUNTMODAL_TITLE = By.xpath("//h2[contains(@class, 'slds-modal__title') and contains (text(), 'New Account')]");
    private final By SAVE_BUTTON = By.xpath("//button[@name='SaveEdit']");
    private final By TITLE_NEW_ACCOUNT = By.xpath("//p[contains(@class, 'slds-text-title') and contains(text(), 'Account Owner')]");
    public NewAccountModal(WebDriver driver) {
        super(driver);
    }

    @Step("Проверка открытия страницы Модального окна создания новго аккаунта")
    public boolean isNewAccountModalOpened() {
        return driver.findElement(NEW_ACCOUNTMODAL_TITLE).isDisplayed();
    }


    public void createAccount(String name, String phone, String fax, String account_number, String website,
                              String account_site, String ticker_symbol, String employees, String annual_revenue, String Sic_code,
                              String billing_street, String shipping_street, String rating, String type, String industry,
                              String ownership, String CheckVip, String checkTech) {
        new Input(driver, "Account Name").write(name);
        new Input(driver, "Phone").write(phone);
        new Input(driver, "Fax").write(fax);
        new Input(driver, "Account Number").write(account_number);
        new Input(driver, "Website").write(website);
        new Input(driver, "Account Site").write(account_site);
        new Input(driver, "Ticker Symbol").write(ticker_symbol);
        new Input(driver, "Employees").write(employees);
        new Input(driver, "Annual Revenue").write(annual_revenue);
        new Input(driver, "SIC Code").write(Sic_code);
        new TextArea(driver, "Billing Street").complete(billing_street);
        new TextArea(driver, "Shipping Street").complete(shipping_street);
        new DropDown(driver, "Rating").pickOption(rating);
        new DropDown(driver, "Type").pickOption(type);
        new DropDown(driver, "Industry").pickOption(industry);
        new DropDown(driver, "Ownership").pickOption(ownership);
        new CheckBox(driver, "VIP_Client__c").checkBox(CheckVip);
        new CheckBox(driver, "TeachMeSkills__c").checkBox(checkTech);
        new WebDriverWait(driver, Duration.ofSeconds(50));
        driver.findElement(SAVE_BUTTON).click();
        new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public boolean checkAccountIsCreated() {
        return driver.findElement(TITLE_NEW_ACCOUNT).isDisplayed();
    }
}