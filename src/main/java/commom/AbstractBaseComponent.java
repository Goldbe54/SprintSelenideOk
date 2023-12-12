package commom;

import com.codeborne.selenide.SelenideElement;

import static java.lang.String.format;

public class AbstractBaseComponent extends AbstractBasePage {
    private final String HEADER_GENERAL_TAB = "//ul[contains(@class,'dropdown_menu')]/li/a[@href='/%s']";
    private final String HEADER_GENERAL_SUBTAB = "//ul[contains(@class,'dropdown_menu')]/li/a[@href='/%s']/..//a[contains(text(),'%s')]";

    protected SelenideElement exactTabElement(String tabValue) {
        return waitClickabilityOfElement(format(HEADER_GENERAL_TAB, tabValue));
    }

    protected SelenideElement exactSubtabElement(String tabValue, String subtabValue) {
        return waitClickabilityOfElement(format(HEADER_GENERAL_SUBTAB, tabValue, subtabValue));
    }
}
