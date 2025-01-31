package page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.Helper;

import java.time.Duration;

public class LoginPage {

    @FindBy(id="email") WebElement username_txt;
    @FindBy(id="password") WebElement password_txt;

    @FindBy(id="submit") WebElement login_btn;


    public void login(String username, String password) {
        username_txt.sendKeys(username);
        password_txt.sendKeys(password);
        login_btn.click();
        Helper.implicitWait(10);
        try {
            Thread.sleep(Duration.ofSeconds(5));
        }
        catch(Exception e){

        }
    }

}
