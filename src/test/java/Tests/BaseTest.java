package Tests;

import pages.AccountsPage;
import pages.LoginPage;
import pages.MainPage;
import pages.NewAccountModal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.HashMap;
//import static Tests.AllureUtils.takeScreenshot;

public class BaseTest {
    WebDriver driver;
    SoftAssert softAssert;
    AccountsPage accountsPage;
    LoginPage loginPage;
    MainPage mainPage;
    NewAccountModal newAccountModal;

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true, description = "Настройка драйвера")
    public void setup(@Optional("chrome") String browser, ITestContext iTestContext) {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            HashMap<String, Object> chromePrefs = new HashMap<>();
            chromePrefs.put("credentials_enable_service", false);
            chromePrefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", chromePrefs);
            options.addArguments("--incognito");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-infobars");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }
        softAssert = new SoftAssert();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        iTestContext.setAttribute("driver", driver);
        loginPage = new LoginPage(driver);
        accountsPage = new AccountsPage(driver);
        mainPage = new MainPage(driver);
        newAccountModal = new NewAccountModal(driver);
    }

    @AfterMethod (alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}