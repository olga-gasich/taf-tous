package ui.steps;

import org.openqa.selenium.chrome.ChromeDriver;
import ui.pages.LoginPage;

public class LoginStep {

    LoginPage page;
    private ChromeDriver driver;

    public LoginStep(ChromeDriver driver){

        this.driver = driver;
        page = new LoginPage(driver);
    }

    public void fillLoginFormAndSubmit(String email, String password){

        page = new LoginPage(driver);
        page.openBaseURL();
        page.clickAcceptCookieBtn();
        page.fillEmailInput(email)
                .fillPwdInput(password)
                .clickRememberPwdCheckbox()
                .clickSubmitBtn();
    }
}
