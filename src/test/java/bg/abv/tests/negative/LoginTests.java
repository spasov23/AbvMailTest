package bg.abv.tests.negative;

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
    public void cantLoginWithInvalidCredentials() {
        app.loginPage.login(Username.INVALID_USER, Password.INVALID_PASSWORD);
        app.loginPage.verifyInvalidCredentialsMessage();
    }


    @AfterMethod
    public void tearDown(){
        app.quit();
    }
}
