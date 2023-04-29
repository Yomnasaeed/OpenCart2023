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

import static org.testng.Assert.assertTrue;

public class RegistrationWithoutErrorsTest extends TestBase {

    private HomePage homeObject;
    private RegistrationPage registerObj;
    private ValidationPage validationPageObj;

    String fn = LoadProperties.userData.getProperty("firstName");
    String ln = LoadProperties.userData.getProperty("lastName");
    Faker fakeData = new Faker();
    String email = fakeData.internet().emailAddress();
    String tel = LoadProperties.userData.getProperty("telephone");
    String password = LoadProperties.userData.getProperty("password");

    @BeforeMethod
    public void beforeTest() {
        homeObject = new HomePage(driver);
        registerObj = new RegistrationPage(driver);
        validationPageObj = new ValidationPage(driver);
    }

    @Test(priority = 0)
    public void RegistrationWithoutErrors() {
        homeObject.clickOnRegisterBtn()
                .validRegistration(fn, ln, email, tel, password);

        assertTrue(validationPageObj.getRegistrationSuccessMsg(),"Registration message was not displayed");
    }

    @Test(dependsOnMethods = "RegistrationWithoutErrors")
    public void logout() {
        homeObject.clickOnMyAccountButton();
        assertTrue(homeObject.getLogoutBtn(),"logout button wasn't displayed");
        registerObj.clickOnLogout();
    }
}
