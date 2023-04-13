package pages;

import base.PageBase;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends PageBase {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    By firstName_txt = By.id("input-firstname");
    By lastName_txt = By.id("input-lastname");
    By email_txt = By.id("input-email");
    By tel_txt = By.id("input-telephone");
    By password_txt = By.id("input-password");
    By confirmPassword_txt = By.id("input-confirm");
    By terms_check = By.name("agree");
    By continue_btn = By.xpath("//*[contains(@class,'btn btn-primary')]");
    By myAccount_btn = By.xpath("//span[@class='hidden-xs hidden-sm hidden-md' and contains(text(),'My Account')]");
    public By congrats_Message = By.xpath("//*[@id='content']/p[1]");
    public By logout_Btn = By.xpath("//li/a[text()='Logout']");
    public By emailValidation_error = By.xpath("//*[contains(text(),'E-Mail Address')]");
    public By telValidation_error = By.xpath("//*[contains(text(),'Telephone must be')]");
    public By passwordValidation_error = By.xpath("//*[contains(text(),'Password must be between 4 and 20 characters!')]");


    public void validRegistration (String firstName, String lastName, String email, String telephone,
                                   String password) throws InterruptedException {
        typeTextInField(firstName_txt, firstName);
        typeTextInField(lastName_txt, lastName);
        typeTextInField(email_txt, email);
        typeTextInField(tel_txt, telephone);
        typeTextInField(password_txt, password);
        typeTextInField(confirmPassword_txt, password);
        clickButton(terms_check);
        clickButton(continue_btn);
    }

    public void openMyAccountMenu(){
        clickButton(myAccount_btn);
    }

    public void clickOnLogout(){
        clickButton(logout_Btn);
    }

    public void InvalidRegistrationWithFN_LN (String firstName, String lastName) throws InterruptedException {
        typeTextInField(firstName_txt, firstName);
        typeTextInField(lastName_txt, lastName);
        clickButton(terms_check);
        clickButton(continue_btn);
    }

    public void InvalidRegWithNoPassword (String firstName, String lastName, String email, String telephone) throws InterruptedException {
        typeTextInField(firstName_txt, firstName);
        typeTextInField(lastName_txt, lastName);
        typeTextInField(email_txt, email);
        typeTextInField(tel_txt, telephone);
        clickButton(terms_check);
        clickButton(continue_btn);
    }

    public void InvalidRegLessThan4Password (String firstName, String lastName, String email, String telephone, String invalidPass) throws InterruptedException {
        typeTextInField(firstName_txt, firstName);
        typeTextInField(lastName_txt, lastName);
        typeTextInField(email_txt, email);
        typeTextInField(tel_txt, telephone);
        typeTextInField(password_txt, invalidPass);
        typeTextInField(confirmPassword_txt, invalidPass);
        clickButton(terms_check);
        clickButton(continue_btn);
    }
}
