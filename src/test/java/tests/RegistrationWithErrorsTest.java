package tests;

import base.TestBase;
import pages.HomePage;
import pages.RegistrationPage;
import pages.ValidationPage;
import utilities.LoadProperties;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

public class RegistrationWithErrorsTest extends TestBase {

    HomePage homePageObj;
    RegistrationPage registrationPageObj;
    ValidationPage validationPageObj;
    String fn = LoadProperties.userData.getProperty("firstName");
    String ln = LoadProperties.userData.getProperty("lastName");
    Faker fakeData = new Faker();
    String email = fakeData.internet().emailAddress();
    String tel = LoadProperties.userData.getProperty("telephone");
    String invalidPassword = LoadProperties.userData.getProperty("inValidPassword");
    @BeforeMethod
    public void beforeTest() {
        homePageObj = new HomePage(driver);
        registrationPageObj = new RegistrationPage(driver);
        validationPageObj = new ValidationPage(driver);
    }
    @Test(priority = 1)
    public void invalidRegWithFirstAndLastName () throws InterruptedException {
        homePageObj.clickOnRegisterBtn()
                .InvalidRegistrationWithFirstNameLastName(fn, ln)
                .clickOnContinue();

        Assert.assertTrue(validationPageObj.isEmailValidationMessageDisplayed(),"Email Validation message was not displayed");
        Assert.assertTrue(validationPageObj.isTileValidationErrorDisplayed(),"Tile Validation Error was not displayed");
        Assert.assertTrue(validationPageObj.isPasswordValidationErrorDisplayed(),"Password Validation Error was not displayed");
    }

    @Test(priority = 2)
    public void invalidRegWithNoPassword () throws InterruptedException {
        homePageObj.clickOnRegisterBtn()
                .InvalidRegistrationWithFirstNameLastName(fn, ln)
                .InvalidRegWithNoPassword(email, tel)
                .clickOnContinue();

        Assert.assertTrue(validationPageObj.isPasswordValidationErrorDisplayed(),"Password Validation Error was not displayed");
    }

    @Test(priority = 3)
    public void invalidRegWithLessThan4Password () {
        homePageObj.clickOnRegisterBtn()
                .InvalidRegistrationWithFirstNameLastName(fn, ln)
                .InvalidRegWithNoPassword(email, tel)
                .InvalidRegLessThan4Password(invalidPassword);

        Assert.assertTrue(validationPageObj.isPasswordValidationErrorDisplayed(),"Password Validation Error was not displayed");
    }
}
