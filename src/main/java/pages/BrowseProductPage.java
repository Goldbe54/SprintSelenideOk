package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import commom.BasePage;
import elements.BrowseProductElements;
import io.qameta.allure.Step;
import utils.ElementUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BrowseProductPage extends BrowseProductElements {

    @Step("Select a {0} tab, {1} categoty")
    public BrowseProductElements enterThePage(String tab, String category) {
        exactTabElement(tab).click();
        exactCategoryElement(tab, category).click();

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

    @Step("Apply random Genre filter")
    public String selectRandomGenreFilter() {
        List<String> allGenres = ElementUtil.getListOfString(allGenresSelectors());

        if (!allGenres.isEmpty()) {
            int randomIndex = new Random().nextInt(allGenres.size());
            String selectedGenre = allGenres.get(randomIndex);

            ElementUtil.jsClick(specificGenreSelector(randomIndex+1));
            BasePage.logger.info("Random genre selected: " + selectedGenre);
            ElementUtil.scrollToElementInCenterOfBlock(searchByFiltersButton()).click();
            Selenide.sleep(1000);

            return selectedGenre;
        } else {
            BasePage.logger.warn("--== The list of genres is emptу ==--");
            throw new RuntimeException("--== The list of genres is emptу ==--");
        }
    }

    @Step("Select the first product")
    public ProductPage selectFirstProduct() {
        getSpecificProductPicture(1).click();
        return new ProductPage();
    }
}