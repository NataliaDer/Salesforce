package steps;
import org.openqa.selenium.WebDriver;
import pages.AccountsPage;
public class AccountsStep {
    WebDriver driver;
    AccountsPage accountsPage;

    public AccountsStep(WebDriver driver) {
        this.driver = driver;
        accountsPage = new AccountsPage(driver);
    }
        public void openAccountsPage(){
            accountsPage.openNewAccount_Page()
                    .isAccountsPageOpened()
                    .openNewAccountPage();

        }
    }