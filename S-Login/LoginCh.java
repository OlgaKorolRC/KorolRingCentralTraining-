import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginCh extends Login{

    @BeforeClass
    public static void setupWebdriverChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "D:\\JaveSE-P - Full\\chromedriver.exe");
    }

    @Before
    public void setup() {
        setupWebdriverChromeDriver();
        driver = new ChromeDriver();
    }
}
