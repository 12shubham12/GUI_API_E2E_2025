package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import page_objects.AddContactPage;
import page_objects.ContactListPage;
import page_objects.LoginPage;
import utility.BaseClass;
import utility.Helper;

public class LoginAndLogout extends BaseClass {

    @Test(priority = 1, groups = "smoke")
    public void login_test() {
        lp = PageFactory.initElements(driver, LoginPage.class);
        lp.login((excel.getStringValue("login_details",1,0)),
                excel.getStringValue("login_details",1,1));
        Helper.timeouts(5);
    }

    @Test(priority = 2, groups={"smoke"}, dependsOnMethods={"login_test"})
    public void logout_test(){
        clp = PageFactory.initElements(driver, ContactListPage.class);
        clp.logoutUser();
    }
}
