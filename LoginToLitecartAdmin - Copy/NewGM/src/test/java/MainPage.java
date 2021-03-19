import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class MainPage {

    public WebDriver driver;

    @AfterClass
    public void stop() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    @Parameters({"browser"})
    @BeforeClass
    public void setUp(String browser) {//throws MalformedURLException{
        if(browser.equalsIgnoreCase("iexplore")){
            System.setProperty("webdriver.ie.driver", "D:\\JaveSE-P - Full\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();

        }
        if(browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", "D:\\JaveSE-P - Full\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "D:\\JaveSE-P - Full\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("http://localhost/litecart/");
        }
    }
}
