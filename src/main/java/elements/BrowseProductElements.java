package elements;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import commom.AbstractBaseComponent;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;



public class BrowseProductElements extends AbstractBaseComponent {
    private final String USER_SCORE_ICON = "//span[contains(@class, 'icon icon')]";

    protected ElementsCollection allUserScoreIcon(){
        return $$x(USER_SCORE_ICON).shouldBe(CollectionCondition.sizeGreaterThan(0));
    }
}
