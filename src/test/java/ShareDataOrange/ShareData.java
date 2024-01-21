package ShareDataOrange;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class ShareData {

    public WebDriver driver;

    @BeforeMethod

    public void setUP(){
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod
    public void clear(){
        driver.quit();
    }

}
