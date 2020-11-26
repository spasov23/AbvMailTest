package bg.abv.tests.positive;

import bg.abv.core.App;
import enums.Password;
import enums.Username;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainPageTests {
    private App app;

    @BeforeMethod
    public void setup() {
        app = new App();
        app.startBrowser("http://abv.bg");
        app.loginPage.login(Username.VALID_USER, Password.VALID_PASSWORD);
        app.loginPage.verifySuccessfulLoginMessage();
    }

    @Test
    public void canSuccessfullySendAndDeliverEmail() {
        //compose and send email
        app.mainPage.openComposeEMailForm();
        app.mainPage.verifyComposePage();
        app.mainPage.enterEmailRecipient("ks_test_mail@abv.bg");
        app.mainPage.enterEmailSubject("testSubject");
        app.mainPage.enterEmailContent("test mail");
        app.mainPage.clickOnSendButton();
        app.mainPage.verifySuccessfulSendEmail();

        //do the advanced search for email
        app.mainPage.navigateToAdvanceSearchForm();
        app.mainPage.verifyAdvancedSearchPage();

        //fill requested sender and subject
        app.mainPage.enterRequestedEmailSender("ks_test_mail@abv.bg");
        app.mainPage.enterRequestedEmailSubject("testSubject");
        app.mainPage.clickOnSearchButton();

        // open first result of the advanced search
        app.mainPage.openFirstResultOfAdvancedSearch();

        // verify that the email created above is delivered successfully
        Assert.assertEquals(app.mainPage.getOpenedEmailSender().substring(1, app.mainPage.getOpenedEmailSender().length()-1),"ks_test_mail@abv.bg");
        Assert.assertEquals(app.mainPage.getOpenedEmailSubject(),"testSubject");
    }


    @AfterMethod
    public void tearDown(){
        app.quit();
    }
}
