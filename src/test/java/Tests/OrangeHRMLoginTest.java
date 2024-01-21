package Tests;

import PagesOrange.HomePage;
import ShareDataOrange.ShareData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class OrangeHRMLoginTest extends ShareData {

    @Test

    public void loginMethod(){

        //test care permite logarea pe site-ul https://opensource-demo.orangehrmlive.com cu anumite credentiale

        String usernameOrangevalue = "Admin";
        String passwordOrangevalue = "admin123";
        HomePage homePage = new HomePage(driver);
        homePage.fillHomepageOrange(usernameOrangevalue,passwordOrangevalue);

//        WebElement usernameOrange = driver.findElement(By.xpath("//input[@name='username']"));
//        String usernameOrangevalue = "Admin";
//        usernameOrange.sendKeys(usernameOrangevalue);
//
//        WebElement passwordOrange = driver.findElement(By.xpath("//input[@name='password']"));
//        String passwordOrangevalue = "admin123";
//        passwordOrange.sendKeys(passwordOrangevalue);

//        WebElement submitOrange = driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button' and @type='submit']"));
//        submitOrange.click();

        //validam testul de login

        WebElement dashboardHeader = driver.findElement(By.xpath("//div[@class='oxd-topbar-header-title']"));
        if (dashboardHeader.isDisplayed()){
            System.out.println("The login was successful! The dashboard is visible");
        }
        else {
            System.out.println("The login was not successful! The dashboard is not visible");
        }

    }
}
