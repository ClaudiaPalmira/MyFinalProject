package PagesOrange;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuzzNewsfeedPage extends BasePage {

    public BuzzNewsfeedPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//textarea[@class='oxd-buzz-post-input']")
    private WebElement buzzFeed;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitBuzz;


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
