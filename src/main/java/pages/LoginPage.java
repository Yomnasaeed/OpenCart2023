package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

   private static final By EMAIL_TXT = By.id("input-email");
   private static final By PASSWORD_TXT = By.id("input-password");
   private static final By LOGIN_Button = By.cssSelector("input.btn.btn-primary");

   public MyAccountPage validUserLogin (String ValidEmail, String ValidPassword){
       typeTextInField(EMAIL_TXT, ValidEmail);
       typeTextInField(PASSWORD_TXT, ValidPassword);
       clickButton(LOGIN_Button);
       return new MyAccountPage(driver);
   }

}
