package page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class ContactListPage {

    @FindBy(id="add-contact") WebElement addContact_btn;
    @FindBy(id="logout") WebElement logout_btn;

    public void addContactButtonClick(){
        addContact_btn.click();
    }

    public void logoutUser(){
        logout_btn.click();
    }
}
