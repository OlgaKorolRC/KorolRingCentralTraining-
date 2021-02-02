import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import static java.lang.Thread.sleep;

public class LoginEI {
    private WebDriver driver;

    @BeforeClass
    public static void setupWebdriverEIDriver() {
        System.setProperty("webdriver.ie.driver", "D:\\JaveSE-P\\IEDriverServer.exe");
    }

    @Before
    public void setup() {
        setupWebdriverEIDriver();
        driver = new InternetExplorerDriver();
    }

    @Test
    public void loginAsAdmin() throws InterruptedException {
        driver.get("http://localhost/litecart/admin/");
        sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"box-login\"]/form/div[1]/table/tbody/tr[1]/td[2]/span/input")).sendKeys("admin");
        sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"box-login\"]/form/div[1]/table/tbody/tr[2]/td[2]/span/input")).sendKeys("admin");
        sleep(1000);
        driver.findElement(By.xpath("/html/body/table/tbody/tr/td/div/div/form/div[2]/button")).click();
        sleep(1000);
    }

    @After
    public void stop() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
