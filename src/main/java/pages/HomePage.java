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

    By MYACCOUNT_BTN = By.xpath("//span[@class='hidden-xs hidden-sm hidden-md' and contains(text(),'My Account')]");
    By REGISTER_BTN = By.xpath("//*[contains(@href,'register')]");
    public By LOGOUT_BTN = By.xpath("//li/a[text()='Logout']");

    public HomePage makeSureYouAreInHomePage(){
        Assert.assertEquals("Locator of the header Your Store ","Your Store");
        return this;
    }
    public RegistrationPage clickOnRegisterBtn() {
        clickButton(MYACCOUNT_BTN);
        clickButton(REGISTER_BTN);
        return new RegistrationPage(driver);
    }

    public HomePage userLogout() throws InterruptedException {
        clickButton(MYACCOUNT_BTN);
        clickButton(LOGOUT_BTN);
        return new HomePage(driver);
    }
};


