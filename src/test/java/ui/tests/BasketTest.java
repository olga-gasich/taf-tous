package ui.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ui.pages.BasketPage;
import ui.steps.BasketStep;
import utils.Util;

public class BasketTest {

    ChromeDriver driver;
    BasketPage page;
    BasketStep step;

    @BeforeEach
    public void warmUp() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        step = new BasketStep(driver);
        page = new BasketPage(driver);
        page.openBaseURL();
    }

    @Test
    public void testAddFoundItemToBasket() {

        step.fillLoginFormAndSubmit(Util.getValidEmail(),Util.getValidPassword());
        Assertions.assertEquals("Hola Olga,", page.getWelcomeMessage());
        step.fillSearchField("Pendientes botón de plata Bear");
        Assertions.assertEquals("Pendientes botón de plata TOUS Bear", page.getFoundEarrings());
        step.addToBasket();
        Assertions.assertEquals("8", page.getPreviousCounter());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
