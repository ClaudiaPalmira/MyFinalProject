package Tests;

import PagesOrange.LoginPage;
import PagesOrange.MaintenanceAccessRecordsPage;
import PagesOrange.MaintenanceAdminAccessPage;
import ShareDataOrange.Hooks;
import SidePanelPages.MaintenancePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MaintenanceOrangeHRMTest extends Hooks {

    @Test

    public void maintenanceMethod(){

        //test care permite in sectiunea Maintenance cautarea unui angajat in Access Records


        String usernameOrangevalue = "Admin";
        String passwordOrangevalue = "admin123";
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.fillLoginpageOrange(usernameOrangevalue,passwordOrangevalue);


        MaintenancePage maintenancePage = new MaintenancePage(getDriver());
        maintenancePage.clickMaintenancePage();

        MaintenanceAdminAccessPage maintenanceAdminAccessPage = new MaintenanceAdminAccessPage(getDriver());
        String administratorAccessPassValue = "admin123";
        maintenanceAdminAccessPage.filladministratorAccess(administratorAccessPassValue);

        MaintenanceAccessRecordsPage maintenanceAccessRecordsPage = new MaintenanceAccessRecordsPage(getDriver());
        String employeeNameValue = "Anthony";
        maintenanceAccessRecordsPage.fillAccessRecords(employeeNameValue);



        //validam testul de maintenance

        WebElement maintenancePageHeader = getDriver().findElement(By.xpath("//div[@class='oxd-topbar-header-title']"));
        Assert.assertTrue(maintenancePageHeader.isDisplayed(), "Maintenance page is displayed.");

        WebElement selectedEmployeeField = getDriver().findElement(By.xpath("//div[@class='orangehrm-selected-employee']"));
        Assert.assertTrue(selectedEmployeeField.isDisplayed(), "Selected employee field is displayed.");


    }

}
