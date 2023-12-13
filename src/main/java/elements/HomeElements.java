package elements;

import com.codeborne.selenide.SelenideElement;
import commom.AbstractBaseComponent;

public class HomeElements extends AbstractBaseComponent {
    private final String SEARCH_FIELD = "//form[@id='inner_search_form']/label/input";
    private final String FIRST_PRODUCT_CONTEXT_MENU = "(//div[@class='glyphicons_v2 circle-more white'])[1]";
    private final String FIRST_PRODUCT_WATCH_LIST = "//div[@class='k-animation-container'][@aria-hidden='false']//a/span[@class='glyphicons_v2 bookmark pad_right']";
    private final String FIRST_TITLE_PRODUCT="(//div[@class=\"card style_1\"]//h2)[1]";

    protected SelenideElement searchFieldElement() {
        return waitClickabilityOfElement(SEARCH_FIELD);
    }

    protected SelenideElement getFirstProductContextMenu(){
        return  waitClickabilityOfElement(FIRST_PRODUCT_CONTEXT_MENU);
    }

    protected SelenideElement getFirstProductWatchList(){
        return waitClickabilityOfElement(FIRST_PRODUCT_WATCH_LIST);
    }

    protected SelenideElement getFirstTitleProduct(){
        return waitVisibilityOfElement(FIRST_TITLE_PRODUCT);
    }
}
