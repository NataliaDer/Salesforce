package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountTest extends BaseTest{
    @Test
    public void checkAccountsPage(){
        loginPage.openLoginPage();
        loginPage.logIn("tborodich@tms.sandbox", "Password003!");
        mainPage.openHomePage();
        accountsPage.openNewAccountPage();
        Assert.assertTrue(newAccountModal.isNewAccountModalOpened());
        newAccountModal.createAccount("NewAccount1","789789","321321",
                "456456","qweqweqwe",
                "asdasd", "ghjghj","123",
                "456", "0000","kweghklwje",
                "kjfhfhrjhf","Warm", "Other",
                "Banking",
                "Public","VIP_Client__c",
                "TeachMeSkills__c");
        newAccountModal.checkAccountIsCreated();
    }
}