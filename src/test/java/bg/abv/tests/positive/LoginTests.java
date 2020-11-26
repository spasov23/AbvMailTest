package bg.abv.tests.positive;

import bg.abv.core.App;
import enums.Password;
import enums.Username;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests {
    private App app;

    @BeforeMethod
    public void setup() {
        app = new App();
        app.startBrowser("http://abv.bg");
    }

    @Test
    public void canLoginWithValidCredentials() {
        app.loginPage.login(Username.VALID_USER, Password.VALID_PASSWORD);
        app.loginPage.verifySuccessfulLoginMessage();
    }


    @AfterMethod
    public void tearDown(){
        app.quit();
    }
}
