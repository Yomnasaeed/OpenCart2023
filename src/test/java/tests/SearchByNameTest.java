package tests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.PhonesPage;
import utilities.LoadProperties;

public class SearchByNameTest extends TestBase {

    private  HomePage homeObj;
    String macProduct = LoadProperties.productsSearchData.getProperty("Mac");

    @BeforeMethod
    public void beforeMethod(){
        homeObj = new HomePage(driver);
    }


    @Test
    public void searchByNameForMac(){
        homeObj.searchForMac(macProduct);
        Assert.assertTrue(homeObj.MacListOfSearch.contains("MacBook"), "Cannot find Macbook");
    }
}
