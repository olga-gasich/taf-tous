package ui.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ui.driver.DriverSingleton;
import ui.pages.SearchPage;
import ui.steps.SearchStep;

public class BaseSearchTest {

    SearchPage page;
    SearchStep step;

    @BeforeEach
    public void warmUp() {

        DriverSingleton.getDriver();
        step = new SearchStep();
        page = new SearchPage();
        page.openBaseURL();
    }

    @AfterEach
    public void tearDown() {
        DriverSingleton.quit();
    }
}
