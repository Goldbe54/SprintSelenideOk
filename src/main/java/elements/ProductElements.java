package elements;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import commom.BaseComponent;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class ProductElements extends BaseComponent {
    private final String GENERAL_GENERS = "//span[@class='genres']//a";
    private final String FIRST_PRODUCT_CONTEXT_MENU = "(//div[@class='glyphicons_v2 circle-more white'])[1]";
    private final String FIRST_PRODUCT_WATCH_LIST = "//div[@class='k-animation-container'][@aria-hidden='false']//a/span[@class='glyphicons_v2 bookmark pad_right']";
    private final String SPECIFIC_TITLE_PRODUCT = "(//div[@class='card style_1']//h2)[%s]";

    public ElementsCollection
    getGeners() {
        return $$x(GENERAL_GENERS).shouldBe(CollectionCondition.sizeGreaterThan(0));
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
