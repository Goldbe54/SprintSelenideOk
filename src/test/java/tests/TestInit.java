package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;
import utils.SuiteConfiguration;

import static com.codeborne.selenide.Selenide.open;

public class TestInit {

    public static final Logger logger = LogManager.getLogger(TestInit.class);
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


    @Parameters({"browser", "headless"})
    @BeforeMethod
    public void setup(@Optional("chrome") String browser, @Optional("false") String headless) {
        Configuration.browser = browser;
        Configuration.headless = Boolean.parseBoolean(headless);
        Configuration.baseUrl = "https://www.themoviedb.org";

        open("/");
        WebDriverRunner.getWebDriver().manage().window().maximize();

    }

    @AfterMethod
    public void shootDown() {
        Selenide.closeWebDriver();
    }
}
