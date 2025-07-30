package steps;

import dto.Account;
import org.openqa.selenium.WebDriver;
import pages.NewAccountModal;
import pages.NewAccountPage;

public class AccountStep {
    WebDriver driver;
    NewAccountModal newAccountModal;
    NewAccountPage newAccountPage;

    public AccountStep(WebDriver driver) {
        this.driver = driver;
        newAccountModal = new NewAccountModal(driver);
        newAccountPage = new NewAccountPage(driver);
    }

    public void createAccount(Account account){
        newAccountModal.isNewAccountModalOpened()
                .createAccount(account)
                .checkAccountIsCreated();
    }
}