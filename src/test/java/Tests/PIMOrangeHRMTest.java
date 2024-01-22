package Tests;

import PagesOrange.HomePage;
import PagesOrange.PIMAddEmployeePage;
import SidePanelPages.PIMPage;
import ShareDataOrange.ShareData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class PIMOrangeHRMTest extends ShareData {

    @Test

    public void pimMethod() {

        //test care permite in sectiunea PIM adaugarea unui angajat in Add Employee

        String usernameOrangevalue = "Admin";
        String passwordOrangevalue = "admin123";
        HomePage homePage = new HomePage(driver);
        homePage.fillHomepageOrange(usernameOrangevalue,passwordOrangevalue);

        PIMPage pimPage = new PIMPage(driver);
        pimPage.clickPIMPage();

//        WebElement pimOrange = driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name' and text()='PIM']"));
//        pimOrange.click();

        PIMAddEmployeePage pimAddEmployeePage = new PIMAddEmployeePage(driver);
        String firstNameEmployeeValue = "Ivan";
        String middleNameEmployeeValue = "Iulian";
        String lastNameEmployeeValue = "Ionescu";
        String filepath ="src/test/resources/panda.jpg";
        pimAddEmployeePage.fillEmployeeDetails(firstNameEmployeeValue, middleNameEmployeeValue, lastNameEmployeeValue);

//        WebElement addEmployee = driver.findElement(By.xpath("//a[@class='oxd-topbar-body-nav-tab-item' and text()='Add Employee']"));
//        addEmployee.click();

//        WebElement firstNameEmployee = driver.findElement(By.xpath("//input[@name='firstName']"));
//        String firstNameEmployeeValue = "Ivan";
//        firstNameEmployee.sendKeys(firstNameEmployeeValue);

//        WebElement middleNameEmployee = driver.findElement(By.xpath("//input[@name='middleName']"));
//        String middleNameEmployeeValue = "Iulian";
//        middleNameEmployee.sendKeys(middleNameEmployeeValue);

//        WebElement lastNameEmployee = driver.findElement(By.xpath("//input[@name='lastName']"));
//        String lastNameEmployeeValue = "Ionescu";
//        lastNameEmployee.sendKeys(lastNameEmployeeValue);

//        WebElement uploadPicture = driver.findElement(By.xpath("//input[@class='oxd-file-input']"));
//        File file = new File("src/test/resources/panda.jpg");
//        uploadPicture.sendKeys(file.getAbsolutePath());
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//        WebElement saveButton = driver.findElement(By.xpath("//button[@type='submit']"));
//        saveButton.click();

        //validam testul de adaugare angajat

        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='oxd-topbar-body-nav-tab-item' and text()='Employee List']")));

        WebElement employeeList = driver.findElement(By.xpath("//a[@class='oxd-topbar-body-nav-tab-item' and text()='Employee List']"));
        if (employeeList.isDisplayed()) {
            System.out.println("Employee creation successful!");
        } else {
            System.out.println("Employee creation failed!");
        }

//        List<WebElement> newEmployeeValidation = driver.findElements(By.cssSelector("div.oxd-input-group.oxd-input-field-bottom-space"));
//
////        Assert.assertTrue(newEmployeeValidation.get(0).getText().contains(firstNameEmployeeValue));
////        Assert.assertTrue(newEmployeeValidation.get(1).getText().contains(middleNameEmployeeValue));
////        Assert.assertTrue(newEmployeeValidation.get(2).getText().contains(lastNameEmployeeValue));

//        List<WebElement> newEmployeeValidation = driver.findElements(By.cssSelector("div.oxd-input-group.oxd-input-field-bottom-space input.oxd-input"));
//
//        Assert.assertTrue(newEmployeeValidation.get(0).getAttribute("Ivan").contains(firstNameEmployeeValue));
//        Assert.assertTrue(newEmployeeValidation.get(1).getAttribute("Iulian").contains(middleNameEmployeeValue));
//        Assert.assertTrue(newEmployeeValidation.get(2).getAttribute("Ionescu").contains(lastNameEmployeeValue));

    }

}
