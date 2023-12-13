package elements;

import com.codeborne.selenide.SelenideElement;
import commom.AbstractBaseComponent;

public class MyWishListElements  extends AbstractBaseComponent {
    private final String MY_WISHLIST_TITLE = "//div[@class='title']//a[@href='/movie/726209']";

    protected SelenideElement tookWishListTitle (){
        return waitVisibilityOfElement(MY_WISHLIST_TITLE);
    }
}
