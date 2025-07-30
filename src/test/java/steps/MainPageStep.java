package steps;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

public class MainPageStep {
    WebDriver driver;
    MainPage mainPage;

    public MainPageStep(WebDriver driver) {
        this.driver = driver;
        mainPage = new MainPage(driver);
    }

    public void mainPage(){
        mainPage.openHomePage()
                .IsMainPageOpened();
    }
}
