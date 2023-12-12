package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import elements.BrowseProductElements;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.elements;

public class BrowseProductPage extends BrowseProductElements {

    @Step("Select a {0} tab, {1} categoty")
    public BrowseProductElements enterThePage(String tab, String category) {
        exactTabElement(tab).click();
        exactCategoryElement(tab,category).click();

        return this;
    }

    @Step("Get user scores")
    public List<Integer> getScores() {
        List<Integer> scores = new ArrayList<>();
        ElementsCollection elements = allUserScoreIcon();

        for (SelenideElement element : elements) {
            scores.add(Integer.parseInt(element.getAttribute("class").replaceAll("[^0-9]", "")));
        }

        return scores;
    }
}
