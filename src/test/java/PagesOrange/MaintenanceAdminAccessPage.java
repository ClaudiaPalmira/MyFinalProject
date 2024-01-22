package PagesOrange;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MaintenanceAdminAccessPage {

    public WebDriver driver;

    public MaintenanceAdminAccessPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[name='password']")
    public WebElement administratorAccessPass;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement confirmAccess;

    public void filladministratorAccess(String adminNameValue){
        adminName(adminNameValue);
        clickConfirmButton();

    }

    public void adminName(String administratorAccessPassValue){
        administratorAccessPass.sendKeys(administratorAccessPassValue);
    }

    public void clickConfirmButton(){
        confirmAccess.click();
    }

}
