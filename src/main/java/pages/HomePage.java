package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    By myAccount_btn = By.xpath("//span[@class='hidden-xs hidden-sm hidden-md' and contains(text(),'My Account')]");
    By register_btn = By.xpath("//*[contains(@href,'register')]");


    public void clickOnRegister() {

//        WebElement myAccountBtn = driver.findElement(myAccount_btn);
        clickButton(myAccount_btn);
        clickButton(register_btn);



    }


};


