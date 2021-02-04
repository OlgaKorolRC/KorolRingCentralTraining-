import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class LoginEI extends Login{

    @BeforeClass
    public static void setupWebdriverEIDriver() {
        System.setProperty("webdriver.ie.driver", "D:\\JaveSE-P - Full\\IEDriverServer.exe");
    }

    @Before
    public void setup() {
        setupWebdriverEIDriver();
        driver = new InternetExplorerDriver();
    }
}
