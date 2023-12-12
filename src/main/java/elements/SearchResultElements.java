package elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import commom.AbstractBaseComponent;

public class SearchResultElements extends AbstractBaseComponent {

    private final String LIST_OF_PRODUCTS = "//div[@class='search_results movie ']//div[@class='details']//a";

    protected ElementsCollection getAllProducts() {
        return waitPresenceOfElements(LIST_OF_PRODUCTS);
    }
}