package commom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.codeborne.selenide.Screenshots;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

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
}