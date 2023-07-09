package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SearchPage {

    private ChromeDriver driver;
    private String searchIconLocator = "//*[@id='js-site-search-input']/div";
    private String searchInputLocator = "//div/input[@aria-label='Caja de búsqueda']";
    private String ringItemLocator = "//*[@id='ebx-grid']/article[1]/a/h1";
    private String braceletItemLocator = "//*[@id='ebx-grid']/article[1]/a/h1";
    private String bagItemLocator = "//*[@id='ebx-grid']/article/a/h1";
    private String noFoundResultMessageLocator = "//span[@class='ebx-no-results__message-try-again'and text()='. Por favor, prueba de nuevo con otras palabras.']";
    private String acceptCookieBtnLocator = "//*[@id='cookie-disclaimer']/div/div[1]/div[3]/div/button/div[2]/span";
    private String baseURL = "https://www.tous.com/es-es/register";

    public SearchPage (ChromeDriver driver){

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

    public SearchPage clickSearchIcon(){

        WebElement searchIcon = driver.findElement(By.xpath(searchIconLocator));
        searchIcon.click();
        return this;
    }

    public SearchPage fillSearchInput(String str){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchInputLocator)));
        searchInput.sendKeys(str);
        return this;
    }

    public String getRings(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement actRingItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ringItemLocator)));
        String actRingName = actRingItem.getText();
        return actRingName;
    }

    public String getRingsAndBracelets(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement actBraceletItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(braceletItemLocator)));
        String actBraceletName = actBraceletItem.getText();
        return actBraceletName;
    }

    public String getSpecificBag(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement actBagItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(bagItemLocator)));
        String actBagName = actBagItem.getText();
        return actBagName;
    }

    public String getNoFoundResultsMessage(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement actNoFoundResultMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(noFoundResultMessageLocator)));
        String actNoFoundResultMessageText = actNoFoundResultMessage.getText();
        return actNoFoundResultMessageText;
    }
}
