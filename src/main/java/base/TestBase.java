package base;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;

public class TestBase {

    public static WebDriver driver;

    @BeforeClass
    @Parameters({"browser"})
    public void startDriver(String browserName){
        if(browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if(browserName.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.navigate().to("http://opencart.abstracta.us/index.php?route=common/home");
        driver.manage().window().maximize();
    }


    @AfterClass
    public void closeDriver(){
    System.out.println();
        driver.quit();
    }

    @AfterMethod
    public void screenShotOnFailure(ITestResult result) {
        if(ITestResult.FAILURE == result.getStatus()){
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String destination = System.getProperty("user.dir")+"./Screenshots/"+result.getName()+".png";
            try {
                FileUtils.copyFile(screenshotFile, new File(destination));
            } catch (IOException e) {
                System.out.println("Cannot take screenshot: "+ e);
            }
        }
    }
}
