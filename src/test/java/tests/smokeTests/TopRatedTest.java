package tests.smokeTests;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BrowseProductPage;
import tests.TestInit;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.open;

public class TopRatedTest extends TestInit {
    private String tab = "movie";
    private String category = "Top Rated";
    List<Integer> scores;
    BrowseProductPage browseProductPage;
    SoftAssert softAssert;

    @BeforeMethod
    public void setUp() {
        browseProductPage = new BrowseProductPage();
        softAssert = new SoftAssert();
    }

    @Test(description = "PQ-27")
    @Description("Check sorting by rating")
    public void checkSortByRating() {
        browseProductPage.
                enterThePage(tab,category);

        scores = browseProductPage.getScores();

        for(int i = 0; i < scores.size()-1; i++) {
            int currentValue = scores.get(i);
            int nextValue = scores.get(i++);
            softAssert.assertTrue(currentValue <= nextValue);
        }
        softAssert.assertAll();
    }
}
