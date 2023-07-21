package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LaptopsPage extends PageBase {
    public LaptopsPage(WebDriver driver) {
        super(driver);
    }

    private static final By HP_LP3065AddToCartBtn = By.xpath("//*[@class='button-group'][1]//descendant::button[1]");

    public void addHPToCart(){
        clickButton(HP_LP3065AddToCartBtn);
    }
}
