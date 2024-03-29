package PagesOrange;

import HelpMethods.ElementMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;


public class BasePage {

     //Aceasta clasa reprezinta clasa de baza(parinte) pentru toate celelate clase care vor mosteni specificatiile ei
    //(adica ce este comun in toate) fara insa a le putea modifica dar sa poate fi share-uit de toate, reducem codul

    protected WebDriver driver;
    protected ElementMethods elementMethods;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        elementMethods = new ElementMethods(driver);
    }

}
