package tests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;
import pages.ValidationPage;
import utilities.LoadProperties;

public class ValidLoginTest extends TestBase {

    HomePage homePageObj;
    RegistrationPage registrationPageObj;
    ValidationPage validationPageObj;
    LoginPage loginObj;
    String validEmail = LoadProperties.userData.getProperty("Email");
    String validPassword = LoadProperties.userData.getProperty("Password");

    @BeforeMethod
    public void beforeTest() {
        homePageObj = new HomePage(driver);
        validationPageObj = new ValidationPage(driver);
        loginObj = new LoginPage(driver);
    }

    @Test(priority = 0)
    public void clickOnLogin(){
        homePageObj.clickOnMyAccountButton()
                .clickOnLoginButton();
    }

    @Test(priority = 1)
    public void userValidLogin(){
        loginObj.validUserLogin(validEmail,validPassword);
        Assert.assertTrue(validationPageObj.isMyAccountHeaderVisible(),"My Account header was not displayed");
    }
}
