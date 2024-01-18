package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class OrangeHRMLoginTest {

    public WebDriver driver;

    @Test

    public void loginMethod(){

        //test care permite logarea pe site-ul https://opensource-demo.orangehrmlive.com cu anumite credentiale

        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement usernameOrange = driver.findElement(By.xpath("//input[@name='username']"));
        String usernameOrangevalue = "Admin";
        usernameOrange.sendKeys(usernameOrangevalue);

        WebElement passwordOrange = driver.findElement(By.xpath("//input[@name='password']"));
        String passwordOrangevalue = "admin123";
        passwordOrange.sendKeys(passwordOrangevalue);

        WebElement submitOrange = driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button' and @type='submit']"));
        submitOrange.click();

        //validam testul de login

        WebElement dashboardHeader = driver.findElement(By.xpath("//div[@class='oxd-topbar-header-title']"));
        if (dashboardHeader.isDisplayed()){
            System.out.println("The login was successful! The dashboard is visible");
        }
        else {
            System.out.println("The login was not successful! The dashboard is not visible");
        }

        driver.quit();

    }
}
