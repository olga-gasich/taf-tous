package ui.steps;

import org.openqa.selenium.chrome.ChromeDriver;
import ui.pages.BasketPage;

public class BasketStep {

    BasketPage page;
    private ChromeDriver driver;

    public BasketStep(ChromeDriver driver){

        this.driver = driver;
        page = new BasketPage(driver);
    }

    public void fillLoginFormAndSubmit(String email, String password){

        page = new BasketPage(driver);
        page.openBaseURL();
        page.clickAcceptCookieBtn();
        page.fillEmailInput(email)
                .fillPwdInput(password)
                .clickRememberPwdCheckbox()
                .clickSubmitBtn();
    }

    public void fillSearchField(String item){

        page = new BasketPage(driver);
        page.clickSearchIcon()
                .fillSearchInput(item);
        page.getFoundEarrings();
    }

    public void addToBasket(){

        page = new BasketPage(driver);
        page.clickFoundEarrings();
        page.clickAddToBasketBtn();
        page.getPreviousCounter();
    }
}
