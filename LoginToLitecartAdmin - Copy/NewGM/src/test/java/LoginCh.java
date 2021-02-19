import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class LoginCh extends Login{

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\JaveSE-P - Full\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    @Test
    public void clickMenu() {
        List<WebElement> elements = driver.findElements(By.id("app-"));
        String[] leftMenu = new String[elements.size()];

        System.out.println("Number of elements: " + elements.size());
        for (int i = 0; i < elements.size(); i++) {
            leftMenu[i] = elements.get(i).getText();
        }
        System.out.println(Arrays.toString(leftMenu));

        for (String menu: leftMenu) {
            System.out.println("Clickable menu: " + menu);
            driver.findElement(By.xpath("//li[@id='app-' and descendant::span[text()='"+menu+"']]")).click();
            clickSubMenu();
        }
    }

    public void clickSubMenu() {
        List<WebElement> subElements = driver.findElements(By.xpath("//li[contains(@id, 'doc')]"));
        String[] leftSubMenu = new String[subElements.size()];
        System.out.println("Number of sub elements: " + subElements.size());

        for (int i = 0; i < subElements.size(); i++) {
            leftSubMenu[i] = subElements.get(i).getText();
        }
        System.out.println(Arrays.toString(leftSubMenu));

        for (String subMenu: leftSubMenu) {
            System.out.println("Clickable SUB menu: " + subMenu);
            driver.findElement(By.xpath("//li[contains(@id, 'doc') and descendant::span[text()='"+subMenu+"']]")).click();
            checkText();
        }
    }

    public void checkText() {
        try {
            driver.findElement(By.xpath("//*[@id=\"content\"]/h1"));
        }
        catch (NoSuchElementException exception) {
            System.out.println("No element with h1");
        }
    }
}
