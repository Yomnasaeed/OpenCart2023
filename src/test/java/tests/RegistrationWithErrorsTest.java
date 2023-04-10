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
    String tel = loadPropertiesFiles.userData.getProperty("telephone");
    String password = loadPropertiesFiles.userData.getProperty("password");

    @Test
    public void invalidRegistration () throws InterruptedException {
        homeObject = new HomePage(driver);
        homeObject.clickOnRegister();
        registerObj = new RegistrationPage(driver);
        registerObj.InvalidRegistration(fn, ln, tel, password);
        Assert.assertTrue(driver.findElement(registerObj.emailValidation_error).isDisplayed());
    }
}
