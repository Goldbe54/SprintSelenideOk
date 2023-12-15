package tests.smokeTests;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;
import tests.TestInit;

import static utils.ConfigProvider.LOGIN;
import static utils.ConfigProvider.PASSWORD;

public class CheckWishlistTest extends TestInit {

    HomePage homePage;
    ProductPage productPage;
    LoginPage loginPage;
    MyWishListPage myWishListPage;
    BrowseProductPage browseProductPage;
    SoftAssert softAssert;
    private String tab = "movie";
    private String category = "Top Rated";

    @Step("Loading the Base Page")
    @BeforeMethod
    private void setUp() {

        homePage = new HomePage();
        loginPage = new LoginPage();
        browseProductPage = new BrowseProductPage();
        myWishListPage = new MyWishListPage();
        productPage = new ProductPage();
        softAssert = new SoftAssert();
    }

    @Test(description = "PQ-35")
    @Description("Check Watchlist")
    private void checkTheWatchList() {

        loginPage.logInAtAccount(LOGIN, PASSWORD);
        homePage.passToHomePage();
        browseProductPage.enterThePage(tab, category);

        String titleFromAddedToWishList = productPage.addToWishList();

        homePage.setProfileWatchList();

        String titleFromWishList = myWishListPage.tookFilmTitle();

        Assert.assertEquals(titleFromWishList, titleFromAddedToWishList, "Titles are not equal");
    }

    @AfterMethod
    private void endUp() {
        myWishListPage.removeFilmFromWishList();
    }
}
