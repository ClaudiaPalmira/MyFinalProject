package ObjectData;

import java.util.HashMap;

public class BuzzOrangeHRMObject {

    private String buzzFeedValue;

    public String getBuzzFeedValue() {
        return buzzFeedValue;
    }

    public void setBuzzFeedValue(String buzzFeedValue) {
        this.buzzFeedValue = buzzFeedValue;
    }

    public BuzzOrangeHRMObject(HashMap<String, String> testData) {
        populateObject(testData);

    }

    private void populateObject(HashMap<String, String> testData) {
        for (String key : testData.keySet()) {
            if ("buzzFeedValue".equals(key)) {
                setBuzzFeedValue(testData.get(key));
            }
        }
    }

}
