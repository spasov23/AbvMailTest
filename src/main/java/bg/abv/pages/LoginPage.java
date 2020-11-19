package bg.abv.pages;

import bg.abv.pages.base.ParentPage;
import enums.Password;
import enums.Username;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends ParentPage {

    private static final By USERNAME_FIELD = By.id("username");
    private static final By PASSWORD_FIELD = By.id("password");
    private static final By LOGIN_BUTTON = By.id("loginBut");
    private static final By WELCOME_MESSAGE = By.cssSelector(".h1");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(Username username, Password password) {
        type(USERNAME_FIELD, username.getUsername());
        type(PASSWORD_FIELD, password.getPassword());
        click(LOGIN_BUTTON);
    }

    public void verifySuccessfulLogin(){
        Assert.assertTrue(getElementText(WELCOME_MESSAGE).contains("Здравейте"));
    }
}