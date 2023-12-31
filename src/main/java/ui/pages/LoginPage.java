package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.driver.DriverSingleton;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private String emailInputLocator = "//*[@id='email-input']";
    private String pwdInputLocator = "//*[@id='password-input']";
    private String rememberPwdCheckboxLocator = "//*[@id='checkbox-inputgroup']/div/div/label";
    private String submitBtnLocator = "//*[@id='login']/div[2]/span";
    private String emptyEmailErrorLocator = "//*[@id='email-input-group']/div/div[2]/span";
    private String invalidEmailErrorLocator = "//*[@id='email-input-group']/div/div[2]/span";
    private String pwdErrorLocator = "//div[@class='position-relative sm']/../div[@class='d-block invalid-feedback']/span[text()='La combinación de usuario y contraseña no es correcta']";
    private String welcomeMessageLocator = "//*[@id='__layout']/div/div[3]/div[1]/div/h2/span[1]";
    private String acceptCookieBtnLocator = "//*[@id='cookie-disclaimer']/div/div[1]/div[3]/div/button/div[2]/span";
    private String promotionCloseBtnLocator = "//*[@id='newsletter-modal___BV_modal_body_']/div/div[1]/button/div[2]/div";
    private String baseURL = "https://www.tous.com/es-es/register";


    public LoginPage() {

        this.driver = DriverSingleton.getDriver();
    }

    public LoginPage openBaseURL() {

        driver.get(baseURL);
        return this;
    }

    public LoginPage clickAcceptCookieBtn() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement acceptCookieBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(acceptCookieBtnLocator)));
        acceptCookieBtn.click();
        return this;
    }

    public LoginPage clickPromotionCloseBtn() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement promotionCloseBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(promotionCloseBtnLocator)));
        promotionCloseBtn.click();
        return this;
    }

    public LoginPage fillEmailInput(String str) {

        WebElement emailInput = driver.findElement(By.xpath(emailInputLocator));
        emailInput.sendKeys(str);
        return this;
    }

    public LoginPage fillPwdInput(String str) {

        WebElement pwdInput = driver.findElement(By.xpath(pwdInputLocator));
        pwdInput.sendKeys(str);
        return this;
    }

    public LoginPage clickRememberPwdCheckbox() {

        WebElement rememberPwdCheckbox = driver.findElement(By.xpath(rememberPwdCheckboxLocator));
        rememberPwdCheckbox.click();
        return this;
    }

    public LoginPage clickSubmitBtn() {

        WebElement submitBtn = driver.findElement(By.xpath(submitBtnLocator));
        submitBtn.click();
        return this;
    }

    public String getEmptyEmailError() {

        WebElement actEmptyEmailError = driver.findElement(By.xpath(emptyEmailErrorLocator));
        String actEmptyEmailErrorMessage = actEmptyEmailError.getText();
        return actEmptyEmailErrorMessage;
    }

    public String getInvalidEmailError() {

        WebElement actInvalidEmailError = driver.findElement(By.xpath(invalidEmailErrorLocator));
        String actInvalidEmailErrorMessage = actInvalidEmailError.getText();
        return actInvalidEmailErrorMessage;
    }

    public String getPwdError() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement actPwdError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pwdErrorLocator)));
        String actPwdErrorMessage = actPwdError.getText();
        return actPwdErrorMessage;
    }

    public String getWelcomeMessage() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement actWelcomeMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(welcomeMessageLocator)));
        String actWelcomeMessageText = actWelcomeMessage.getText();
        return actWelcomeMessageText;
    }
}
