package ui.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ui.pages.LoginPage;
import ui.steps.LoginStep;
import utils.Util;


public class LoginTest {

    ChromeDriver driver;
    LoginPage page;
    LoginStep step;

    @BeforeEach
    public void warmUp() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        step = new LoginStep(driver);
        page = new LoginPage(driver);
        page.openBaseURL();
    }

    @Test
    public void testFillFormWithEmptyEmailAndPassword() {

        step.fillLoginFormAndSubmit("","");
        Assertions.assertEquals("El campo Email es obligatorio", page.getEmptyEmailError());
    }

    @Test
    public void testFillFormWithInvalidEmail() {

        step.fillLoginFormAndSubmit(Util.generateFakePassword(),"");
        Assertions.assertEquals("El campo Email debe ser un correo electrónico válido", page.getInvalidEmailError());
    }

    @Test
    public void testFillFormWithEmptyEmailAndSomePassword() {

        step.fillLoginFormAndSubmit("",Util.generateFakePassword());
        Assertions.assertEquals("El campo Email es obligatorio", page.getEmptyEmailError());
    }

    @Test
    public void testFillFormWithInvalidEmailAndPassword() {

        step.fillLoginFormAndSubmit(Util.generateFakeEmail(),Util.generateFakePassword());
        Assertions.assertEquals("La combinación de usuario y contraseña no es correcta", page.getPwdError());
    }

    @Test
    public void testFillFormWithValidEmailAndInvalidPassword() {

        step.fillLoginFormAndSubmit(Util.getValidEmail(),Util.generateFakePassword());
        Assertions.assertEquals("La combinación de usuario y contraseña no es correcta", page.getPwdError());
    }

    @Test
    public void testFillFormWithValidEmailAndPassword() {

        step.fillLoginFormAndSubmit(Util.getValidEmail(),Util.getValidPassword());
        Assertions.assertEquals("Hola Olga,", page.getWelcomeMessage());
    }

    @AfterEach
    public void tearDown() {
    driver.quit();
    }
}
