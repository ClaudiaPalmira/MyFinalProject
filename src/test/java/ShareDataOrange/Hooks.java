package ShareDataOrange;

import Logger.LoggerUtility;
import PropertyUtility.PropertyUtility;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;

public class Hooks extends ShareData{

    public HashMap<String, String> testdata;
    public String testName;

    @BeforeMethod
    public void prepareEnvironment(){
        testName = this.getClass().getSimpleName();
        PropertyUtility propertyUtility = new PropertyUtility(testName);
        testdata = propertyUtility.getAllData();
        LoggerUtility.startTestCase(testName);
        setUP();

    }

    @AfterMethod
    public void clearEnvironment(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            LoggerUtility.error(result.getThrowable().getMessage());
        }
        else {
            clear();
            LoggerUtility.endTestCase(testName);
        }

    }
    @AfterSuite
    public void finishArtefacts(){
        LoggerUtility.mergeLogsIntoOne();
    }

}
