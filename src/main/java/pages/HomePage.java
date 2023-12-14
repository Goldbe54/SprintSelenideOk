package pages;

import elements.HomeElements;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.actions;

public class HomePage extends HomeElements {

@Step("Entering a search query")
    public HomePage setSearchQuery (String query){
        searchFieldElement().click();
        searchFieldElement().sendKeys(query);
        searchFieldElement().pressEnter();

        return this;
    }
}
