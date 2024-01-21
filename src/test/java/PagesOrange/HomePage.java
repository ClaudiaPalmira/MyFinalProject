package PagesOrange;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class HomePage {

    public WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//input[@name='username']")
    public WebElement usernameOrange;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordOrange;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button' and @type='submit']")
    public WebElement submitOrange;


    public void fillHomepageOrange(String usernameOrange, String passwordOrange){
        fillUsernameOrange(usernameOrange);
        fillPasswordOrange(passwordOrange);
        clickSubmitOrange();
    }

    public void fillUsernameOrange(String usernameOrangevalue){
//        String usernameOrangevalue = "Admin";
        usernameOrange.sendKeys(usernameOrangevalue);
    }

    public void fillPasswordOrange(String passwordOrangevalue){
//        String passwordOrangevalue = "admin123";
        passwordOrange.sendKeys(passwordOrangevalue);
    }

    public void clickSubmitOrange(){
        submitOrange.click();
    }
}