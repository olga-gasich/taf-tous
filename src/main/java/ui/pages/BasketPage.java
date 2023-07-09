package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasketPage {

    private ChromeDriver driver;
    private String emailInputLocator = "//*[@id='email-input']";
    private String pwdInputLocator = "//*[@id='password-input']";
    private String rememberPwdCheckboxLocator = "//*[@id='checkbox-inputgroup']/div/div/label";
    private String submitBtnLocator = "//*[@id='login']/div[2]/span";
    private String searchIconLocator = "//*[@id='js-site-search-input']/div";
    private String searchInputLocator = "//div/input[@aria-label='Caja de búsqueda']";
    private String earringsItemLocator = "//*[@id='ebx-grid']/article[1]/a/h1";
    private String addToBasketBtnLocator = "//*[@id='product-images']/div[2]/div/div[1]/div[3]/div[1]/div/button";
    private String counterLocator = "//*[@id='__layout']/div/div[2]/div[2]/div/header/div/div[2]/a[2]/span[1]";
    private String acceptCookieBtnLocator = "//*[@id='cookie-disclaimer']/div/div[1]/div[3]/div/button/div[2]/span";
    private String welcomeMessageLocator = "//*[@id='__layout']/div/div[3]/div[1]/div/h2/span[1]";
    private String baseURL = "https://www.tous.com/es-es/register";

    public BasketPage (ChromeDriver driver){

        this.driver = driver;
    }

    public void openBaseURL() {

        driver.get(baseURL);
    }

    public void clickAcceptCookieBtn(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement acceptCookieBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(acceptCookieBtnLocator)));
        acceptCookieBtn.click();
    }

    public BasketPage fillEmailInput(String str){

        WebElement emailInput = driver.findElement(By.xpath(emailInputLocator));
        emailInput.sendKeys(str);
        return this;
    }

    public BasketPage fillPwdInput(String str){

        WebElement pwdInput = driver.findElement(By.xpath(pwdInputLocator));
        pwdInput.sendKeys(str);
        return this;
    }

    public BasketPage clickRememberPwdCheckbox(){

        WebElement rememberPwdCheckbox = driver.findElement(By.xpath(rememberPwdCheckboxLocator));
        rememberPwdCheckbox.click();
        return this;
    }

    public BasketPage clickSubmitBtn(){

        WebElement submitBtn = driver.findElement(By.xpath(submitBtnLocator));
        submitBtn.click();
        return this;
    }

    public String getWelcomeMessage(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement actWelcomeMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(welcomeMessageLocator)));
        String actWelcomeMessageText = actWelcomeMessage.getText();
        return actWelcomeMessageText;
    }

    public BasketPage clickSearchIcon(){

        WebElement searchIcon = driver.findElement(By.xpath(searchIconLocator));
        searchIcon.click();
        return this;
    }

    public BasketPage fillSearchInput(String str){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchInputLocator)));
        searchInput.sendKeys(str);
        return this;
    }

    public String getFoundEarrings(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement actEarringsItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(earringsItemLocator)));
        String actEarringsItemText = actEarringsItem.getText();
        return actEarringsItemText;
    }

    public BasketPage clickFoundEarrings(){

        WebElement actEarringsItem = driver.findElement(By.xpath(earringsItemLocator));
        actEarringsItem.click();
        return this;
    }

    public void clickAddToBasketBtn(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addToBasketBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addToBasketBtnLocator)));
        addToBasketBtn.click();
    }

    public String getNewAddedItemCount(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement actWelcomeMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(counterLocator)));
        String actWelcomeMessageText = actWelcomeMessage.getText();
        return actWelcomeMessageText;
    }
}
