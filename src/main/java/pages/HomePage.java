package pages;

import base.PageBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }

   private static final By MY_ACCOUNT_BTN = By.xpath("//span[@class='hidden-xs hidden-sm hidden-md' and contains(text(),'My Account')]");
    private static final By REGISTER_BTN = By.xpath("//*[contains(@href,'register')]");
    private static final By LOGOUT_BTN = By.xpath("//li/a[text()='Logout']");
    private static final By LOGIN_BTN = By.xpath("//*[contains(@href,'login') and text()='Login']");
    private static final By DESKTOP_LIST = By.xpath("//*[contains(@class,'dropdown-toggle') and text()='Desktops']");
    private static final By SHOWALLDESKTOPS_OPTION = By.xpath("//*[contains(@class,'see-all') and text()='Show All Desktops']");
    private static final By CURRENCY_LIST = By.xpath("//*[contains(@class,'hidden-xs') and text()='Currency']");
    private static final By EURO_OPTION = By.xpath("//*[contains(@class,'currency-select') and text()='€ Euro']");
    private static final By TABLET_LIST = By.xpath("//*[contains(@href,'http://opencart.abstracta.us:80/index.php?route=product/category&path=57') and text()='Tablets'][1]");
    private static final By PHONES_LIST = By.xpath("//*[contains(@href,'http://opencart.abstracta.us:80/index.php?route=product/category&path=24') and text()='Phones & PDAs']");
    private static final By SEARCH_BOX = By.className("form-control");
    private static final By SEARCH_BTN = By.className("btn-default");
    public List<String> MacListOfSearch;



    public HomePage makeSureYouAreInHomePage(){
        Assert.assertEquals("Locator of the header Your Store ","Your Store");
        return this;
    }

    public HomePage clickOnMyAccountButton(){
        clickButton(MY_ACCOUNT_BTN);
        return this;
    }

    public LoginPage clickOnLoginButton(){
        clickButton(LOGIN_BTN);
        return new LoginPage(driver);
    }

    public RegistrationPage clickOnRegisterBtn() {
        clickButton(MY_ACCOUNT_BTN);
        clickButton(REGISTER_BTN);
        return new RegistrationPage(driver);
    }

    public HomePage userLogout() {
        clickButton(MY_ACCOUNT_BTN);
        clickButton(LOGOUT_BTN);
        return this;
    }

    public HomePage selectDesktopInEuro(){
        clickButton(DESKTOP_LIST);
        clickButton(SHOWALLDESKTOPS_OPTION);
        clickButton(CURRENCY_LIST);
        clickButton(EURO_OPTION);

        return this;
    }

    public void openTabletsPage(){
        clickButton(TABLET_LIST);
    }

    public PhonesPage openPhonesPage(){
        clickButton(PHONES_LIST);
        return new PhonesPage(driver);
    }


    public ProductsSearchPage searchForMac(String productName){
        typeTextInField(SEARCH_BOX, productName);
        clickButton(SEARCH_BTN);

        List<WebElement> macList = driver.findElements(By.tagName("h4"));

        MacListOfSearch  = new ArrayList<>();

        for (WebElement mac : macList) {
            MacListOfSearch.add(mac.getText());
        }

        return new ProductsSearchPage(driver);
    }

    public ProductsSearchPage clickOnSearch(){
        clickButton(SEARCH_BTN);
        return new ProductsSearchPage(driver);
    }

    public boolean getLogoutBtn(){
        return elementVisible(LOGOUT_BTN);
    }
}


