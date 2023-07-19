package ui.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ui.driver.DriverSingleton;
import ui.pages.BasketPage;
import ui.steps.BasketStep;

public class BaseBasketTest {

    BasketPage page;
    BasketStep step;

    @BeforeEach
    public void warmUp() {

        DriverSingleton.getDriver();
        step = new BasketStep();
        page = new BasketPage();
        page.openBaseURL();
    }

    @AfterEach
    public void tearDown() {

        DriverSingleton.quit();
    }
}
