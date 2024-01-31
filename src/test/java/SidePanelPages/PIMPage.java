package SidePanelPages;

import Logger.LoggerUtility;
import PagesOrange.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PIMPage extends BasePage {

    public PIMPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name' and text()='PIM']")
    private WebElement pimOrange;


    public void clickPIMPage(){
        pimOrange.click();
        LoggerUtility.info("The user click on pimOrange page.");
    }
}
