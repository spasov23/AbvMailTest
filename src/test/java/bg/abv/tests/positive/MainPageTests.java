package bg.abv.tests.positive;

import bg.abv.core.core.App;
import enums.Password;
import enums.Username;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainPageTests {
    private App app;

    @BeforeMethod
    public void setup() {
        app = new App();
        app.startBrowser("http://abv.bg");
        app.loginPage.login(Username.USER, Password.PASSWORD);
        app.loginPage.verifySuccessfulLogin();
    }

    @Test
    public void canSuccessfullySendAndDeliverEmail() {
        app.mainPage.openComposeEMailForm();
        app.mainPage.verifyComposePage();
        app.mainPage.enterEmailRecipient("ks_test_mail@abv.bg");
        app.mainPage.enterEmailSubject("test");
        app.mainPage.enterEmailContent("test mail");
        app.mainPage.clickOnSendButton();
        app.mainPage.verifySuccessfulSendEmail();
    }


    @AfterMethod
    public void tearDown(){
        app.quit();
    }
}
