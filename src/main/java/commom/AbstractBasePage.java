package commom;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AbstractBasePage extends Base {

    public static final Logger logger = LogManager.getLogger(AbstractBaseTest.class);

    private static final int DURATION = 7;

    protected SelenideElement waitVisibilityOfElement(String locator) {
        return $(By.xpath(locator)).shouldBe(visible, Duration.ofSeconds(DURATION));
    }

    protected SelenideElement waitClickabilityOfElement(String locator) {
        return $(By.xpath(locator)).shouldBe(enabled, Duration.ofSeconds(DURATION));
    }

    protected SelenideElement waitPresenceOfElement(String locator) {
        return $(By.xpath(locator)).shouldBe(exist, Duration.ofSeconds(DURATION));
    }

    protected ElementsCollection waitPresenceOfElements(String locator) {
        return $$(By.xpath(locator)).shouldBe(CollectionCondition.sizeGreaterThan(0), Duration.ofSeconds(DURATION));
    }
}
