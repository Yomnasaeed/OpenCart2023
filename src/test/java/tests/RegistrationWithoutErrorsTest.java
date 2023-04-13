package tests;

import base.TestBase;
import com.github.javafaker.Faker;
import dataReaders.loadPropertiesFiles;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;

public class RegistrationWithoutErrorsTest extends TestBase {

    HomePage homeObject;
    RegistrationPage registerObj;
    String fn = loadPropertiesFiles.userData.getProperty("firstName");
    String ln = loadPropertiesFiles.userData.getProperty("lastName");
    Faker fakeData = new Faker();
    String email = fakeData.internet().emailAddress();
    String tel = loadPropertiesFiles.userData.getProperty("telephone");
    String password = loadPropertiesFiles.userData.getProperty("password");

    @Test (priority = 0)
    @Severity(SeverityLevel.BLOCKER)
    @Description("The user should be able to login successfully")
    public void RegistrationWithoutErrors() throws InterruptedException {
        homeObject = new HomePage(driver);
        homeObject.clickOnRegisterBtn();
        registerObj = new RegistrationPage(driver);
        registerObj.validRegistration(fn, ln, email, tel, password);
        Assert.assertTrue(driver.findElement(registerObj.congrats_Message).getText().contains("Your"));
//

    }

    @Test(priority = 1)
    @Severity(SeverityLevel.NORMAL)
    @Description("The user should be able to logout")
    public void logout() throws InterruptedException {
        registerObj = new RegistrationPage(driver);
        registerObj.openMyAccountMenu();
        Assert.assertTrue(driver.findElement(homeObject.logout_btn).isDisplayed());
        registerObj.clickOnLogout();
    }
}
