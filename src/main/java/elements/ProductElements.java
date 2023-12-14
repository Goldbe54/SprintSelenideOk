package elements;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import commom.BaseComponent;

import static com.codeborne.selenide.Selenide.$$x;

public class ProductElements extends BaseComponent {
    private final String GENERAL_GENERS = "//span[@class='genres']//a";

    public ElementsCollection
    getGeners() {
        return $$x(GENERAL_GENERS).shouldBe(CollectionCondition.sizeGreaterThan(0));
    }
}