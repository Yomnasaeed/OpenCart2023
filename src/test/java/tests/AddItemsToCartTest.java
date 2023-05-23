package tests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ShoppingCartPage;
import pages.TabletsPage;
import pages.ValidationPage;

public class AddItemsToCartTest extends TestBase {

    HomePage homeObj;
    TabletsPage tabletsObj;
    ShoppingCartPage cartObj;
    ValidationPage validationObj;

    @BeforeMethod
    public void beforeMethod(){
        homeObj = new HomePage(driver);
        tabletsObj = new TabletsPage(driver);
        cartObj = new ShoppingCartPage(driver);
        validationObj = new ValidationPage(driver);
    }

    @Test
    public void addItemsToCart(){
        homeObj.openTabletsPage();
        tabletsObj.addTabletToCart();
        Assert.assertTrue(validationObj.getAddedToCartSuccessMsgText().contains("Success"));
        homeObj.openShoppingCart();
        cartObj.productsTableDetails();


    }
}
