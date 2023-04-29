package tests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.PhonesPage;

public class SortByNameTest extends TestBase {

    private HomePage homeObj;
    private PhonesPage phoneObj;

    @BeforeMethod
    public void beforeMethod(){
        homeObj = new HomePage(driver);
        phoneObj = new PhonesPage(driver);
    }

    @Test
    public void sortByName(){
        homeObj.openPhonesPage();
        phoneObj.sortByName();
        Assert.assertEquals(phoneObj.ActualAlphabeticalOrder.toString(), phoneObj.ExpectedAlphabeticalOrder.toString());

    }
}
