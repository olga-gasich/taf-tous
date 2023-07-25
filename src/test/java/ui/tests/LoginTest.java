package ui.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.Util;

public class LoginTest extends BaseLoginTest {

    @Test
    public void testFillFormWithEmptyEmailAndPassword() {

        step.fillLoginFormAndSubmit("", "");
        Assertions.assertEquals("El campo Email es obligatorio", page.getEmptyEmailError());
    }

    @Test
    public void testFillFormWithInvalidEmailAndEmptyPassword() {

        step.fillLoginFormAndSubmit(Util.generateFakePassword(), "");
        Assertions.assertEquals("El campo Email debe ser un correo electrónico válido", page.getInvalidEmailError());
    }

    @Test
    public void testFillFormWithEmptyEmailAndInvalidPassword() {

        step.fillLoginFormAndSubmit("", Util.generateFakePassword());
        Assertions.assertEquals("El campo Email es obligatorio", page.getEmptyEmailError());
    }

    @Test
    public void testFillFormWithInvalidEmailAndPassword() {

        step.fillLoginFormAndSubmit(Util.generateFakeEmail(), Util.generateFakePassword());
        Assertions.assertEquals("La combinación de usuario y contraseña no es correcta", page.getPwdError());
    }

    @Test
    public void testFillFormWithValidEmailAndInvalidPassword() {

        step.fillLoginFormAndSubmit(Util.getValidEmail(), Util.generateFakePassword());
        Assertions.assertEquals("La combinación de usuario y contraseña no es correcta", page.getPwdError());
    }

    @Test
    public void testFillFormWithValidEmailAndPassword() {

        step.fillLoginFormAndSubmit(Util.getValidEmail(), Util.getValidPassword());
        Assertions.assertEquals("Hola Olga,", page.getWelcomeMessage());
    }
}
