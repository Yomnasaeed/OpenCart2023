package tests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductsSearchPage;
import pages.ValidationPage;

public class SearchInSubcategoriesTest extends TestBase {

    HomePage homeObj;
    ProductsSearchPage productObj;
    ValidationPage validationObj;

    @BeforeMethod
    public void beforeMethod(){
        homeObj = new HomePage(driver);
        productObj = new ProductsSearchPage(driver);
        validationObj = new ValidationPage(driver);
    }

    @Test
    public void searchInSubCategories(){
        homeObj.clickOnSearch();
        productObj.searchForApple();
        Assert.assertTrue(validationObj.isAppleCinemaDisplayed(), "Cannot find Apple cinema");
    }
}
