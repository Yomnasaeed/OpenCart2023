package base;


import dataReaders.loadPropertiesFiles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class TestBase {

    public static WebDriver driver;
    static String applicationURL = loadPropertiesFiles.URl.getProperty("URL");
    static String browserType = loadPropertiesFiles.URl.getProperty("BrowserType");

    public static ChromeOptions chromeOption() {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default.content_settings.popups", 0);
        options.setExperimentalOption("prefs", chromePrefs);
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        options.addArguments("--start-maximized");
//        options.addArguments("--incognito");
        return options;
    }
    @BeforeClass
    public void startDriver(){
        if(browserType.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOption());
        }else if(browserType.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.navigate().to(applicationURL);
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
