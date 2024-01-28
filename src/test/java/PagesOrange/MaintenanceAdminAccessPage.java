package PagesOrange;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MaintenanceAdminAccessPage extends BasePage {
    public MaintenanceAdminAccessPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[name='password']")
    private WebElement administratorAccessPass;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement confirmAccess;


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
