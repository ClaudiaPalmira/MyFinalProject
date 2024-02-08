package ShareDataOrange;

import Logger.LoggerUtility;
import ShareDataOrange.Browser.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class ShareData {

    private WebDriver driver;
    public WebDriver getDriver() { //se afiseaza driverul dar NU mai permite modificarea driver-ului, l-am facut privat
        return driver;
    }

    public void setUP(){

        driver = new BrowserFactory().getBrowserDriver();

    }
    public void clear(){
        driver.quit();
        LoggerUtility.info("The browser was closed with success!");
    }


}
