package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import pages.ValidationPage;
import utilities.LoadProperties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class TestBase {

    public static WebDriver driver;
    static String applicationURL = LoadProperties.environmentData.getProperty("URL");
    static String browserType = LoadProperties.environmentData.getProperty("BrowserType");
    String validEmail = LoadProperties.userData.getProperty("Email");
    String validPassword = LoadProperties.userData.getProperty("Password");


    public static ChromeOptions chromeOption() {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default.content_settings.popups", 0);
        options.setExperimentalOption("prefs", chromePrefs);
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        return options;
    }

    @BeforeClass
    public WebDriver startDriver() {


        if(browserType.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOption());
        }else if(browserType.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.navigate().to(applicationURL);

        System.out.println("Class name to start now: "+ this.getClass().getName());
        if(this.getClass().getName().contains("TestBase")
                ||this.getClass().getName().contains("RegistrationWithErrorsTest")
                ||this.getClass().getName().contains("RegistrationWithoutErrorsTest")
                ||this.getClass().getName().contains("ValidLoginTest")
                ||this.getClass().getName().contains("InvalidLoginTest")){
            System.out.println("No login required");
        }else{
            HomePage homePageObj = new HomePage(driver);
            LoginPage loginObj = new LoginPage(driver);
            homePageObj.clickOnMyAccountButton()
                    .clickOnLoginButton();
            loginObj.validUserLogin(validEmail,validPassword);

        }
        return driver;
    }


        @AfterClass
        public void closeDriver () {
            if(this.getClass().getName().contains("TestBase")
                    ||this.getClass().getName().contains("RegistrationWithErrorsTest")
                    ||this.getClass().getName().contains("RegistrationWithoutErrorsTest")
                    ||this.getClass().getName().contains("InvalidLoginTest")){
                System.out.println("No logout");
            }else{
                HomePage homePageObj = new HomePage(driver);
                homePageObj.userLogout();
            }
            driver.manage().deleteAllCookies();
            driver.quit();
        }


        @AfterMethod
        public void screenShotOnFailure (ITestResult result){
            if (ITestResult.FAILURE == result.getStatus()) {
                File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                String destination = System.getProperty("user.dir") + "./Screenshots/" + result.getName() + ".png";
                try {
                    FileUtils.copyFile(screenshotFile, new File(destination));
                } catch (IOException e) {
                    System.out.println("Cannot take screenshot: " + e);
                }
            }
        }
    }
