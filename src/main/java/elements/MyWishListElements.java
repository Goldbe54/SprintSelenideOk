package elements;

import com.codeborne.selenide.SelenideElement;
import commom.BaseComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MyWishListElements  extends BaseComponent {
    private final String MY_WISHLIST_TITLES = "//div[@class='title']//a";
    private final String REMOVE_BUTTON = "(//span[@class='remove wrapper'])[%s]";

    protected SelenideElement tookWishListTitle (){
        return $x(MY_WISHLIST_TITLES).shouldBe(interactable);
    }
    protected SelenideElement removeFilmFromWishlist(){
        return $x(REMOVE_BUTTON).shouldBe(interactable);
    }
}
