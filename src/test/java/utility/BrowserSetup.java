package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;

public class BrowserSetup {

    public static WebDriver setupBrowser(WebDriver driver, String browserName, String appURL, Boolean NoBrowser,
                                         Boolean Incognito) {

        if(browserName.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
            ChromeOptions chromeOption = new ChromeOptions();
            if (NoBrowser == true) chromeOption.addArguments("--headless");
            if (Incognito == true) chromeOption.addArguments("--incognito");
            driver = new ChromeDriver(chromeOption);
        }
        else if(browserName.equalsIgnoreCase("edge")){
            System.setProperty("webdriver.edge.driver","./Drivers/msedgedriver.exe");
            EdgeOptions edgeOption = new EdgeOptions();
            if(NoBrowser==true) edgeOption.addArguments("--headless");
            if(Incognito==true) edgeOption.addArguments("--incognito");
            driver = new EdgeDriver(edgeOption);
        }
        driver.manage().window().maximize();
        driver.get(appURL);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

        return driver;

    }

    public static void quitBrowser(WebDriver driver){
        driver.quit();
    }


}
