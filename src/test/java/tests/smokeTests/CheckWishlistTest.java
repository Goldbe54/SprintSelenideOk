package tests.smokeTests;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import pages.MyWishListPage;
import tests.TestInit;

import static utils.ConfigProvider.LOGIN;
import static utils.ConfigProvider.PASSWORD;

public class CheckWishlistTest extends TestInit {

    HomePage homePage;
    LoginPage loginPage;
    MyWishListPage myWishListPage;
    SoftAssert softAssert;

    @Step("Loading the Base Page")
    @BeforeMethod
    private void setUp() {

        homePage = new HomePage();
        loginPage = new LoginPage();
        myWishListPage = new MyWishListPage();
        softAssert = new SoftAssert();
    }

    @Test(description = "PQ-35")
    @Description("Check Watchlist")
    private void checkTheWatchList() {

        loginPage.logInAtAccount(LOGIN, PASSWORD);
        homePage.passToHomePage();
        String titleFromAddedToWishList = homePage.addToWishList();
        homePage.setProfileWatchList();
        String titleFromWishList = myWishListPage.tookFilmTitle();

        Assert.assertEquals(titleFromWishList, titleFromAddedToWishList, "Titles are not equal");
    }

}
