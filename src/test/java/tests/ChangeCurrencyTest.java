package tests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ValidationPage;

public class ChangeCurrencyTest extends TestBase {

    HomePage homeObj;
    ValidationPage validationPageObj;


    @BeforeMethod
    public void beforeTest (){
        homeObj = new HomePage(driver);
        validationPageObj = new ValidationPage(driver);
    }

    @Test
    public void changeCurrency (){
        homeObj.selectDesktopInEuro();
        Assert.assertTrue(validationPageObj.isEuroSignDisplayed());
    }
}
