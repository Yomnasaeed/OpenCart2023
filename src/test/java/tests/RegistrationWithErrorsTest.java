package tests;

import base.TestBase;
import com.github.javafaker.Faker;
import dataReaders.loadPropertiesFiles;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;

public class RegistrationWithErrorsTest extends TestBase {

    HomePage homeObject;
    RegistrationPage registerObj;
    String fn = loadPropertiesFiles.userData.getProperty("firstName");
    String ln = loadPropertiesFiles.userData.getProperty("lastName");
    Faker fakeData = new Faker();
    String email = fakeData.internet().emailAddress();
    String tel = loadPropertiesFiles.userData.getProperty("telephone");
    String invalidPassword = loadPropertiesFiles.userData.getProperty("inValidPassword");

    @Test
    public void invalidRegistration () throws InterruptedException {
        homeObject = new HomePage(driver);
        homeObject.clickOnRegisterBtn();
        registerObj = new RegistrationPage(driver);
        registerObj.InvalidRegistrationWithFN_LN(fn, ln);
        Assert.assertTrue(driver.findElement(registerObj.emailValidation_error).isDisplayed());
        Assert.assertTrue(driver.findElement(registerObj.telValidation_error).isDisplayed());
        Assert.assertTrue(driver.findElement(registerObj.passwordValidation_error).isDisplayed());
        registerObj.InvalidRegWithNoPassword(fn, ln, email, tel);
        Assert.assertTrue(driver.findElement(registerObj.passwordValidation_error).isDisplayed());
        registerObj.InvalidRegLessThan4Password(fn,ln,email,tel,invalidPassword);
        Assert.assertTrue(driver.findElement(registerObj.passwordValidation_error).isDisplayed());
    }
}
