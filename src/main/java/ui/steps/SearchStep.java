package ui.steps;

import ui.pages.SearchPage;

public class SearchStep {

    SearchPage page;

    public SearchStep(){

        page = new SearchPage();
    }

    public void fillSearchFieldAndSubmit(String item){

        page.openBaseURL();
        page.clickAcceptCookieBtn();
        page.clickPromotionCloseBtn();
        page.clickSearchIcon()
                .fillSearchInput(item);
    }
}
