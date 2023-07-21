package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.LoadProperties;

import java.util.List;

public class ShoppingCartPage extends PageBase {
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    private static final By tableOfProducts = By.xpath("//*[@id=\"content\"]/form/div/table");
    public String Samsung;
    public String SamsungPrice;

    public ShoppingCartPage productsTableDetails(){

        WebElement productsTable = driver.findElement(tableOfProducts);

        List<WebElement> rows = productsTable.findElements(By.tagName("tr"));
        for (WebElement row:rows){
            List<WebElement> cols = row.findElements(By.tagName("td"));
            for (WebElement col : cols){
                if(col.getText().contains("Samsung Galaxy Tab 10.1 ***")){
                     Samsung = col.getText();
                    System.out.println("##"+Samsung);}
                if(col.getText().contains("$199.99")){
                    SamsungPrice = col.getText();
                    System.out.println("##"+SamsungPrice);}
                if(col.getText().contains("HP LP3065")){
                    WebElement deliveryDate = col.findElement(By.tagName("small"));
                    String hpDeliveryDate = deliveryDate.getText();
                    System.out.println("@@@"+hpDeliveryDate);}
            }

        }
        return this;
    }
}
