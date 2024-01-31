package SidePanelPages;

import Logger.LoggerUtility;
import PagesOrange.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MaintenancePage extends BasePage {

    public MaintenancePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name' and text()='Maintenance']")
    private WebElement maintenanceOrange;


    public void clickMaintenancePage(){
        maintenanceOrange.click();
        LoggerUtility.info("The user clicks on maintenanceOrange page.");
    }

}
