package Tests;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AccountTest extends BaseTest{
    @Test
    public void checkAccountsPage(){
        loginPage.openLoginPage();
        loginPage.logIn("tborodich@tms.sandbox", "Password003!");
        new WebDriverWait(driver, Duration.ofSeconds(50));
        mainPage.openHomePage();
        new WebDriverWait(driver, Duration.ofSeconds(50));
        accountsPage.openNewAccountPage();
        new WebDriverWait(driver, Duration.ofSeconds(50));
        Assert.assertTrue(newAccountModal.isNewAccountModalOpened());
        newAccountModal.createAccount();
        new WebDriverWait(driver, Duration.ofSeconds(50));
        newAccountModal.checkAccountIsCreated();
    }
}