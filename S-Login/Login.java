import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class Login {

    private WebDriver driver;

    @BeforeClass
    public static void setupWebdriverChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "D:\\JaveSE-P\\chromedriver.exe");
    }

    @Before
    public void setup() {
        setupWebdriverChromeDriver();
        driver = new ChromeDriver();
    }

    @Test
    public void loginAsAdmin() throws InterruptedException {
        driver.get("http://localhost/litecart/admin/");
        sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"box-login\"]/form/div[1]/table/tbody/tr[1]/td[2]/span/input")).sendKeys("admin");
        sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"box-login\"]/form/div[1]/table/tbody/tr[2]/td[2]/span/input")).sendKeys("admin");
        sleep(5000);
        driver.findElement(By.name("login")).click();
        sleep(5000);
    }

    @After
    public void stop() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
