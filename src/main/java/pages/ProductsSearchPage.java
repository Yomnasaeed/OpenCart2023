package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProductsSearchPage extends PageBase {
    public ProductsSearchPage(WebDriver driver) {
        super(driver);
    }

    private static final By searchBox =By.id("input-search");
//    private static final By categoriesDropDown =By.xpath("//select[@name='category_id' and @class='form-control']");
    private static final By subcategoriesCheckBox =By.xpath("//input[@name='sub_category' and @type='checkbox']");
    private static final By searchBtn =By.id("button-search");



    public ProductsSearchPage searchForApple(){
        typeTextInField(searchBox, "Apple");
        WebElement categoriesDropDown = driver.findElement(By.xpath("//select[@name='category_id' and @class='form-control']"));
        Select categoriesList = new Select(categoriesDropDown);
        categoriesList.selectByVisibleText("Components");
        clickButton(subcategoriesCheckBox);
        clickButton(searchBtn);

        return this;
    }

}
