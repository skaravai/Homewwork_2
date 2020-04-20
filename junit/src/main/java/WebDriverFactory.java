import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    public static WebDriver create(Browser webDriverName){
        WebDriver driver;
        WebDriverManager driverManager;

        switch (webDriverName) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + webDriverName);
        }

        driverManager.setup();

        switch (webDriverName) {
            case CHROME:
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + webDriverName);
        }

        return driver;
    }

    public static WebDriver create(Browser webDriverName, Capabilities options){
        WebDriver driver;
        WebDriverManager driverManager;

        switch (webDriverName) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + webDriverName);
        }

        driverManager.setup();

        switch (webDriverName) {
            case CHROME:
                driver = new ChromeDriver(options);
                break;
            case FIREFOX:
                driver = new FirefoxDriver(options);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + webDriverName);
        }

        return driver;
    }

}


