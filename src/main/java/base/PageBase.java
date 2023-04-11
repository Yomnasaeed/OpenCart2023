package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PageBase {
    public WebDriver driver;
    public static WebDriverWait wait;

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButton(By button) {
        waitUntilElementIsClickable(button);
        System.out.println("Clicked on button [" + button + " ] successfully");
        driver.findElement(button).click();
    }

    public void typeTextInField(By txtField, String txtValue) {
        waitUntilElementIsDisplayed(txtField);
        driver.findElement(txtField).clear();
        driver.findElement(txtField).sendKeys(txtValue);
        System.out.println("Inserted [" + txtValue + " ] successfully");
    }

    private void waitUntilElementIsClickable(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    private void waitUntilElementIsDisplayed(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }


}
