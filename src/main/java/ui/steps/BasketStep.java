package ui.steps;

import ui.pages.BasketPage;

public class BasketStep {

    BasketPage page;

    public BasketStep(){

        page = new BasketPage();
    }

    public void fillLoginFormAndSubmit(String email, String password){

        page.openBaseURL();
        page.clickAcceptCookieBtn();
        page.clickPromotionCloseBtn();
        page.fillEmailInput(email)
                .fillPwdInput(password)
                .clickRememberPwdCheckbox()
                .clickSubmitBtn();
    }

    public void fillSearchField(String item){

        page.clickSearchIcon()
                .fillSearchInput(item);
        page.getFoundEarrings();
    }

    public void addToBasket(){

        page.clickFoundEarrings();
        page.clickAddToBasketBtn();
        page.clickPopUpBtn();
        page.getItemAddedToBasket();
    }
}
