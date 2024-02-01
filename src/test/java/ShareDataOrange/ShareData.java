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

//        driver = new ChromeDriver();
//        driver.get("https://opensource-demo.orangehrmlive.com");
//        driver.manage().window().maximize();
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        LoggerUtility.info("The browser was opened with success!");
    }
    public void clear(){
        driver.quit();
        LoggerUtility.info("The browser was closed with success!");
    }


}
