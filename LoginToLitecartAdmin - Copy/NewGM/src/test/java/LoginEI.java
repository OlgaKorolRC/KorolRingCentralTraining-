import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;


public class LoginEI extends Login{

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.ie.driver", "D:\\JaveSE-P - Full\\IEDriverServer.exe");
        driver = new InternetExplorerDriver();
    }
}
