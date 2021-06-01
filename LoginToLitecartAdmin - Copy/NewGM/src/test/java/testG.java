import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.System.out;
import static java.lang.System.setProperty;
import static java.lang.Thread.sleep;
import org.openqa.selenium.remote.DesiredCapabilities;

public class testG {
    public WebDriver driver;


    @AfterClass
    public void stop() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    @BeforeClass
    public void setup() throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
        DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
        capability.setBrowserName("internet explorer");
        capability.setPlatform(Platform.valueOf("WINDOWS"));
        //capability.setVersion("1809");

//        DesiredCapabilities capability = DesiredCapabilities.firefox();
//        capability.setBrowserName("firefox");
//        capability.setPlatform(Platform.valueOf("WIN10"));
//        //capability.setVersion("70.0.1");

        setProperty("webdriver.ie.driver", "D:\\JaveSE-P - Full\\IEDriverServer.exe");
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.2:4444/wd/hub"), capability);
        //driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    @Test
    public void alfSortCounties() throws InterruptedException {
        driver.get("https://www.google.com/");
        sleep(500);
        driver.findElement(By.xpath("//span[@class='hOoLGe']")).click();
        sleep(500);

    }
}
