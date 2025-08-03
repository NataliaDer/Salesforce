package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import dto.Account;

public class AccountTest extends BaseTest{

    @Test
    public void checkAccountCreate(){
       loginStep.auth("tborodich@tms.sandbox", "Password003!");
       mainPageStep.mainPage();
       accountsStep.openNewAccount_Page()
                    .isAccountsPageOpened()
                    .openNewAccountPage();
        Account account = Account.builder()
                .name("NewAccount1")
                .phone("789789")
                .fax("321321")
                .account_number("456456")
                .website("qweqweqwe")
                .account_site("asdasd")
                .ticker_symbol("ghjghj")
                .employees("123")
                .annual_revenue("456")
                .Sic_code("0000")
                .billing_street("kweghklwje")
                .shipping_street("kjfhfhrjhf")
                .rating("Warm")
                .type("Other")
                .industry("Banking")
                .ownership("Public")
                .build();
       accountStep.createAccount(account);
    }
}