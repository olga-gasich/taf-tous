package ui.steps;

import org.openqa.selenium.chrome.ChromeDriver;
import ui.pages.SearchPage;

public class SearchStep {

    SearchPage page;
    private ChromeDriver driver;

    public SearchStep(ChromeDriver driver){

        this.driver = driver;
        page = new SearchPage(driver);
    }

    public void fillSearchFieldAndSubmit(String item){

        page = new SearchPage(driver);
        page.openBaseURL();
        page.clickAcceptCookieBtn();
        page.clickSearchIcon()
                .fillSearchInput(item);
    }
}
