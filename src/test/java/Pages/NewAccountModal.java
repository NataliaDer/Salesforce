package Pages;

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
    public NewAccountModal(WebDriver driver) {
        super(driver);
    }
    private final By NEW_ACCOUNTMODAL_TITLE = By.xpath("//h2[contains(@class, 'slds-modal__title') and contains (text(), 'New Account')]");
    private final By SAVE_BUTTON = By.xpath("//button[@name='SaveEdit']");
    private final By TITLE_NEW_ACCOUNT =By.xpath("//lightning-formatted-text[text()='MynewAccount1']");

    @Step("Проверка открытия страницы Модального окна создания новго аккаунта")
    public boolean isNewAccountModalOpened (){
        return driver.findElement(NEW_ACCOUNTMODAL_TITLE).isDisplayed();
    }


    public void createAccount(){
        new Input(driver, "Account Name").write("MynewAccount1");
        new Input(driver, "Phone").write("+123456789");
        new Input(driver,"Fax").write("+789456123");
        new Input(driver,"Account Number").write("987654321");
        new Input(driver,"Website").write("www.test.com");
        new Input(driver,"Account Site").write("www.testAccountSiteLabel.com");
        new Input(driver,"Ticker Symbol").write("Ticker Symbol");
        new Input(driver,"Employees").write("100");
        new Input(driver,"Annual Revenue").write("1000");
        new Input(driver,"SIC Code").write("SIC Code");
        new TextArea(driver,"Billing Street").complete("text Billing address");
        new TextArea(driver,"Shipping Street").complete("text Shipping Street");
        new DropDown(driver,"Rating").pickOption("Warm");
        new DropDown(driver,"Type").pickOption("Prospect");
        new DropDown(driver,"Industry").pickOption("Banking");
        new DropDown(driver,"Ownership").pickOption("Public");
        new CheckBox(driver,"VIP_Client__c").checkBox("VIP_Client__c");
        new CheckBox(driver,"TeachMeSkills__c").checkBox("TeachMeSkills__c");
        driver.findElement(SAVE_BUTTON).click();
        new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public boolean checkAccountIsCreated (){
       return driver.findElement(TITLE_NEW_ACCOUNT).isDisplayed();
    }
}