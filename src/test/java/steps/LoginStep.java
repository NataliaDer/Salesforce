package steps;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.MainPage;

public class LoginStep {
    WebDriver driver;
    LoginPage loginPage;
    MainPage mainPage;

    public LoginStep(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
    }

    public  void auth(String user, String password){
        loginPage.openLoginPage()
                .isPageOpened()
                .enterUserName(user)
                .enterPassword(password)
                .clickLogin();
    }
}