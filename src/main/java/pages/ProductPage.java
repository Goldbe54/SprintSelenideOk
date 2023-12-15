package pages;

import com.codeborne.selenide.Selenide;
import elements.ProductElements;
import io.qameta.allure.Step;
import utils.ElementUtil;

import java.util.List;

public class ProductPage extends ProductElements {
    public List<String> getFilmGenres() {
        List<String> genres = ElementUtil.getListOfString(getGeners());
        return genres;
    }

    @Step("Add film to the WishList")
    public String addToWishList() {
        String title = getSpecificFirstTitleProduct(1).getText();

        getFirstProductContextMenu().click();
        getFirstProductWatchList().click();
        successAddToWatchList().isEnabled();
        Selenide.sleep(5000);

        return title;
    }
}
