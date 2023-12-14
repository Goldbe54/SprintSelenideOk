package elements;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import commom.BaseComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class BrowseProductElements extends BaseComponent {
    private final String USER_SCORE_ICON = "//span[contains(@class, 'icon icon')]";
    private final String GENERAL_GENRES_SELECTOR = "//ul[@id='with_genres']//a";
    private final String SPECIFIC_GENRE_SELECTOR = "(//ul[@id='with_genres']/li)[%s]";
    private final String SEARCH_BY_SELECTED_FILTERS_BUTTON = "//div[contains(@class,'apply small')]";
    private final String SPECIFIC_PRODUCT_PICTURE = "(//div[@class='card style_1']//img)[1]";


    protected ElementsCollection allUserScoreIcon() {
        return $$x(USER_SCORE_ICON).shouldBe(CollectionCondition.sizeGreaterThan(0));
    }

    protected ElementsCollection allGenresSelectors() {
        return $$x(GENERAL_GENRES_SELECTOR).shouldBe(CollectionCondition.sizeGreaterThan(0));
    }

    protected SelenideElement specificGenreSelector(int number) {
        return $x(format(SPECIFIC_GENRE_SELECTOR, number)).shouldBe(interactable);
    }

    protected SelenideElement searchByFiltersButton() {
        return $x(SEARCH_BY_SELECTED_FILTERS_BUTTON).shouldBe(interactable);
    }

    protected SelenideElement getSpecificProductPicture(int number) {
        return $x(format(SPECIFIC_PRODUCT_PICTURE,number)).shouldBe(interactable);
    }
}
