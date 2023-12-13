package commom;

import com.codeborne.selenide.Screenshots;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BasePage {

    public static final Logger logger = LogManager.getLogger(BasePage.class);

    @SneakyThrows
    @Attachment(value = "Page screenshot", type = "image/png")
    protected static byte[] captureScreen() {
        File screenshot = Screenshots.takeScreenShotAsFile();
        FileUtils.copyFile(screenshot, new File("./target/allure-results//" + screenshot.getName()));
        logger.info("Screenshot taken:" + screenshot.getName());
        return Files.toByteArray(screenshot);
    }

    protected static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

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
