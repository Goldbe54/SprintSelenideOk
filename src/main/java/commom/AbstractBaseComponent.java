package commom;

import com.codeborne.selenide.SelenideElement;

import static java.lang.String.*;

public class AbstractBaseComponent extends AbstractBasePage {
    private final String HEADER_GENERAL_TAB = "//ul[contains(@class,'dropdown_menu')]/li/a[@href='/%s']";
    private final String HEADER_GENERAL_CATEGORY = "//ul[contains(@class,'dropdown_menu')]/li/a[@href='/%s']/..//a[contains(text(),'%s')]";

    protected SelenideElement exactTabElement(String tabValue) {
        return waitClickabilityOfElement(format(HEADER_GENERAL_TAB, tabValue));
    }

    protected SelenideElement exactCategoryElement(String tabValue, String categoryValue) {
        return waitClickabilityOfElement(format(HEADER_GENERAL_CATEGORY,tabValue,categoryValue));
    }
}
