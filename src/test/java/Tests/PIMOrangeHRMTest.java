package Tests;

import ObjectData.BuzzOrangeHRMObject;
import ObjectData.PIMOrangeHRMObject;
import PagesOrange.BuzzNewsfeedPage;
import PagesOrange.LoginPage;
import PagesOrange.PIMAddEmployeePage;
import ShareDataOrange.Hooks;
import SidePanelPages.BuzzPage;
import SidePanelPages.PIMPage;
import ShareDataOrange.ShareData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class PIMOrangeHRMTest extends Hooks {


    @Test

    public void pimMethod() {

        //test care permite in sectiunea PIM adaugarea unui angajat in Add Employee

        String usernameOrangevalue = "Admin";
        String passwordOrangevalue = "admin123";
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.fillLoginpageOrange(usernameOrangevalue,passwordOrangevalue);

        PIMOrangeHRMObject pimOrangeHRMObject = new PIMOrangeHRMObject(testdata);

        PIMPage pimPage = new PIMPage(getDriver());
        pimPage.clickPIMPage();

        PIMAddEmployeePage pimAddEmployeePage = new PIMAddEmployeePage(getDriver());
        pimAddEmployeePage.fillEmployeeDetails(pimOrangeHRMObject);


        //validam testul de adaugare angajat

        WebDriverWait wait= new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='oxd-topbar-body-nav-tab-item' and text()='Employee List']")));

        WebElement employeeList = getDriver().findElement(By.xpath("//a[@class='oxd-topbar-body-nav-tab-item' and text()='Employee List']"));
        if (employeeList.isDisplayed()) {
            System.out.println("Employee creation successful!");
        } else {
            System.out.println("Employee creation failed!");
        }

    }

}
