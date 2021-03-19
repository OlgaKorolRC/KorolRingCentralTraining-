import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.System.out;
import static java.lang.System.setProperty;
import static java.lang.Thread.sleep;

public class NewUser {
    public WebDriver driver;

    @BeforeClass
    public void setup() {
        setProperty("webdriver.chrome.driver", "D:\\JaveSE-P - Full\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    @AfterClass
    public void stop() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    @Test
    public void checkNewUser() throws InterruptedException {
        User user = new User();
        out.println(user.toString());
        driver.get("http://localhost/litecart/en/create_account");
        enterValues(user);
        driver.findElement(By.tagName("button")).click();
        driver.findElement(By.linkText("Logout")).click();
        loginAgain(user);
        driver.findElement(By.linkText("Logout")).click();


    }

    public void enterValues(User currentUser) throws InterruptedException {
        driver.findElement(By.name("tax_id")).sendKeys(Integer.toString(currentUser.taxID));
        driver.findElement(By.name("company")).sendKeys(currentUser.company);
        driver.findElement(By.name("firstname")).sendKeys(currentUser.firstName);
        driver.findElement(By.name("lastname")).sendKeys(currentUser.lastName);
        driver.findElement(By.name("address1")).sendKeys(currentUser.address1);
        driver.findElement(By.name("address2")).sendKeys(Integer.toString(currentUser.address2));
        driver.findElement(By.name("postcode")).sendKeys(Integer.toString(currentUser.postcode));
        driver.findElement(By.name("city")).sendKeys(currentUser.city);
        driver.findElement(By.xpath("//span[@class='select2-selection__rendered']")).click();
        driver.findElement(By.xpath("//li[text()='United States']")).click();
        Select zone = new Select(driver.findElement(By.xpath("//select[@name='zone_code']")));
        zone.selectByIndex(currentUser.zone);
        driver.findElement(By.name("email")).sendKeys(currentUser.email);
        driver.findElement(By.name("phone")).sendKeys(currentUser.phone);
        driver.findElement(By.name("password")).sendKeys(currentUser.password);
        driver.findElement(By.name("confirmed_password")).sendKeys(currentUser.password);

    }

    public void loginAgain(User currentUser) {
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(currentUser.email);
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(currentUser.password);
        driver.findElement(By.name("login")).click();
    }
}
