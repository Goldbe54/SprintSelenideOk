package pages;

import com.codeborne.selenide.SelenideElement;
import elements.MyWishListElements;

public class MyWishListPage extends MyWishListElements {

    public String tookFilmTitle(){
        SelenideElement titleProduct = tookWishListTitle();
        String title = titleProduct.getText();
        return title;
    }

    public MyWishListPage removeFilmFromWishList(){
        removeFilmFromWishlist().click();
        return this;
    }
}
