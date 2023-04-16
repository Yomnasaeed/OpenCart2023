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
    private static final By LOGOUT_BTN = By.xpath("//li/a[text()='Logout']");

    public RegistrationPage validRegistration (String firstName, String lastName, String email, String telephone,
                                   String password) {
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

    public ValidationPage clickOnContinue(){
        clickButton(CONTINUE_BTN);
        return new ValidationPage(driver);
    }
}
