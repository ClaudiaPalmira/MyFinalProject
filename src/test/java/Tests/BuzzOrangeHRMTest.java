package Tests;

import ObjectData.BuzzOrangeHRMObject;
import ObjectData.PIMOrangeHRMObject;
import PagesOrange.BuzzNewsfeedPage;
import ShareDataOrange.Hooks;
import SidePanelPages.BuzzPage;
import PagesOrange.LoginPage;
import ShareDataOrange.ShareData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;

public class BuzzOrangeHRMTest extends Hooks {

    @Test

    public void buzzMethod(){

        //test care permite in sectiunea Buzz publicarea unui mesaj in Buzz Newsfeed

        String usernameOrangevalue = "Admin";
        String passwordOrangevalue = "admin123";
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.fillLoginpageOrange(usernameOrangevalue,passwordOrangevalue);

        BuzzOrangeHRMObject buzzOrangeHRMObject = new BuzzOrangeHRMObject(testdata);

        BuzzPage buzzPage = new BuzzPage(getDriver());
        buzzPage.clickBuzzPage();

        BuzzNewsfeedPage buzzNewsfeedPage = new BuzzNewsfeedPage(getDriver());
        buzzNewsfeedPage.fillBuzzFeed(buzzOrangeHRMObject);


        getDriver().navigate().refresh();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

        WebElement postedBuzz = getDriver().findElement(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-buzz-post-body-text' and text()='Hello world!']"));
        if(postedBuzz.isDisplayed()){
            System.out.println("SUCCESS! The posted content is displayed!");
        }
        else{
            System.out.println("FAIL! The posted content is not displayed!");
        }
    }

}
