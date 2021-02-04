import org.junit.Before;
import org.junit.BeforeClass;

import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginFF extends Login{

    @BeforeClass
    public static void setupWebdriverFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", "D:\\JaveSE-P - Full\\geckodriver.exe");
    }

    @Before
    public void setup() {
    setupWebdriverFirefoxDriver();
    driver = new FirefoxDriver();
    }
}