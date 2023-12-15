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

    @Step("Add film to the WishList")
    public String addToWishList() {
        String title = getSpecificFirstTitleProduct(1).getText();

        getFirstProductContextMenu().click();
        getFirstProductWatchList().click();
        successAddToWatchList().isEnabled();
        Selenide.sleep(5000);

        return title;
    }


    public HomePage setProfileWatchList() {
        getUserProfile().click();
        getProfileWatchList().click();

        return this;
    }
}
