package PagesOrange;

import Logger.LoggerUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MaintenanceAccessRecordsPage extends BasePage{
    public MaintenanceAccessRecordsPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//a[@class='oxd-topbar-body-nav-tab-item']")
    private WebElement accessRecords;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    private WebElement employeeName;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchEmployee;




    public void fillAccessRecords(String employeenamevalue){
        clickAccessRecords();
        clickEmployeeNameField();
        enterEmployeeName(employeenamevalue);
        clickSearchButton();
    }

    public void clickAccessRecords(){
        accessRecords.click();
        LoggerUtility.info("The user click on accessRecords field.");
    }

    public void clickEmployeeNameField(){
        employeeName.click();
        LoggerUtility.info("The user click on employeeName field.");
    }

    public void enterEmployeeName(String employeeNameValue){
        employeeName.sendKeys(employeeNameValue);
        By employeeLocator = By.xpath("//*[contains(text(),'"+employeeNameValue+"')]");
        LoggerUtility.info("The user fills on employeeName field.");

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(employeeLocator));

        WebElement employeeOptionElement = driver.findElement(employeeLocator);
        employeeOptionElement.click();
        LoggerUtility.info("The user selects the employee.");
    }

    public void clickSearchButton(){
        searchEmployee.click();
        LoggerUtility.info("The user clicks the searchEmployee field.");
    }
}
