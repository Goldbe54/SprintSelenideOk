package elements;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import commom.BaseComponent;

import static com.codeborne.selenide.Selenide.*;

public class SearchResultElements extends BaseComponent {

    private final String LIST_OF_PRODUCTS = "//div[@class='search_results movie ']//div[@class='details']//a";

    protected ElementsCollection getAllProducts() {
        return $$x(LIST_OF_PRODUCTS).shouldBe(CollectionCondition.sizeGreaterThan(0));
    }
}