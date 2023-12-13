package elements;

import com.codeborne.selenide.ElementsCollection;
import commom.BaseComponent;

public class SearchResultElements extends BaseComponent {

    private final String LIST_OF_PRODUCTS = "//div[@class='search_results movie ']//div[@class='details']//a";

    protected ElementsCollection getAllProducts() {
        return waitPresenceOfElements(LIST_OF_PRODUCTS);
    }
}