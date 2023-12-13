package elements;

import com.codeborne.selenide.ElementsCollection;
import commom.BaseComponent;

public class BrowseProductElements extends BaseComponent {
    private final String USER_SCORE_ICON = "//span[contains(@class, 'icon icon')]";

    protected ElementsCollection allUserScoreIcon(){
        return waitPresenceOfElements(USER_SCORE_ICON);
    }
}
