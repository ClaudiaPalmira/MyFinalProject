package ObjectData;

import java.io.File;
import java.util.HashMap;

public class PIMOrangeHRMObject {

    private String firstNameEmployeeValue;
    private String middleNameEmployeeValue;
    private String lastNameEmployeeValue;
    private File filepath;

    public PIMOrangeHRMObject (HashMap<String, String> testData){
        populateObject(testData);

    }

    private void populateObject(HashMap<String, String> testData){

        for(String Key: testData.keySet()){
            switch (Key){
                case "firstNameEmployeeValue":
                    setFirstNameEmployeeValue(testData.get(Key));
                    break;
                case "middleNameEmployeeValue":
                    setMiddleNameEmployeeValue(testData.get(Key));
                    break;
                case "lastNameEmployeeValue":
                    setLastNameEmployeeValue(testData.get(Key));
                    break;
                case "filepath":
                    File file = new File(testData.get(Key));
                    setFilepath(file);
                    break;
            }
        }
    }


    public String getFirstNameEmployeeValue() {
        return firstNameEmployeeValue;
    }

    public void setFirstNameEmployeeValue(String firstNameEmployeeValue) {
        this.firstNameEmployeeValue = firstNameEmployeeValue;
    }

    public String getMiddleNameEmployeeValue() {
        return middleNameEmployeeValue;
    }

    public void setMiddleNameEmployeeValue(String middleNameEmployeeValue) {
        this.middleNameEmployeeValue = middleNameEmployeeValue;
    }

    public String getLastNameEmployeeValue() {
        return lastNameEmployeeValue;
    }

    public void setLastNameEmployeeValue(String lastNameEmployeeValue) {
        this.lastNameEmployeeValue = lastNameEmployeeValue;
    }

    public File getFilepath() {
        return filepath;
    }

    public void setFilepath(File filepath) {
        this.filepath = filepath;
    }
}
