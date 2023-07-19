package ui.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ui.driver.DriverSingleton;
import ui.pages.LoginPage;
import ui.steps.LoginStep;

public class BaseLoginTest {

    LoginPage page;
    LoginStep step;

    @BeforeEach
    public void warmUp() {

        DriverSingleton.getDriver();
        step = new LoginStep();
        page = new LoginPage();
        page.openBaseURL();
    }

    @AfterEach
    public void tearDown() {
        DriverSingleton.quit();
    }
}
