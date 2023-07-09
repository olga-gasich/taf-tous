package ui.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ui.pages.SearchPage;
import ui.steps.SearchStep;

public class SearchTest {

    ChromeDriver driver;
    SearchPage page;
    SearchStep step;

    @BeforeEach
    public void warmUp() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        step = new SearchStep(driver);
        page = new SearchPage(driver);
        page.openBaseURL();
    }

    @Test
    public void testSearchForRings() {

        step.fillSearchFieldAndSubmit("anillos");
        Assertions.assertEquals("Anillo bicolor Virtual Garden", page.getRings());
    }

    @Test
    public void testSearchForBraceletsAndRings() {

        step.fillSearchFieldAndSubmit("anillos y pulseras");
        Assertions.assertEquals("Pulsera bicolor de anillas TOUS Hav", page.getRingsAndBracelets());
    }

    @Test
    public void testSearchForForSpecificBag() {

        step.fillSearchFieldAndSubmit("Saca mediana blanco y negro");
        Assertions.assertEquals("Saca mediana blanco y negro TOUS Cloud Soft", page.getSpecificBag());
    }

    @Test
    public void testSearchWithInvalidData() {

        step.fillSearchFieldAndSubmit("$$$$$$$$$$$$");
        Assertions.assertEquals(". Por favor, prueba de nuevo con otras palabras.", page.getNoFoundResultsMessage());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
