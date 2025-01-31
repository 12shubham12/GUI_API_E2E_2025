package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import page_objects.AddContactPage;
import page_objects.ContactListPage;
import page_objects.LoginPage;
import utility.BaseClass;
import utility.Helper;

import java.time.Duration;

public class Login_AddContact extends BaseClass{


    @Test(priority = 1, groups = {"smoke","regression"})
    public void login_test() {
        lp = PageFactory.initElements(driver, LoginPage.class);
        lp.login((excel.getStringValue("login_details",1,0)),
                excel.getStringValue("login_details",1,1));
        Helper.timeouts(3);
    }
    @Test(priority = 2, groups = {"regression", "smoke"}, dependsOnMethods={"login_test"})
    public void addContact_test(){
        clp = PageFactory.initElements(driver, ContactListPage.class);
        clp.addContactButtonClick();
        acp = PageFactory.initElements(driver, AddContactPage.class);
        acp.addContact("aa", "bb", "abc", String.valueOf("9999999999"));
    }

}
