import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class LoginFFN extends Login{

    @BeforeClass
    public static void setupWebdriverFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", "D:\\JaveSE-P - Full\\geckodriver.exe");
    }

    @Before
    public void setup() {
        setupWebdriverFirefoxDriver();
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("C:\\Program Files\\Firefox Nightly\\firefox.exe");
        options.setProfile(new FirefoxProfile());
        driver = new FirefoxDriver(options);
    }
}
