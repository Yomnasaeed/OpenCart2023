package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.List;

public class PhonesPage extends PageBase {
    public PhonesPage(WebDriver driver) {
        super(driver);
    }

    private static final By sortList = By.id("input-sort");
    public List<String> ExpectedAlphabeticalOrder;
    public List<String> ActualAlphabeticalOrder;


    public void sortByName() {
        ExpectedAlphabeticalOrder = new ArrayList<>();
        ExpectedAlphabeticalOrder.add("HTC Touch HD");
        ExpectedAlphabeticalOrder.add("iPhone");
        ExpectedAlphabeticalOrder.add("Palm Treo Pro");
        System.out.println("Expected listing: "+ExpectedAlphabeticalOrder);

        Select sort = new Select(driver.findElement(sortList));
        sort.selectByVisibleText("Name (A - Z)");

        List<WebElement> orderedPhones = driver.findElements(By.tagName("h4"));

        ActualAlphabeticalOrder  = new ArrayList<>();

        for (WebElement phone : orderedPhones) {
            ActualAlphabeticalOrder.add(phone.getText());
        }
        System.out.println("Actual listing after sorting in the website: "+ActualAlphabeticalOrder);
    }


}