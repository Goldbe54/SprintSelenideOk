package tests.smokeTests;

import elements.BrowseProductElements;
import elements.ProductElements;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BrowseProductPage;
import pages.ProductPage;
import tests.TestInit;

import java.util.List;

public class GenresFilterTest extends TestInit {
    private String tab = "movie";
    private String category = "Top Rated";
    private String expectedGenre;
    private List<String> actualGenres;
    BrowseProductPage browseProductPage;
    ProductPage productPage;
    SoftAssert softAssert;

    @BeforeMethod
    private void setUp() {
        browseProductPage = new BrowseProductPage();
        productPage = new ProductPage();
        softAssert = new SoftAssert();
    }

    @Test(description = "PQ-33")
    @Description("Checking the serviceability of filters for one genre")
    public void oneGenreTest() {
        browseProductPage.enterThePage(tab,category);

        expectedGenre = browseProductPage.selectRandomGenreFilter();

        browseProductPage.selectFirstProduct();

        actualGenres = productPage.getFilmGenres();

        softAssert.assertTrue(actualGenres.stream().anyMatch(genre -> genre.equals(expectedGenre)));
        softAssert.assertAll();
    }
}
