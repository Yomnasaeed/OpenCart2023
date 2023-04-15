package pages;

import base.PageBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends PageBase {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    private static final By FIRSTNAME_TXT = By.id("input-firstname");
    private static final By LASTNAME_TXT = By.id("input-lastname");
    private static final By EMAIL_TXT = By.id("input-email");
    private static final  By TEL_TXT = By.id("input-telephone");
    private static final  By PASSWORD_TXT = By.id("input-password");
    private static final By CONFIRMPASSWORD_TXT = By.id("input-confirm");
    private static final By TERMS_CHECK = By.name("agree");
    private static final  By CONTINUE_BTN = By.xpath("//*[contains(@class,'btn btn-primary')]");
    private static final  By MYACCOUNT_BTN = By.xpath("//span[@class='hidden-xs hidden-sm hidden-md' and contains(text(),'My Account')]");
    private static final By REGSUCCESS_MSG = By.xpath("//*[@id='content']/p[1]");
    private static final By LOGOUT_BTN = By.xpath("//li/a[text()='Logout']");
    private static final By EMAIL_VALIDATION_ERROR = By.xpath("//*[contains(text(),'E-Mail Address')]");
    private static final By TEL_VALIDATION_ERROR = By.xpath("//*[contains(text(),'Telephone must be')]");
    private static final By PASSWORD_VALIDATION_ERROR = By.xpath("//*[contains(text(),'Password must be between 4 and 20 characters!')]");


    public RegistrationPage validRegistration (String firstName, String lastName, String email, String telephone,
                                   String password) throws InterruptedException {
        typeTextInField(FIRSTNAME_TXT, firstName);
        typeTextInField(LASTNAME_TXT, lastName);
        typeTextInField(EMAIL_TXT, email);
        typeTextInField(TEL_TXT, telephone);
        typeTextInField(PASSWORD_TXT, password);
        typeTextInField(CONFIRMPASSWORD_TXT, password);
        clickButton(TERMS_CHECK);
        clickButton(CONTINUE_BTN);

        return this;
    }

    public HomePage openMyAccountMenu(){
        clickButton(MYACCOUNT_BTN);
        return new HomePage(driver);
    }

    public boolean getRegistrationSuccessMsg() {
        return elementVisible(REGSUCCESS_MSG);
    }

    public boolean isEmailValidationMessageDisplayed() {
        return elementVisible(EMAIL_VALIDATION_ERROR);
    }

    public boolean isTileValidationErrorDisplayed() {
        return elementVisible(TEL_VALIDATION_ERROR);
    }

    public boolean isPasswordValidationErrorDisplayed() {
        return elementVisible(PASSWORD_VALIDATION_ERROR);
    }

    public RegistrationPage clickOnLogout(){
        clickButton(LOGOUT_BTN);
        return this;
    }

    public RegistrationPage InvalidRegistrationWithFirstNameLastName(String firstName, String lastName) {
        typeTextInField(FIRSTNAME_TXT, firstName);
        typeTextInField(LASTNAME_TXT, lastName);
        clickButton(TERMS_CHECK);
        return this;
    }

    public RegistrationPage InvalidRegWithNoPassword (String email, String telephone) {
        typeTextInField(EMAIL_TXT, email);
        typeTextInField(TEL_TXT, telephone);
        return this;
    }

    public RegistrationPage InvalidRegLessThan4Password (String invalidPass) {
        typeTextInField(PASSWORD_TXT, invalidPass);
        typeTextInField(CONFIRMPASSWORD_TXT, invalidPass);
        clickButton(CONTINUE_BTN);
        return this;
    }

    public RegistrationPage clickOnContinue(){
        clickButton(CONTINUE_BTN);
        return this;
    }
}
