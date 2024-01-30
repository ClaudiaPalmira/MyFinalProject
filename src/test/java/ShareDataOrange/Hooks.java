package ShareDataOrange;

import PropertyUtility.PropertyUtility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;

public class Hooks extends ShareData{

    public HashMap<String, String> testdata;

    @BeforeMethod
    public void prepareEnvironment(){
        setUP();
        String testName = this.getClass().getSimpleName();
        PropertyUtility propertyUtility = new PropertyUtility(testName);
        testdata = propertyUtility.getAllData();

    }

    @AfterMethod
    public void clearEnvironment(){
        clear();
    }

}
