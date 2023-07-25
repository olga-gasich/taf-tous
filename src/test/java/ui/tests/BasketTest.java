package ui.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.Util;

public class BasketTest extends BaseBasketTest {

    @Test
    public void testAddFoundItemToBasket() {

        step.fillLoginFormAndSubmit(Util.getValidEmail(), Util.getValidPassword());
        step.fillSearchField("Pendientes botón de plata Bear");
        step.addToBasket();
        Assertions.assertEquals("Pendientes botón de plata TOUS Bear", page.getItemAddedToBasket());
    }
}
