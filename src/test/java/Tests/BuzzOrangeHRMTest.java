package Tests;

import PagesOrange.BuzzNewsfeedPage;
import SidePanelPages.BuzzPage;
import PagesOrange.HomePage;
import ShareDataOrange.ShareData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class BuzzOrangeHRMTest extends ShareData {

    @Test

    public void buzzMethod(){

        //test care permite in sectiunea Buzz publicarea unui mesaj in Buzz Newsfeed

        String usernameOrangevalue = "Admin";
        String passwordOrangevalue = "admin123";
        HomePage homePage = new HomePage(getDriver());
        homePage.fillHomepageOrange(usernameOrangevalue,passwordOrangevalue);

        BuzzPage buzzPage = new BuzzPage(getDriver());
        buzzPage.clickBuzzPage();

//      WebElement buzzOrange = driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name' and text()='Buzz']"));
//      buzzOrange.click();

//         WebElement buzzFeed = driver.findElement(By.xpath("//div[@class='oxd-buzz-post oxd-buzz-post--active']"));
//         am cautat eroare si nu ma lasa sa atribui text fiindca cautam dupa "div", astfel am cautat un alt approach de identificare a elementului


        BuzzNewsfeedPage buzzNewsfeedPage = new BuzzNewsfeedPage(getDriver());
        String buzzFeedValue = "Hello world!";
        buzzNewsfeedPage.fillBuzzFeed(buzzFeedValue);

//        WebElement buzzFeed = driver.findElement(By.xpath("//textarea[@class='oxd-buzz-post-input']"));
//        buzzFeed.click();
//        String buzzFeedValue = "Hello world!";
//        buzzFeed.sendKeys(buzzFeedValue);
//        WebElement submitBuzz = driver.findElement(By.xpath("//button[@type='submit']"));
//        submitBuzz.click();

        //validam testul de buzzfeed

        WebElement postedBuzz = getDriver().findElement(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-buzz-post-body-text' and text()='Hello world!']"));
        if(postedBuzz.isDisplayed()){
            System.out.println("SUCCESS! The posted content " + buzzFeedValue + " is displayed!");
        }
        else{
            System.out.println("FAIL! The posted content is not displayed!");
        }

    }
}
