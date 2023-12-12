package elements;

import com.codeborne.selenide.SelenideElement;
import commom.AbstractBaseComponent;

import static java.lang.String.format;

public class HomeElements extends AbstractBaseComponent {
    private final String SEARCH_FIELD = "//form[@id='inner_search_form']/label/input";

    protected SelenideElement searchFieldElement() {
        return waitClickabilityOfElement(SEARCH_FIELD);
    }
}
