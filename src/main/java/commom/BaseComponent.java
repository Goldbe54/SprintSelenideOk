package commom;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class BaseComponent extends BasePage {
    private final String HEADER_GENERAL_TAB = "//ul[contains(@class,'dropdown_menu')]/li/a[@href='/%s']";
    private final String HEADER_GENERAL_CATEGORY = "//ul[contains(@class,'dropdown_menu')]/li/a[@href='/%s']/..//a[contains(text(),'%s')]";

    protected SelenideElement exactTabElement(String tabValue) {
        return $x(format(HEADER_GENERAL_TAB, tabValue)).shouldBe(visible);
    }

    protected SelenideElement exactCategoryElement(String tabValue, String categoryValue) {
        return $x(format(HEADER_GENERAL_CATEGORY, tabValue, categoryValue)).shouldBe(interactable);
    }
}
