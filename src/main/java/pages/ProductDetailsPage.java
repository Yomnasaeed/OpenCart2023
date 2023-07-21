package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends PageBase {
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    private static final By hpLaptopAddToCart = By.id("button-cart");
    private static final By deliveryDateList = By.xpath("//*[@type='text' and @name='option[225]']");

    public ProductDetailsPage addHPLaptopToCart(){
        typeTextInField(deliveryDateList, "2015-03-04");
        clickButton(hpLaptopAddToCart);

        return this;
    }
}
