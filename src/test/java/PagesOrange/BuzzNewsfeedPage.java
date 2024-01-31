package PagesOrange;

import Logger.LoggerUtility;
import ObjectData.BuzzOrangeHRMObject;
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


    public void fillBuzzFeed(BuzzOrangeHRMObject buzzOrangeHRMObject){
        fieldBuzzFeed(buzzOrangeHRMObject.getBuzzFeedValue());
        submitBuzzfield();

    }

    public void fieldBuzzFeed(String buzzFeedValue){

        elementMethods.clickElement(buzzFeed);
//        buzzFeed.click();
        LoggerUtility.info("The user clicks on buzzFeed field.");

        elementMethods.fillElement(buzzFeed, buzzFeedValue);
//        buzzFeed.sendKeys(buzzFeedValue);
        LoggerUtility.info("The user fills the buzzFeed field.");
    }

    public void submitBuzzfield(){

        elementMethods.clickElement(submitBuzz);
//        submitBuzz.click();
        LoggerUtility.info("The user clicks on submitBuzz field.");

    }


}
