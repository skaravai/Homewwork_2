import org.apache.commons.lang3.EnumUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class MyTest {
    protected static WebDriver driver;
    private String baseURL = "https://market.yandex.ru/";
    private Logger logger = LogManager.getLogger(MyTest.class);

    @Before
    public void setUp() {
        String browserName = System.getProperty("browser");
        Browser browser = EnumUtils.getEnumIgnoreCase(Browser.class, browserName);

        if (null == browser) {
            browser = Browser.FIREFOX;
        }

        logger.info("Указан драйвер " + browser);

        driver = WebDriverFactory.create(browser);
        logger.info("Драйвер поднят");
    }

    @Test
    public void openPage() {
        driver.get(baseURL);
        logger.info("Открыта страница Яндекс.Маркет");
    }

    @After
    public void setDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}




