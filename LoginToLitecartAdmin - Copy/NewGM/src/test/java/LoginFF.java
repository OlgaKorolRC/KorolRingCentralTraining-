import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

public class LoginFF extends Login{

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "D:\\JaveSE-P - Full\\geckodriver.exe");
        driver = new FirefoxDriver();
    }
}