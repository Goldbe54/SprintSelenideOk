package tests.smokeTests;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.SearchPage;
import tests.TestInit;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;

public class SearchFieldTest extends TestInit {

    HomePage homePage;
    SearchPage searchPage;
    List<String> searchResults;
    SoftAssert softAssert;

    private String searchQuery = "Barbie";

    @BeforeMethod
    private void setUp() {
        homePage = new HomePage();
        searchPage = new SearchPage();
        softAssert = new SoftAssert();
    }


    @Test(description = "PQ-34")
    @Description("Check the search field")
    private void searchFieldTest() {

        homePage.setSearchQuery(searchQuery);
        searchResults = searchPage.getSearchResults();

        for (String name : searchResults) {
           softAssert.assertTrue(name.contains(searchQuery), "Asser false:" + name);
        }
        softAssert.assertAll();
    }
}