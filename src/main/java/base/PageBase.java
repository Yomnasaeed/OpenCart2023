package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
    public WebDriver driver;
    public static WebDriverWait wait;

    public PageBase(WebDriver driver){
        this.driver = driver;
    }

    public void clickButton(By button){
        driver.findElement(button).click();
    }

        public void typeTextInField (By txtField, String txtValue){
            driver.findElement(txtField).clear();
            driver.findElement(txtField).sendKeys(txtValue);

    }

    public void waitUntilElementIsClickable (By element){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public void waitUntilElementIsDisplayed (By element){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }




}
