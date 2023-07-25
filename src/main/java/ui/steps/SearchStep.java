package ui.steps;

import ui.pages.SearchPage;

public class SearchStep {

    SearchPage page;

    public SearchStep() {

        page = new SearchPage();
    }

    public void fillSearchFieldAndSubmit(String item) {

        page.openBaseURL()
                .clickAcceptCookieBtn()
                .clickPromotionCloseBtn()
                .clickSearchIcon()
                .fillSearchInput(item);
    }
}
