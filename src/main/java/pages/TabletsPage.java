package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TabletsPage extends PageBase {
    public TabletsPage(WebDriver driver) {
        super(driver);
    }

    private static final By GalaxyTab = By.xpath("//a[text()='Samsung Galaxy Tab 10.1']");
    private static final By AddToCartBtn = By.xpath("//div[@class='button-group']/button[@type='button'][1]");

    public ShoppingCartPage addTabletToCart(){
        clickButton(AddToCartBtn);
        return new ShoppingCartPage(driver);
    }
}
