package ui.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SearchTest extends BaseSearchTest {

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
}
