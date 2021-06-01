import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static java.lang.System.setProperty;

//class TestClass1 implements Runnable {
//    public void run() {
//        Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
//        capsHashtable.put("browser", "chrome");
//        capsHashtable.put("browser_version", "latest");
//        capsHashtable.put("os", "Windows");
//        capsHashtable.put("os_version", "10");
//        capsHashtable.put("build", "browserstack-build-1");
//        capsHashtable.put("name", "Thread 1");
//        Cloud r1 = new Cloud();
//        r1.executeTest(capsHashtable);
//    }
//}
//class TestClass2 implements Runnable {
//    public void run() {
//        Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
//        capsHashtable.put("browser", "firefox");
//        capsHashtable.put("browser_version", "latest");
//        capsHashtable.put("os", "Windows");
//        capsHashtable.put("os_version", "10");
//        capsHashtable.put("build", "browserstack-build-1");
//        capsHashtable.put("name", "Thread 2");
//        Cloud r2 = new Cloud();
//        r2.executeTest(capsHashtable);
//    }
//}
//class TestClass3 implements Runnable {
//    public void run() {
//        Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
//        capsHashtable.put("browser", "safari");
//        capsHashtable.put("browser_version", "latest");
//        capsHashtable.put("os", "OS X");
//        capsHashtable.put("os_version", "Big Sur");
//        capsHashtable.put("build", "browserstack-build-1");
//        capsHashtable.put("name", "Thread 3");
//        Cloud r3 = new Cloud();
//        r3.executeTest(capsHashtable);
//    }
//}

public class Cloud {
    public WebDriver driver;

    @AfterClass
    public void stop() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    @BeforeClass
    public void setup() {
//        setProperty("webdriver.chrome.driver", "D:\\JaveSE-P - Full\\chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
        capsHashtable.put("browser", "chrome");
        capsHashtable.put("browser_version", "latest");
        capsHashtable.put("os", "Windows");
        capsHashtable.put("os_version", "10");
        capsHashtable.put("build", "browserstack-build-1");
        capsHashtable.put("name", "Thread 1");
    }

    public static final String USERNAME = "olgakorol1";
    public static final String AUTOMATE_KEY = "CYLHDjsiyps67s5nxxxx";
    public static final String URL1 = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Test
    public void executeTest(Hashtable<String, String> capsHashtable) {
        String key;
        DesiredCapabilities caps = new DesiredCapabilities();
        // Iterate over the hashtable and set the capabilities
        Set<String> keys = capsHashtable.keySet();
        Iterator<String> itr = keys.iterator();
        while (itr.hasNext()) {
            key = itr.next();
            caps.setCapability(key, capsHashtable.get(key));
        }
        WebDriver driver;
        try {
            driver = new RemoteWebDriver(new URL(URL1), caps);
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            // Searching for 'BrowserStack' on google.com
            driver.get("https://www.google.com");
            WebElement element = driver.findElement(By.name("q"));
            element.sendKeys("BrowserStack");
            element.submit();
            // Setting the status of test as 'passed' or 'failed' based on the condition; if title of the web page contains 'BrowserStack'
            WebDriverWait wait = new WebDriverWait(driver, 5);
            try {
                wait.until(ExpectedConditions.titleContains("BrowserStack"));
                jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Title matched!\"}}");
            }
            catch(Exception e) {
                jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Title not matched\"}}");
            }
            System.out.println(driver.getTitle());
            driver.quit();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
