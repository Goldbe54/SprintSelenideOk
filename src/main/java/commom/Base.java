package commom;

import io.qameta.allure.Attachment;
import lombok.SneakyThrows;

import java.io.File;

public class Base {

    protected static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

//    @SneakyThrows
//    @Attachment(value = "Page screenshot", type = "image/png")
//    protected static byte[] captureScreen() {
//    }
}
