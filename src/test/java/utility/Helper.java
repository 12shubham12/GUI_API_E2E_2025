package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Helper extends BaseClass{

    public static WebDriverWait wait;
    public static void pageLoadWait(int sec){
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(sec));
    }

    public static void implicitWait(int sec){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
    }

    public static void explicitWait(int sec, String xpath){
        wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public static void timeouts(int sec){
        try{
            Thread.sleep(Duration.ofSeconds(sec));
        }
        catch(Exception e){
            System.out.println("Interrupted Exception "+e.getMessage());
        }
    }

}
