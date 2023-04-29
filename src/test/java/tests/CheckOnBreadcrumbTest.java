package tests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ValidationPage;

public class CheckOnBreadcrumbTest extends TestBase {

    HomePage homeObj;
    ValidationPage validationObj;


    @BeforeMethod
    public void beforeTest (){
        homeObj = new HomePage(driver);
        validationObj = new ValidationPage(driver);
    }

    @Test
    public void tabletDisplayedInBreadCrumb(){
        homeObj.openTabletsPage();
        Assert.assertEquals(validationObj.getTabletsTextInBreadCrumb(), "Tablets");
        Assert.assertEquals(validationObj.getTabletsTextInLeftMenu(), "Tablets (1)");

    }
}
