package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestInit {

    @Parameters({"browser", "headless"})
    @BeforeMethod
    public void setup(@Optional("chrome") String browser, @Optional("false") String headless) {
        Configuration.browser = browser;
        Configuration.headless = Boolean.parseBoolean(headless);
        Configuration.baseUrl = "https://www.themoviedb.org";

    }

    @AfterMethod
    public void shootDown() {
        Selenide.closeWebDriver();
    }
}
