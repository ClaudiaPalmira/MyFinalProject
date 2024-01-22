package Tests;

import PagesOrange.HomePage;
import PagesOrange.MaintenanceAdminAccessPage;
import SidePanelPages.MaintenancePage;
import ShareDataOrange.ShareData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class MaintenanceOrangeHRMTest extends ShareData {

    @Test

    public void maintenanceMethod(){

        //test care permite in sectiunea Maintenance cautarea unui angajat in Access Records

        String usernameOrangevalue = "Admin";
        String passwordOrangevalue = "admin123";
        HomePage homePage = new HomePage(driver);
        homePage.fillHomepageOrange(usernameOrangevalue,passwordOrangevalue);

//        WebElement maintenanceOrange = driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name' and text()='Maintenance']"));
//        maintenanceOrange.click();

        MaintenancePage maintenancePage = new MaintenancePage(driver);
        maintenancePage.clickMaintenancePage();

//        WebElement administratorAccessPass = driver.findElement(By.cssSelector("input[name='password']"));
//        String administratorAccessPassValue = "admin123";
//        administratorAccessPass.sendKeys(administratorAccessPassValue);
//
//        WebElement confirmAccess = driver.findElement(By.xpath("//button[@type='submit']"));
//        confirmAccess.click();

        MaintenanceAdminAccessPage maintenanceAdminAccessPage = new MaintenanceAdminAccessPage(driver);
        String administratorAccessPassValue = "admin123";
        maintenanceAdminAccessPage.filladministratorAccess(administratorAccessPassValue);

        WebElement accessRecords = driver.findElement(By.xpath("//a[@class='oxd-topbar-body-nav-tab-item']"));
        accessRecords.click();

        WebElement employeeName = driver.findElement(By.xpath("//input[@placeholder='Type for hints...']"));
        employeeName.click();
        String employeeNameValue = "Anthony";
        employeeName.sendKeys(employeeNameValue);
        By employeeLocator = By.xpath("//*[contains(text(),'"+employeeNameValue+"')]");

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(employeeLocator));

        WebElement employeeOptionElement = driver.findElement(employeeLocator);
        employeeOptionElement.click();

        WebElement searchEmployee = driver.findElement(By.xpath("//button[@type='submit']"));
        searchEmployee.click();


        // MAI TREBUIE SA FAC VALIDARILE, in cazul in care reusim sa ii gasim solutia


        WebElement maintenancePageHeader = driver.findElement(By.xpath("//div[@class='oxd-topbar-header-title']"));
        Assert.assertTrue(maintenancePageHeader.isDisplayed(), "Maintenance page is not displayed.");

        WebElement selectedEmployeeField = driver.findElement(By.xpath("//div[@class='orangehrm-selected-employee']"));
        Assert.assertTrue(selectedEmployeeField.isDisplayed(), "Selected employee field is not displayed.");


//        List<WebElement> selectedEmployeeValidation = driver.findElements(By.xpath("//div[@class='--name-grouped-field']//div[@class='oxd-input-group oxd-input-field-bottom-space']"));
//
//        Assert.assertTrue(selectedEmployeeValidation.get(0).getText().contains("Anthony"));
//        Assert.assertTrue(selectedEmployeeValidation.get(1).getText().contains("Nolan"));


//        List<WebElement> selectedEmployeeValidation = driver.findElements(By.xpath("//div[@class='--name-grouped-field']//div[@class='oxd-input-group oxd-input-field-bottom-space']"));
//        Integer expectedtablesize = selectedEmployeeValidation.size();
//        String lastEntryTable=selectedEmployeeValidation.get(actualtablesize).getText();
//        Assert.assertTrue(lastEntryTable.contains(employeeNameValue));

    }

}
