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

    @Test(priority = 0)
    public void invalidRegWithFirstAndLastName () throws InterruptedException {
        homeObject = new HomePage(driver);
        homeObject.clickOnRegisterBtn();
        registerObj = new RegistrationPage(driver);
        registerObj.InvalidRegistrationWithFN_LN(fn, ln);
        registerObj.clickOnContinue();
        Assert.assertTrue(driver.findElement(registerObj.EMAILVALIDATION_ERROR).isDisplayed());
        Assert.assertTrue(driver.findElement(registerObj.TELVALIDATION_ERROR).isDisplayed());
        Assert.assertTrue(driver.findElement(registerObj.PASSWORDVALIDATIO_ERROR).isDisplayed());
    }

    @Test(priority = 1)
    public void invalidRegWithNoPassword () throws InterruptedException {
        homeObject = new HomePage(driver);
        homeObject.clickOnRegisterBtn();
        registerObj = new RegistrationPage(driver);
        registerObj.InvalidRegistrationWithFN_LN(fn, ln);
        registerObj.InvalidRegWithNoPassword(email, tel);
        registerObj.clickOnContinue();
        Assert.assertTrue(driver.findElement(registerObj.PASSWORDVALIDATIO_ERROR).isDisplayed());
    }

    @Test(priority = 2)
    public void invalidRegWithLessThan4Password () throws InterruptedException {
        homeObject = new HomePage(driver);
        homeObject.clickOnRegisterBtn();
        registerObj = new RegistrationPage(driver);
        registerObj.InvalidRegistrationWithFN_LN(fn, ln);
        registerObj.InvalidRegWithNoPassword(email, tel);
        registerObj.InvalidRegLessThan4Password(invalidPassword);
        Assert.assertTrue(driver.findElement(registerObj.PASSWORDVALIDATIO_ERROR).isDisplayed());
    }
}
