package tests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ValidationPage;
import utilities.LoadProperties;

public class InvalidLoginTest extends TestBase {

    HomePage homeObj;
    LoginPage loginObj;
    ValidationPage validationObj;
    String invalidEmail = LoadProperties.userData.getProperty("InvalidEmail");
    String invalidPassword = LoadProperties.userData.getProperty("InvalidPassword");


    @BeforeMethod
    public void beforeTest (){
        homeObj = new HomePage(driver);
        loginObj = new LoginPage(driver);
        validationObj = new ValidationPage(driver);
    }

    @Test
    public void userInvalidLogin (){
        homeObj.clickOnMyAccountButton()
                .clickOnLoginButton();
        loginObj.InvalidUserLogin(invalidEmail, invalidPassword);
        Assert.assertEquals(validationObj.getInvalidLoginErrorMessageText(), "Warning: No match for E-Mail Address and/or Password.");
    }
}
