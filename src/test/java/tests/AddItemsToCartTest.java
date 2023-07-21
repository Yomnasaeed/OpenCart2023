package tests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utilities.LoadProperties;

public class AddItemsToCartTest extends TestBase {

    HomePage homeObj;
    TabletsPage tabletsObj;
    ShoppingCartPage cartObj;
    ValidationPage validationObj;
    LaptopsPage laptopObj;
    ProductDetailsPage productsObj;
    ShoppingCartPage shoppingObj;
    String hpDeliveryDate = LoadProperties.productDetailsInShoppingCart.getProperty("hpDeliveryDate");
    String totalPrice = LoadProperties.productDetailsInShoppingCart.getProperty("totalPrice");


    @BeforeMethod
    public void beforeMethod(){
        homeObj = new HomePage(driver);
        tabletsObj = new TabletsPage(driver);
        cartObj = new ShoppingCartPage(driver);
        validationObj = new ValidationPage(driver);
        laptopObj = new LaptopsPage(driver);
        productsObj = new ProductDetailsPage(driver);
    }

    @Test
    public void addItemsToCart() {
        homeObj.openShoppingList();
        homeObj.removeProductsInCart();
        homeObj.openTabletsPage();
        tabletsObj.addTabletToCart();
        Assert.assertTrue(validationObj.getAddedToCartSuccessMsgText().contains("Success"));
        homeObj.openShoppingList();
        homeObj.clickViewCart();
        cartObj.productsTableDetails();
        //here I made the assertions through extracting the data I want to assert on by the for loop
        Assert.assertTrue(cartObj.SamsungPrice.contains("$199.99"));
        Assert.assertTrue(cartObj.Samsung.contains("Samsung Galaxy Tab 10.1 ***"));
        homeObj.openLaptopsPage();
        laptopObj.addHPToCart();
        productsObj.addHPLaptopToCart();
        homeObj.openShoppingList();
        homeObj.clickViewCart();
        //The next step is used only to print the HP Delivery date in the console
        cartObj.productsTableDetails();
        //Here I made the assertions by locating the elements from the webtable in the validation page
        Assert.assertTrue(validationObj.getHpDeliveryDate().contains(hpDeliveryDate));
        Assert.assertEquals(validationObj.getTotalPrice(),totalPrice);
    }
}
