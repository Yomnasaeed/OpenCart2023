package base;

import utilities.LoadProperties;
import utilities.Reporter;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PageBase {
    public WebDriver driver;
    static int executionSpeed = Integer.parseInt(LoadProperties.environmentData.getProperty("ExecutionSpeed"));

    //Super constructor
    protected PageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickButton(By button) {
        waitUntilElementIsClickable(button);
        System.out.println("Clicked on button [ " + button + " ] successfully");
        holdScript(executionSpeed);
        driver.findElement(button).click();
    }

    public void typeTextInField(By txtField, String txtValue) {
        elementVisible(txtField);
        holdScript(executionSpeed);
        driver.findElement(txtField).clear();
        holdScript(executionSpeed);
        driver.findElement(txtField).sendKeys(txtValue);
        System.out.println("Inserted [ " + txtValue + " ] successfully");
    }

    public boolean waitUntilElementIsClickable(By element) {
        return waitFor(ExpectedConditions.elementToBeClickable(element), Duration.ofSeconds(15));
    }

    public boolean elementVisible(By locator) {
        return waitFor(ExpectedConditions.visibilityOfElementLocated(locator), Duration.ofSeconds(15));
    }

    public String getElementText(By locator){
        elementVisible(locator);
        return driver.findElement(locator).getText();
    }


    public boolean waitFor(ExpectedCondition<?> expectedCondition, Duration duration) {
        try {
            FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                    .withTimeout(duration)
                    .pollingEvery(Duration.ofMillis(500))
                    .ignoring(NoSuchElementException.class);
            fluentWait.until(expectedCondition);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Method to make the page holds till it loads
     * @param driver	Select WebDriver driver
     * @param timeout select the time needed to make script waits
     */
    public void waitForPageLoad(WebDriver driver, int timeout) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
    }

    /**
     * Method to simulate the Thread.sleep
     * @param milliSeconds insert the required time to make script sleeps
     */
    public void holdScript(Integer milliSeconds) {
        long secondsLong = (long) milliSeconds;
        try {
            Thread.sleep(secondsLong);
        } catch (Exception e) {
            Reporter.Log(e.toString());
        }
    }
}
