import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import static java.lang.System.setProperty;

public class LinkInNewWindow {
    public WebDriver driver;

    @BeforeClass
    public void setup() {
        setProperty("webdriver.chrome.driver", "D:\\JaveSE-P - Full\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterClass
    public void stop() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    @Test
    public void openLink() {
        login();
        driver.findElement(By.xpath("//span[text()='Countries']")).click();
        driver.findElement(By.xpath("//tr[@class='row']/td[5]/a")).click();
        String mainW = driver.getWindowHandle();
        System.out.println("mainW is " + mainW);
        List<WebElement> listExLink = driver.findElements(By.xpath("//form[@method='post']//a[@target='_blank']"));
        System.out.println("Number link is " + listExLink.size());
        String[] linkArray = new String[listExLink.size()];
        for (int i = 0; i < listExLink.size(); i++) {
            linkArray[i] = listExLink.get(i).getAttribute("href");
            System.out.println(linkArray[i] + " " + i);
        }

        for (int i = 0; i < linkArray.length; i++) {
            WebDriverWait wait = new WebDriverWait(driver, 2);
            driver.findElement(By.xpath("//a[contains(@href,'" + linkArray[i] + "')]")).click();
            ArrayList<String> openedTab = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(openedTab.get(1));
            driver.close();
            driver.switchTo().window(openedTab.get(0));

        }

    }

    public void login() {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }
}
