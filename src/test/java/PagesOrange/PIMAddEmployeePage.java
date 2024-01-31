package PagesOrange;

import Logger.LoggerUtility;
import ObjectData.PIMOrangeHRMObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.time.Duration;

public class PIMAddEmployeePage extends BasePage{

    public PIMAddEmployeePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//a[@class='oxd-topbar-body-nav-tab-item' and text()='Add Employee']")
    private WebElement addEmployee;

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firstNameEmployee;

    @FindBy(xpath = "//input[@name='middleName']")
    private WebElement middleNameEmployee;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastNameEmployee;

    @FindBy(xpath = "//input[@class='oxd-file-input']")
    private  WebElement uploadPicture;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveButton;




    public void fillEmployeeDetails(PIMOrangeHRMObject pimOrangeHRMObject){

        clickAddEmployee();
        fillFirstName(pimOrangeHRMObject.getFirstNameEmployeeValue());
        fillMiddleName(pimOrangeHRMObject.getMiddleNameEmployeeValue());
        fillLastName(pimOrangeHRMObject.getLastNameEmployeeValue());
        uploadPhoto("src/test/resources/panda.jpg");
        clickSafeButton();


    }

    public void clickAddEmployee(){

        elementMethods.clickElement(addEmployee);
//        addEmployee.click();
        LoggerUtility.info("The user clicks on addEmployee field.");
    }

    public void fillFirstName(String firstNameEmployeeValue){

        elementMethods.fillElement(firstNameEmployee, firstNameEmployeeValue);
//        firstNameEmployee.sendKeys(firstNameEmployeeValue);
        LoggerUtility.info("The user fills the firstNameEmployee field.");
    }

    public void fillMiddleName(String middleNameEmployeeValue){

        elementMethods.fillElement(middleNameEmployee, middleNameEmployeeValue);
//        middleNameEmployee.sendKeys(middleNameEmployeeValue);
        LoggerUtility.info("The user fills the middleNameEmployee field.");
    }

    public void fillLastName(String lastNameEmployeeValue){

        elementMethods.fillElement(lastNameEmployee, lastNameEmployeeValue);
//        lastNameEmployee.sendKeys(lastNameEmployeeValue);
        LoggerUtility.info("The user fills the lastNameEmployee field.");
    }

    public void uploadPhoto(String filepath){
        File file = new File(filepath);
        //File file = new File("src/test/resources/panda.jpg");
        uploadPicture.sendKeys(file.getAbsolutePath());
        LoggerUtility.info("The user uploads the selected picture.");
    }

    public void clickSafeButton(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        elementMethods.clickElement(saveButton);
//        saveButton.click();
        LoggerUtility.info("The user clicks on the saveButton button.");
    }
}
