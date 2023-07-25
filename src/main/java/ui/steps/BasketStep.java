package ui.steps;

import ui.pages.BasketPage;

public class BasketStep {

    BasketPage page;

    public BasketStep() {

        page = new BasketPage();
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

    public void fillSearchField(String item) {

        page.clickSearchIcon()
                .fillSearchInput(item);
    }

    public void addToBasket() {

        page.clickFoundEarrings()
                .clickAddToBasketBtn()
                .clickPopUpBtn()
                .getItemAddedToBasket();
    }
}
