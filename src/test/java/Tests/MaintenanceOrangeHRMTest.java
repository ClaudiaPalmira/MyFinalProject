package Tests;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class MaintenanceOrangeHRMTest {

    public WebDriver driver;

    @Test

    public void maintenanceMethod(){

        //test care permite in sectiunea Maintenance cautarea unui angajat in Access Records

        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement usernameOrange = driver.findElement(By.xpath("//input[@name='username']"));
        String usernameOrangevalue = "Admin";
        usernameOrange.sendKeys(usernameOrangevalue);

        WebElement passwordOrange = driver.findElement(By.xpath("//input[@name='password']"));
        String passwordOrangevalue = "admin123";
        passwordOrange.sendKeys(passwordOrangevalue);

        WebElement submitOrange = driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button' and @type='submit']"));
        submitOrange.click();

        //Partea de sus trebuie sa o scurtez astfel incat sa apelez metoda de log in fara sa o scriu aici

        WebElement maintenanceOrange = driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name' and text()='Maintenance']"));
        maintenanceOrange.click();

//        WebElement administratorAccessUser = driver.findElement(By.cssSelector("input[name='username'][disabled]"));
//        String administratorAccessUserValue = "Admin";
//        administratorAccessUser.sendKeys(administratorAccessUserValue);
        // Campul administrator in casuta care apare e deja completat, fiind logat in cont, nu mai e necesara definirea acestuia

        WebElement administratorAccessPass = driver.findElement(By.cssSelector("input[name='password']"));
        String administratorAccessPassValue = "admin123";
        administratorAccessPass.sendKeys(administratorAccessPassValue);

        WebElement confirmAccess = driver.findElement(By.xpath("//button[@type='submit']"));
        confirmAccess.click();

        WebElement accessRecords = driver.findElement(By.xpath("//a[@class='oxd-topbar-body-nav-tab-item']"));
        accessRecords.click();

        //rezultatul in urma cautarii angajatului "Anthony  Nolan" va fi cel mai probabil invalid fiindca se tot modifica/sterg
        //inregistrarile din aceasta platforma. In momentul initial testul a rulat si gasit persoana, apoi nu a mai existat
        //aceasta persoana in baza de date

        WebElement employeeName = driver.findElement(By.xpath("//input[@placeholder='Type for hints...']"));
        employeeName.click();
        String employeeNameValue = "Anthony";
        employeeName.sendKeys(employeeNameValue);


        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='listbox']//*[contains(text(),'Anthony Nolan')]")));
        employeeName.sendKeys(Keys.ENTER);

        WebElement searchToolTip = driver.findElement(By.xpath("//div[@role='listbox']"));
        wait.until(ExpectedConditions.elementToBeClickable(searchToolTip));
        searchToolTip.click();

        WebElement searchEmployee = driver.findElement(By.xpath("//button[@type='submit']"));
        searchEmployee.click();

        // AICI ASTEPTAM PANA JOI SA VEDEM DACA REUSESTE ALEX SA IMI DEA O SOLUTIE - casuta de "Type for hints"
        // MAI TREBUIE SA FAC VALIDARILE, in cazul in care reusim sa ii gasim solutia



    }

}
