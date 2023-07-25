package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.driver.DriverSingleton;

import java.time.Duration;

public class BasketPage {

    private WebDriver driver;
    private String emailInputLocator = "//*[@id='email-input']";
    private String pwdInputLocator = "//*[@id='password-input']";
    private String rememberPwdCheckboxLocator = "//*[@id='checkbox-inputgroup']/div/div/label";
    private String submitBtnLocator = "//*[@id='login']/div[2]/span";
    private String searchIconLocator = "//*[@id='js-site-search-input']/div";
    private String searchInputLocator = "//div/input[@aria-label='Caja de búsqueda']";
    private String earringsItemLocator = "//*[@id='ebx-grid']/article[1]/a/h1";
    private String addToBasketBtnLocator = "//*[@id='product-images']/div[2]/div/div[1]/div[3]/div[1]/div/button";
    private String PopUpBtnLocator = "//*[@id='toastAddProduct']/div/div/div[4]/div/a/div[2]";
    private String itemAddedToBasketLocator = "//a[@class='link product-name-link']";
    private String acceptCookieBtnLocator = "//*[@id='cookie-disclaimer']/div/div[1]/div[3]/div/button/div[2]/span";
    private String promotionCloseBtnLocator = "//*[@id='newsletter-modal___BV_modal_body_']/div/div[1]/button/div[2]/div";
    private String baseURL = "https://www.tous.com/es-es/register";

    public BasketPage() {

        this.driver = DriverSingleton.getDriver();
    }

    public BasketPage openBaseURL() {

        driver.get(baseURL);
        return this;
    }

    public BasketPage clickAcceptCookieBtn() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement acceptCookieBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(acceptCookieBtnLocator)));
        acceptCookieBtn.click();
        return this;
    }

    public BasketPage clickPromotionCloseBtn() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement promotionCloseBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(promotionCloseBtnLocator)));
        promotionCloseBtn.click();
        return this;
    }

    public BasketPage fillEmailInput(String str) {

        WebElement emailInput = driver.findElement(By.xpath(emailInputLocator));
        emailInput.sendKeys(str);
        return this;
    }

    public BasketPage fillPwdInput(String str) {

        WebElement pwdInput = driver.findElement(By.xpath(pwdInputLocator));
        pwdInput.sendKeys(str);
        return this;
    }

    public BasketPage clickRememberPwdCheckbox() {

        WebElement rememberPwdCheckbox = driver.findElement(By.xpath(rememberPwdCheckboxLocator));
        rememberPwdCheckbox.click();
        return this;
    }

    public BasketPage clickSubmitBtn() {

        WebElement submitBtn = driver.findElement(By.xpath(submitBtnLocator));
        submitBtn.click();
        return this;
    }

    public BasketPage clickSearchIcon() {

        WebElement searchIcon = driver.findElement(By.xpath(searchIconLocator));
        searchIcon.click();
        return this;
    }

    public BasketPage fillSearchInput(String str) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchInputLocator)));
        searchInput.sendKeys(str);
        return this;
    }

    public BasketPage clickFoundEarrings() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement actEarringsItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(earringsItemLocator)));
        actEarringsItem.click();
        return this;
    }

    public BasketPage clickAddToBasketBtn() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement addToBasketBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(addToBasketBtnLocator)));
        addToBasketBtn.click();
        return this;
    }

    public BasketPage clickPopUpBtn() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement PopUpBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PopUpBtnLocator)));
        PopUpBtn.click();
        return this;
    }

    public String getItemAddedToBasket() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement actItemAddedToBasket = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(itemAddedToBasketLocator)));
        String actItemAddedToBasketText = actItemAddedToBasket.getText();
        return actItemAddedToBasketText;
    }
}
