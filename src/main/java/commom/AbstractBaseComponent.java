package commom;

import com.codeborne.selenide.SelenideElement;

import static java.lang.String.*;

public class AbstractBaseComponent extends BasePage {
    private final String HEADER_GENERAL_TAB = "//ul[contains(@class,'dropdown_menu')]/li/a[@href='/%s']";
    private final String HEADER_GENERAL_CATEGORY = "//ul[contains(@class,'dropdown_menu')]/li/a[@href='/%s']/..//a[contains(text(),'%s')]";
    private final String HEADER_LOGIN_BUTTON ="//li/a[@href=\"/login\"]";
    private final String TMDB_LOGO="//a/img[@alt='The Movie Database (TMDB)']";
    private final String USER_PROFILE = "//a[@class='no_click tooltip_hover']";
    private final String PROFILE_WATCH_LIST="//div[@id='settings_tooltip']//a[@href='/u/FreshNO9/watchlist']";

    protected SelenideElement exactTabElement(String tabValue) {
        return waitClickabilityOfElement(format(HEADER_GENERAL_TAB, tabValue));
    }

    protected SelenideElement exactCategoryElement(String tabValue, String categoryValue) {
        return waitClickabilityOfElement(format(HEADER_GENERAL_CATEGORY,tabValue,categoryValue));
    }

    protected SelenideElement heagerLoginElement() {
        return waitClickabilityOfElement(HEADER_LOGIN_BUTTON);
    }

    protected SelenideElement getTmdbLogo(){
        return waitClickabilityOfElement(TMDB_LOGO);
    }

    protected SelenideElement getUserProfile(){
        return waitClickabilityOfElement(USER_PROFILE);
    }

    protected SelenideElement getProfileWatchList(){
        return waitClickabilityOfElement(PROFILE_WATCH_LIST);
    }
}
