import org.testng.annotations.BeforeClass;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class LoginFFN extends Login{

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "D:\\JaveSE-P - Full\\geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("C:\\Program Files\\Firefox Nightly\\firefox.exe");
        options.setProfile(new FirefoxProfile());
        driver = new FirefoxDriver(options);
    }
}
