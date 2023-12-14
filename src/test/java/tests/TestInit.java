package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import commom.BasePage;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.open;

@Listeners(listeners.TestListener.class)
public class TestInit {

    public static final Logger logger = LogManager.getLogger(BasePage.class);

    @Step("Preparing a browser for the test")
    @Parameters({"browser", "headless"})
    @BeforeMethod
    public void setup(@Optional("chrome") String browser, @Optional("false") String headless) {
        Configuration.browser = browser;
        Configuration.headless = Boolean.parseBoolean(headless);
        Configuration.baseUrl = "https://www.themoviedb.org";
        Configuration.reportsFolder = "./target";
        Configuration.downloadsFolder = "/.target";
        Configuration.screenshots = false;

        open("/");
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @Step("Close driver")
    @AfterMethod
    public void shootDown() {
        Selenide.closeWebDriver();
    }
}