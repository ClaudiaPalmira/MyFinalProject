package PagesOrange;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuzzNewsfeedPage {

    public WebDriver driver;

    public BuzzNewsfeedPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//textarea[@class='oxd-buzz-post-input']")
    WebElement buzzFeed;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitBuzz;


    public void fillBuzzFeed(String buzzValue){
        fieldBuzzFeed(buzzValue);
        submitBuzzfield();

    }

    public void fieldBuzzFeed(String buzzFeedValue){
        buzzFeed.click();
        buzzFeed.sendKeys(buzzFeedValue);
    }

    public void submitBuzzfield(){
        submitBuzz.click();

    }


}
