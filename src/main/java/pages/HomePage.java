package pages;

import base.PageBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }

   private static final By MY_ACCOUNT_BTN = By.xpath("//span[@class='hidden-xs hidden-sm hidden-md' and contains(text(),'My Account')]");
    private static final By REGISTER_BTN = By.xpath("//*[contains(@href,'register')]");
    private static final By LOGOUT_BTN = By.xpath("//li/a[text()='Logout']");
    private static final By LOGIN_BTN = By.xpath("//*[contains(@href,'login') and text()='Login']");

    public HomePage makeSureYouAreInHomePage(){
        Assert.assertEquals("Locator of the header Your Store ","Your Store");
        return this;
    }

    public HomePage clickOnMyAccountButton(){
        clickButton(MY_ACCOUNT_BTN);
        return this;
    }

    public HomePage clickOnLoginButton(){
        clickButton(LOGIN_BTN);
        return this;
    }

    public RegistrationPage clickOnRegisterBtn() {
        clickButton(MY_ACCOUNT_BTN);
        clickButton(REGISTER_BTN);
        return new RegistrationPage(driver);
    }

    public HomePage userLogout() {
        clickButton(MY_ACCOUNT_BTN);
        clickButton(LOGOUT_BTN);
        return new HomePage(driver);
    }

    public By getLogoutBtn(){
        return LOGOUT_BTN;
    }
}


