package pages;

import com.codeborne.selenide.Selenide;
import elements.HomeElements;
import io.qameta.allure.Step;

public class HomePage extends HomeElements {

    @Step("Entering a search query")
    public HomePage setSearchQuery(String query) {
        searchFieldElement().click();
        searchFieldElement().sendKeys(query);
        searchFieldElement().pressEnter();

        return this;
    }

    @Step("Passing to the homepage")
    public HomePage passToHomePage() {
        getTmdbLogo().click();
        return this;
    }



    public HomePage setProfileWatchList() {
        getUserProfile().click();
        getProfileWatchList().click();

        return this;
    }
}
