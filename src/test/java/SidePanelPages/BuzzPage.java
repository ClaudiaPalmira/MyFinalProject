package SidePanelPages;

import Logger.LoggerUtility;
import PagesOrange.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuzzPage extends BasePage {

    public BuzzPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name' and text()='Buzz']")
    private WebElement buzzOrange;

    public void clickBuzzPage(){
        buzzOrange.click();
        LoggerUtility.info("The user clicks on buzzOrange page.");
    }
}
