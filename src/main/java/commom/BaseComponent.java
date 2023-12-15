package commom;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;
import java.time.Duration;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.*;

public class BaseComponent extends BasePage {
    private final String HEADER_GENERAL_TAB = "//ul[contains(@class,'dropdown_menu')]/li/a[@href='/%s']";
    private final String HEADER_GENERAL_CATEGORY = "//ul[contains(@class,'dropdown_menu')]/li/a[@href='/%s']/..//a[contains(text(),'%s')]";
    private final String HEADER_LOGIN_BUTTON ="//li/a[@href=\"/login\"]";
    private final String TMDB_LOGO="//a/img[@alt='The Movie Database (TMDB)']";
    private final String USER_PROFILE = "//a[@class='no_click tooltip_hover']";
    private final String PROFILE_WATCH_LIST="//div[@class='k-tooltip-content']//a[@href='/u/FreshNO9/watchlist']";
    private final String SUCCESS_ADD_TO_WATCH_LIST="//p[contains(text(),'added')]";

    protected SelenideElement exactTabElement(String tabValue) {
        return $x(format(HEADER_GENERAL_TAB, tabValue)).shouldBe(visible);
    }

    protected SelenideElement exactCategoryElement(String tabValue, String categoryValue) {
        return $x(format(HEADER_GENERAL_CATEGORY,tabValue,categoryValue)).shouldBe(visible);
    }

    protected SelenideElement heagerLoginElement() {
        return $x(HEADER_LOGIN_BUTTON).shouldBe(visible);
    }

    protected SelenideElement getTmdbLogo(){
        return $x(TMDB_LOGO).shouldBe(visible);
    }

    protected SelenideElement getUserProfile(){
        return $x(USER_PROFILE).shouldBe(visible);
    }

    protected SelenideElement getProfileWatchList(){
        return $x(PROFILE_WATCH_LIST).shouldBe(visible);
    }

    protected SelenideElement successAddToWatchList(){ return $x(SUCCESS_ADD_TO_WATCH_LIST).shouldBe(exist);}

}