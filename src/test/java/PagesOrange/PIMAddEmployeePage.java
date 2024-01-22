package PagesOrange;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.time.Duration;

public class PIMAddEmployeePage {
    public WebDriver driver;

    public PIMAddEmployeePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='oxd-topbar-body-nav-tab-item' and text()='Add Employee']")
    public WebElement addEmployee;

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement firstNameEmployee;

    @FindBy(xpath = "//input[@name='middleName']")
    public WebElement middleNameEmployee;

    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement lastNameEmployee;

    @FindBy(xpath = "//input[@class='oxd-file-input']")
    public  WebElement uploadPicture;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButton;


    public void fillEmployeeDetails(String firstname, String middlename, String lastname){
        clickAddEmployee();
        fillFirstName(firstname);
        fillMiddleName(middlename);
        fillLastName(lastname);
        uploadPhoto("src/test/resources/panda.jpg");
        clickSafeButton();


    }

    public void clickAddEmployee(){
        addEmployee.click();
    }

    public void fillFirstName(String firstNameEmployeeValue){
        firstNameEmployee.sendKeys(firstNameEmployeeValue);
    }

    public void fillMiddleName(String middleNameEmployeeValue){
        middleNameEmployee.sendKeys(middleNameEmployeeValue);
    }

    public void fillLastName(String lastNameEmployeeValue){
        lastNameEmployee.sendKeys(lastNameEmployeeValue);
    }

    public void uploadPhoto(String filepath){
        File file = new File(filepath);
        //File file = new File("src/test/resources/panda.jpg");
        uploadPicture.sendKeys(file.getAbsolutePath());
    }

    public void clickSafeButton(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        saveButton.click();
    }
}
