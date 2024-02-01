package ShareDataOrange.Browser;

import Logger.LoggerUtility;
import PropertyUtility.PropertyUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;
import java.util.HashMap;

public class EdgeBrowserService extends BaseBrowserService implements BrowserService{

    private WebDriver driver;
    @Override
    public void openBrowser(Boolean cicd) {

        EdgeOptions edgeOptions = (EdgeOptions) prepareBrowserOptions(cicd);
        driver = new EdgeDriver(edgeOptions);
        driver.get(getBrowserOptions().get("url"));
//        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        LoggerUtility.info("The browser was opened with success!");

    }

    @Override
    public void closeBrowser() {

        driver.quit();
        LoggerUtility.info("The browser was closed with success!");

    }

    @Override
    public Object prepareBrowserOptions(Boolean cicd) {

        HashMap<String, String> testData = getBrowserOptions();
        EdgeOptions edgeOptions = new EdgeOptions();
        if(cicd){
            edgeOptions.addArguments("--headless");
        }
        if(!testData.get("headless").isEmpty()) {
            edgeOptions.addArguments(testData.get("headless"));
        }
        edgeOptions.addArguments(testData.get("gpu"));
        edgeOptions.addArguments(testData.get("infobars"));
        edgeOptions.addArguments(testData.get("sandbox"));
        edgeOptions.addArguments(testData.get("resolution"));

        return edgeOptions;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
