package utility;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import page_objects.AddContactPage;
import page_objects.ContactListPage;
import page_objects.LoginPage;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class BaseClass {

    public static WebDriver driver;
    public static ConfigReader config;  //static, because we are running parallel testing
    public ExcelReader excel;
    public LoginPage lp;
    public AddContactPage acp;
    public ContactListPage clp;


    @BeforeTest
    public void setup(){
        config = new ConfigReader();
        excel = new ExcelReader();
    }


    //For cross-browser
    @BeforeClass
    @Parameters("browser")
    public void launchBrowser(String browser){
        driver = BrowserSetup.setupBrowser(driver, browser, config.readPropFile("ST_URL"),
                false, true);
    }

    //for cross platform Testing - Selenium Grid
/*
    @BeforeClass
    @Parameters({"hubAddress","platform","browser", "version"})
    public void browser_launch(String hubAddress,String platform, String browser, String version) throws MalformedURLException, URISyntaxException {

        DesiredCapabilities dc = new DesiredCapabilities();

        if (platform.equalsIgnoreCase("Windows"))
            dc.setPlatform(org.openqa.selenium.Platform.WIN11);
        if (platform.equalsIgnoreCase("Linux"))
            dc.setPlatform(org.openqa.selenium.Platform.LINUX);
        if (platform.equalsIgnoreCase("ANY"))
            dc.setPlatform(org.openqa.selenium.Platform.ANY);

        if(browser.equalsIgnoreCase("Firefox"))  {
            FirefoxOptions options = new FirefoxOptions();
            dc.setCapability(CapabilityType.BROWSER_NAME, "firefox");
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//			options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
            options=options.merge(dc);
            driver = new RemoteWebDriver(new URI(hubAddress).toURL(), options);
        }
        else if(browser.equalsIgnoreCase("Chrome"))  {
            ChromeOptions options = new ChromeOptions();
            dc.setCapability(CapabilityType.BROWSER_NAME, "chrome");
//			options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            options=options.merge(dc);
            driver = new RemoteWebDriver(new URI(hubAddress).toURL(), options);
        }
        else if(browser.equalsIgnoreCase("MicrosoftEdge"))  {
            EdgeOptions options = new EdgeOptions();
            dc.setCapability(CapabilityType.BROWSER_NAME, "MicrosoftEdge");
//			options.setBinary("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            options=options.merge(dc);
            driver = new RemoteWebDriver(new URI(hubAddress).toURL(), options);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
        System.out.println(((RemoteWebDriver)driver).getSessionId());
    }

*/
    @AfterClass
    public void browser_termination(){
        //BrowserSetup.quitBrowser(driver);
    }
}
