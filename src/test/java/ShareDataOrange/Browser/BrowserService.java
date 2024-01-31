package ShareDataOrange.Browser;

public interface BrowserService {

    void openBrowser(Boolean cicd);
    void closeBrowser();
    Object prepareBrowserOptions(Boolean cicd);

}
