package utils;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class ElementUtil {

    public static SelenideElement moveToElement(SelenideElement element) {
        actions().moveToElement(element).release().build().perform();
        sleep(300);
        return element;
    }

    public static List<String> getListOfString(ElementsCollection listSE) {
        List<String> listSt = new ArrayList<>();

        for(SelenideElement element : listSE) {
            listSt.add(element.getText());
        }

        return listSt;
    }

    public static SelenideElement scrollToElement(SelenideElement element) {
        actions().scrollToElement(element).release().build().perform();
        return element;
    }

    public static void jsClick(SelenideElement element) {
        executeJavaScript("arguments[0].click();", element);
    }

    public static SelenideElement scrollToElementInCenterOfBlock(SelenideElement element) {
        String script = "arguments[0].scrollIntoView({block: 'center'});";

        executeJavaScript(script, element);

        return element;
    }
}
