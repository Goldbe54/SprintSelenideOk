package elements;

import com.codeborne.selenide.SelenideElement;
import commom.BaseComponent;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Selenide.$x;

public class HomeElements extends BaseComponent {
    private final String SEARCH_FIELD = "//form[@id='inner_search_form']/label/input";

    protected SelenideElement searchFieldElement() {
        return $x(SEARCH_FIELD).shouldBe(interactable);
    }
}
