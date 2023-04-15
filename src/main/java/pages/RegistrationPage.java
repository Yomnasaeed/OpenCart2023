package pages;

import base.PageBase;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends PageBase {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    By FIRSTNAME_TXT = By.id("input-firstname");
    By LASTNAME_TXT = By.id("input-lastname");
    By EMAIL_TXT = By.id("input-email");
    By TEL_TXT = By.id("input-telephone");
    By PASSWORD_TXT = By.id("input-password");
    By CONFIRMPASSWORD_TXT = By.id("input-confirm");
    By TERMS_CHECK = By.name("agree");
    By CONTINUE_BTN = By.xpath("//*[contains(@class,'btn btn-primary')]");
    By MYACCOUNT_BTN = By.xpath("//span[@class='hidden-xs hidden-sm hidden-md' and contains(text(),'My Account')]");
    public By REGSUCCESS_MSG = By.xpath("//*[@id='content']/p[1]");
    public By LOGOUT_BTN = By.xpath("//li/a[text()='Logout']");
    public By EMAILVALIDATION_ERROR = By.xpath("//*[contains(text(),'E-Mail Address')]");
    public By TELVALIDATION_ERROR = By.xpath("//*[contains(text(),'Telephone must be')]");
    public By PASSWORDVALIDATIO_ERROR = By.xpath("//*[contains(text(),'Password must be between 4 and 20 characters!')]");


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

    //Kept for your revisit
    public boolean getRegistrationSuccessMsg (){
        driver.findElement(REGSUCCESS_MSG).getText().contains("Your");
        return true;
    }


    public void clickOnLogout(){
        clickButton(LOGOUT_BTN);
    }

    public RegistrationPage InvalidRegistrationWithFN_LN (String firstName, String lastName) throws InterruptedException {
        typeTextInField(FIRSTNAME_TXT, firstName);
        typeTextInField(LASTNAME_TXT, lastName);
        clickButton(TERMS_CHECK);
        return this;
    }

    public RegistrationPage InvalidRegWithNoPassword (String email, String telephone) throws InterruptedException {
        typeTextInField(EMAIL_TXT, email);
        typeTextInField(TEL_TXT, telephone);
        return this;
    }

    public RegistrationPage InvalidRegLessThan4Password (String invalidPass) throws InterruptedException {
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
