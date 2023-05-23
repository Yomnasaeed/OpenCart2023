package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShoppingCartPage extends PageBase {
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    private static final By tableOfProducts =By.xpath("//*[@id=\"content\"]/form/div/table");


    //table[@class='table table-bordered'][1]

    public ShoppingCartPage productsTableDetails(){

        WebElement productsTable = driver.findElement(tableOfProducts);

        List<WebElement> rows = productsTable.findElements(By.tagName("tr"));
        for (WebElement row:rows){
            List<WebElement> cols = row.findElements(By.tagName("td"));
            for (WebElement col : cols){
                System.out.println(col.getText());
                if(col.getText().contains("Samsung Galaxy Tab 10.1 ***"))
                    break;
            }
        }
        return this;
    }
}
