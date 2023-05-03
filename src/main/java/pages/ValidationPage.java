package pages;

import base.PageBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ValidationPage extends PageBase {
    public ValidationPage(WebDriver driver) {
        super(driver);
    }

    private static final By REGISTRATION_SUCCESS_MSG = By.xpath("//*[@id='content']/p[1]");
    private static final By EMAIL_VALIDATION_ERROR = By.xpath("//*[contains(text(),'E-Mail Address')]");
    private static final By TEL_VALIDATION_ERROR = By.xpath("//*[contains(text(),'Telephone must be')]");
    private static final By PASSWORD_VALIDATION_ERROR = By.xpath("//*[contains(text(),'Password must be between 4 and 20 characters!')]");
    private static final By MYACCOUNT_HEADER = By.id("content");
    private static final By INVALIDLOGIN_ERROR = By.className("alert-danger");
    private static final By EURO_SIGN = By.xpath("//div/button/strong");
    public static final By TabletsInBreadCrumb = By.xpath("//a[text()='Tablets'][1]");
    public static final By TabletsInLeftMenu = By.xpath("//a[text()='Tablets (1)']");
    private static final By AppleCinemaProduct =By.xpath("//a[text()='Apple Cinema 30\"']");


    public boolean getRegistrationSuccessMsg() {
        return elementVisible(REGISTRATION_SUCCESS_MSG);
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

    public boolean isEuroSignDisplayed() {
        return elementVisible(EURO_SIGN);
    }

    public boolean isMyAccountHeaderVisible() {
        return elementVisible(MYACCOUNT_HEADER);
    }

    public String getInvalidLoginErrorMessageText() {
        return getElementText(INVALIDLOGIN_ERROR);
    }

    public String getTabletsTextInBreadCrumb() {
        return getElementText(TabletsInBreadCrumb);
    }

    public String getTabletsTextInLeftMenu() {
        return getElementText(TabletsInLeftMenu);
    }

    public boolean isAppleCinemaDisplayed(){

        return elementVisible(AppleCinemaProduct);
    }


}

