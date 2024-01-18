package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class BuzzOrangeHRMTest {
    public WebDriver driver;

    @Test

    public void buzzMethod(){

        //test care permite in sectiunea Buzz publicarea unui mesaj in Buzz Newsfeed

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

        //Partea de sus trebuie sa o scurtez astfel incat sa apelez metoda de log in fara sa o scriu aici


        WebElement buzzOrange = driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name' and text()='Buzz']"));
        buzzOrange.click();

//        WebElement buzzFeed = driver.findElement(By.xpath("//div[@class='oxd-buzz-post oxd-buzz-post--active']"));
        // am cautat eroare si nu ma lasa sa atribui text fiindca cautam dupa "div", astfel am cautat un alt approach de identificare a elementului
        WebElement buzzFeed = driver.findElement(By.xpath("//textarea[@class='oxd-buzz-post-input']"));
        buzzFeed.click();
        String buzzFeedValue = "Hello world!";
        buzzFeed.sendKeys(buzzFeedValue);

        WebElement submitBuzz = driver.findElement(By.xpath("//button[@type='submit']"));
        submitBuzz.click();

        //validam testul de buzzfeed

        WebElement postedBuzz = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-buzz-post-body-text' and text()='Hello world!']"));
        if(postedBuzz.isDisplayed()){
            System.out.println("SUCCESS! The posted content " + buzzFeedValue + " is displayed!");
        }
        else{
            System.out.println("FAIL! The posted content is not displayed!");
        }
        driver.quit();


    }
}
