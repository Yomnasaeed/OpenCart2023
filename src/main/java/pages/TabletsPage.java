package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TabletsPage extends PageBase {
    public TabletsPage(WebDriver driver) {
        super(driver);
    }

    private static final By TabletsBreadCrumb = By.className("breadcrumb");


    public void checkTabletBreadCrumb() {
        List<WebElement> tabletsBreadcrumb = driver.findElements(TabletsBreadCrumb);
        WebElement lastElement = tabletsBreadcrumb.get(tabletsBreadcrumb.size() - 1);
        System.out.println(lastElement.getText());
    }

}
