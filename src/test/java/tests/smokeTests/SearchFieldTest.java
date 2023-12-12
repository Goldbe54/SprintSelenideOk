package tests.smokeTests;

import elements.HomeElements;
import elements.SearchResultElements;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeMethod;
import tests.TestInit;

import static com.codeborne.selenide.Selenide.open;

public class SearchFieldTest extends TestInit {

    HomeElements homeElements;
    SearchResultElements searchResultElements;

    @Step("Loading the Base Page")
    @BeforeMethod
    private void setUp() {

        homeElements  = new HomeElements();
        searchResultElements = new SearchResultElements();

        open("/");
    }
}
