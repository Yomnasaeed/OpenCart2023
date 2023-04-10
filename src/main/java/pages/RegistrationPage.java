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
    public By congrats_Message = By.xpath("//*[@id='content']/p[1]");
    public By logout_Btn = By.xpath("//*[contains(text(),'Logout') and @class='list-group-item']");


    @Step("Enter firstName: {0}")
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

    public void userLogout() throws InterruptedException {
        waitUntilElementIsClickable(logout_Btn);
        clickButton(logout_Btn);
    }
}
