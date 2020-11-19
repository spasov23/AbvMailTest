package bg.abv.core.core;

import bg.abv.pages.LoginPage;
import bg.abv.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class App {
    private WebDriver driver;

    public LoginPage loginPage;
    public MainPage mainPage;

    public void startBrowser(String pageToOpen) {
        //initialization of the webdriver instance
        String driverPath = null;
        driverPath = Paths.get("chromedriver.exe").toAbsolutePath().toString();
        System.out.println("The taken driver path is: " + driverPath);

        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //initialization of all page objects
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);

        //open the desired page
        driver.get(pageToOpen);
    }

    public void quit() {
        driver.quit();
    }
}