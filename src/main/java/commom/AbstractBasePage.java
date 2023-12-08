package commom;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.Condition;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class AbstractBasePage extends Base{

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
