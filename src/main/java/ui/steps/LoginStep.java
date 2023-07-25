package ui.steps;

import ui.pages.LoginPage;

public class LoginStep {

    LoginPage page;

    public LoginStep() {

        page = new LoginPage();
    }

    public void fillLoginFormAndSubmit(String email, String password) {

        page.openBaseURL()
                .clickAcceptCookieBtn()
                .clickPromotionCloseBtn()
                .fillEmailInput(email)
                .fillPwdInput(password)
                .clickRememberPwdCheckbox()
                .clickSubmitBtn();
    }
}
