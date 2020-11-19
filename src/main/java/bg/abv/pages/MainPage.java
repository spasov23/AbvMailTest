package bg.abv.pages;

import bg.abv.pages.base.ParentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MainPage extends ParentPage {

    public MainPage(WebDriver driver){
        super(driver);
    }

    //inbox folder locators
    private static final By INBOX_FOLDER = By.xpath("//div[text()='Кутия']");
    private static final By LAST_RECEIVED_EMAIL = By.xpath ("//*[@id=\"inboxTable\"]/tbody[1]/tr[1]");

    // opened email locators
    private static final By CURRENT_EMAIL_SUBJECT = By.cssSelector (".abv-letterSubject");
    private static final By CURRENT_EMAIL_SENDER = By.xpath ("//*[@id=\"main\"]/div/div[4]/div/div[4]" +
            "/div/div[4]/div/div[2]/div/div[2]/div/div[7]/div/div/table/tbody/tr[1]/td[2]/div/div[1]/em");

    //searchBox locator
    private static final By SEARCH_FIELD = By.id("searchFieldInbox");

    //advanced search locators
    private static final By ADVANCED_SEARCH_FORM_TITLE = By.cssSelector(".advancedSTitle");
    private static final By ADV_SEARCH_POPUP_BUTTON = By.cssSelector (".advSearch");
    private static final By ADV_SEARCH_FROM_FIELD = By.cssSelector("#main > div > div:nth-child(4) > div > div:nth-child(4)" +
            " > div > div:nth-child(4) > div > div:nth-child(2)" +
            " > div > div.advancedSearch > div:nth-child(1) > input");
    private static final By ADV_SEARCH_SUBJECT_FIELD = By.cssSelector ("#main > div > div:nth-child(4)" +
            " > div > div:nth-child(4) > div > div:nth-child(4) > div > div:nth-child(2)" +
            " > div > div.advancedSearch > div:nth-child(3) > input");
    private static final By ADV_SEARCH_BUTTON = By.xpath("//div[text()='Търси']");
    private static final By ADV_SEARCH_FIRST_RESULT = By.cssSelector("#inboxTable > tbody:nth-child(3) > tr");

    //compose mail locators
    private static final By COMPOSE_EMAIL_BUTTON = By.xpath("//div[text()='Напиши']");
    private static final By COMPOSE_EMAIL_RECIPIENT_FIELD = By.xpath ("//*[@id=\"main\"]/div/div[4]/div/div[4]/div/div[4]/div/div[2]" +
            "/div/div[2]/div/div[2]/div[1]/table/tbody/tr[2]/td[2]/div/input");
    private static final By COMPOSE_EMAIL_SUBJECT_FIELD = By.xpath("//*[@id=\"main\"]/div/div[4]/div/div[4]/div/div[4]/div/div[2]" +
            "/div/div[2]/div/div[2]/div[1]/table/tbody/tr[5]/td[2]/div/input");
    private static final By COMPOSE_EMAIL_LETTER_CONTENT_FIELD =By.cssSelector ("#main > div > div:nth-child(4) > div > div:nth-child(4)" +
            " > div > div:nth-child(4) > div > div:nth-child(2) > div > div:nth-child(2) > div > iframe");
    private static final By COMPOSE_EMAIL_SEND_BUTTON = By.xpath ("//div[text() ='Изпрати' ]");
    private static final By SUCCESSFUL_SEND_MESSAGE = By.cssSelector ("#middlePagePanel > div:nth-child(1) > div.abv-h2");

    public void openInboxFolder(){
        click(INBOX_FOLDER);
    }

    public void openLastReceivedEmail(){
        click(LAST_RECEIVED_EMAIL);
    }

    public String getEmailSubject(){
        return getElementText(CURRENT_EMAIL_SUBJECT);
    }

    public String getEmailSender(){
        return getElementText(CURRENT_EMAIL_SENDER);
    }

    public void openComposeEMailForm(){
        click(COMPOSE_EMAIL_BUTTON);
    }

    public void enterEmailRecipient(String recipient){
        type(COMPOSE_EMAIL_RECIPIENT_FIELD,recipient);
    }

    public void enterEmailSubject(String subject){
        type(COMPOSE_EMAIL_SUBJECT_FIELD, subject);
    }

    public void enterEmailContent(String content){
        type(COMPOSE_EMAIL_LETTER_CONTENT_FIELD,content);
    }

    public void clickOnSendButton(){
        click(COMPOSE_EMAIL_SEND_BUTTON);
    }

    public void navigateToAdvanceSearchForm(){
        click(SEARCH_FIELD);
        click(ADV_SEARCH_POPUP_BUTTON);
    }

    public void enterRequestedEmailSender(String sender){
        type(ADV_SEARCH_FROM_FIELD,sender);
    }

    public void enterRequestedEmailSubject(String subject){
        type(ADV_SEARCH_SUBJECT_FIELD, subject);
    }

    public void clickOnSearchButton(){
        click(ADV_SEARCH_BUTTON);
    }

    public void openFirstResultOfAdvancedSearch(){
        click(ADV_SEARCH_FIRST_RESULT);
    }

    public void verifyComposePage(){
        Assert.assertTrue(isDisplayed(COMPOSE_EMAIL_SEND_BUTTON));
    }

    public void verifyAdvancedSearchPage(){
        Assert.assertEquals(getElementText(ADVANCED_SEARCH_FORM_TITLE),"Разширено търсене");
    }

    public void verifySuccessfulSendEmail(){
        Assert.assertEquals(getElementText(SUCCESSFUL_SEND_MESSAGE),"Писмото беше изпратено успешно!");
    }
}
