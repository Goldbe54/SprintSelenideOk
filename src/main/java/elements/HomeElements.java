package elements;

import com.codeborne.selenide.SelenideElement;
import commom.BaseComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class HomeElements extends BaseComponent {
    private final String SEARCH_FIELD = "//form[@id='inner_search_form']/label/input";
    private final String FIRST_PRODUCT_CONTEXT_MENU = "(//div[@class='glyphicons_v2 circle-more white'])[1]";
    private final String FIRST_PRODUCT_WATCH_LIST = "//div[@class='k-animation-container'][@aria-hidden='false']//a/span[@class='glyphicons_v2 bookmark pad_right']";
    private final String SPECIFIC_TITLE_PRODUCT = "(//div[@class='card style_1']//h2)[%s]";

    protected SelenideElement searchFieldElement() {
        return $x(SEARCH_FIELD).shouldBe(interactable);
    }

    protected SelenideElement getFirstProductContextMenu() {
        return $x(FIRST_PRODUCT_CONTEXT_MENU).shouldBe(interactable);
    }

    protected SelenideElement getFirstProductWatchList() {
        return $x(FIRST_PRODUCT_WATCH_LIST).shouldBe(interactable);
    }

    protected SelenideElement getSpecificFirstTitleProduct(int number) {
        return $x(format(SPECIFIC_TITLE_PRODUCT, number)).shouldBe(visible);
    }
}