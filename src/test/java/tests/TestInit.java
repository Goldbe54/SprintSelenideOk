package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import commom.BasePage;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;
import utils.SuiteConfiguration;

import static com.codeborne.selenide.Selenide.open;

@Listeners(listeners.TestListener.class)
public class TestInit {

    public static final Logger logger = LogManager.getLogger(BasePage.class);
    private String environment;
    private  Boolean headless;
    private  String browser;

    @BeforeSuite(alwaysRun = true)
    @SneakyThrows
    public void initTestSuite() {
        SuiteConfiguration config = new SuiteConfiguration();
        environment = config.getProperty("site.url");
        headless = Boolean.parseBoolean(config.getProperty("headless"));
        browser = config.getProperty("browser.mode");
    }


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

        logger.info("Preparing a browser for the test");
    }

    @Step("Close driver")
    @AfterMethod
    public void shootDown() {
        Selenide.closeWebDriver();
    }
}
