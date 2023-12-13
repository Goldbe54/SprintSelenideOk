package elements;

import com.codeborne.selenide.SelenideElement;
import commom.BaseComponent;

import static java.lang.String.format;

public class HomeElements extends BaseComponent {
    private final String SEARCH_FIELD = "//form[@id='inner_search_form']/label/input";

    protected SelenideElement searchFieldElement() {
        return waitClickabilityOfElement(SEARCH_FIELD);
    }
}
