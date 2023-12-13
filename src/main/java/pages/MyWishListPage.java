package pages;

import elements.MyWishListElements;

public class MyWishListPage extends MyWishListElements {

    public MyWishListPage tookFilmTitle(){
        tookWishListTitle().getText();
        return this;
    }
}
