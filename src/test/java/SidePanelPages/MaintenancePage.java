package SidePanelPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MaintenancePage {
    public WebDriver driver;

    public MaintenancePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name' and text()='Maintenance']")
    public WebElement maintenanceOrange;

    public void clickMaintenancePage(){
        maintenanceOrange.click();
    }

}
