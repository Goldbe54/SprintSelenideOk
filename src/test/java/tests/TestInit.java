package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import commom.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestInit {

    public static final Logger logger = LogManager.getLogger(BasePage.class);

    @Parameters({"browser", "headless"})
    @BeforeMethod
    public void setup(@Optional("chrome") String browser, @Optional("false") String headless) {
        Configuration.browser = browser;
        Configuration.headless = Boolean.parseBoolean(headless);
        Configuration.baseUrl = "https://www.themoviedb.org";
        Configuration.reportsFolder = "./target";
        Configuration.downloadsFolder = "/.target";
        Configuration.screenshots = false;
    }

    @AfterMethod
    public void shootDown() {
        Selenide.closeWebDriver();
    }
}