package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import page_objects.LoginPage;
import utility.BaseClass;

public class Login_Test extends BaseClass {

    @Test(groups = {"regression"})
    public void login_test() {
        lp = PageFactory.initElements(driver, LoginPage.class);
        lp.login((excel.getStringValue("login_details",1,0)),
                excel.getStringValue("login_details",1,1));
    }

}
