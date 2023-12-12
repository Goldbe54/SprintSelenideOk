package elements;

import com.codeborne.selenide.ElementsCollection;
import commom.AbstractBaseComponent;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class BrowseProductElements extends AbstractBaseComponent {
    private final String USER_SCORE_ICON = "//span[contains(@class, 'icon icon')]";

    protected ElementsCollection allUserScoreIcon(){
        return waitPresenceOfElements(USER_SCORE_ICON);
    }
}
