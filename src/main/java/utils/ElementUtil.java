package utils;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class ElementUtil {

    public static void moveToElement(SelenideElement element) {
        actions().moveToElement(element).release().build().perform();
        sleep(300);
    }

    public static List<String> getListOfString(ElementsCollection listSE) {
        List<String> listSt = new ArrayList<>();

        for(SelenideElement element : listSE) {
            listSt.add(element.getText());
        }

        return listSt;
    }
}
