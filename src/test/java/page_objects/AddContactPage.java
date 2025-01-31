package page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddContactPage {

    @FindBy(id="firstName") WebElement fname_txtbox;
    @FindBy(id="lastName") WebElement lname_txtbox;
    @FindBy(id="city") WebElement city_txtbox;
    @FindBy(id="phone") WebElement phone_txtbox;
    @FindBy(id="submit") WebElement submit_btn;
    @FindBy(id="cancel") WebElement cancel_btn;

    public void addContact(String fname, String lname, String city, String phone){
        fname_txtbox.sendKeys(fname);
        lname_txtbox.sendKeys(lname);
        city_txtbox.sendKeys(city);
        phone_txtbox.sendKeys(String.valueOf(phone));

        //clicking on Submit button
        submit_btn.click();
    }
}
