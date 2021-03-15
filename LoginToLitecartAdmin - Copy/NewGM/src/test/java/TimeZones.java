import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.System.*;
import static java.lang.Thread.sleep;

public class TimeZones extends Login {

    @BeforeClass
    public void setup() {
        setProperty("webdriver.chrome.driver", "D:\\JaveSE-P - Full\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    @Test
    public void alfSortCounties() throws InterruptedException {
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        sleep(500);
        List<WebElement> elementsC = driver.findElements(By.xpath("//tr[@class='row']/td[5]"));
        out.println("Number of countries: " + elementsC.size());
        isSorted(elementsC);
    }

    @Test
    public void notNullTZ() throws InterruptedException {
        int numberFull = 0;
        List<WebElement> elementsN = driver.findElements(By.xpath("//tr[@class='row']/td[6]"));
        Integer[] countryN = new Integer[elementsN.size()];
        List<WebElement> linkToCountry = driver.findElements(By.xpath("//tr[@class='row']/td[5]/a[@href]"));
        out.println("Number of links: " + linkToCountry.size());
        String[] fullCountry = new String[linkToCountry.size()];

        for (int i = 0; i < linkToCountry.size(); i++) {
            fullCountry[i] = linkToCountry.get(i).getAttribute("href");
            countryN[i] = Integer.valueOf(elementsN.get(i).getAttribute("textContent"));
        }


        for (int i = 0; i < elementsN.size(); i++) {
            if (countryN[i] > 0) {
                out.println("This country is " + fullCountry[i]);
                driver.findElement(By.xpath("//a[contains(@href,'" + fullCountry[i] + "')]")).click();
                sleep(5000);
                checkInCountry();
                driver.navigate().back();
                sleep(5000);
                numberFull++;
            }
        }

        out.println("Not null " + numberFull);
        out.println(Arrays.toString(countryN));
    }

    public void checkInCountry() {
        List<WebElement> elementsInC = driver.findElements(By.xpath("//table[@class=\"dataTable\"]/tbody/tr/td[3]/input[@type=\"hidden\"]/.."));
        out.println("Size is " + elementsInC.size());
        isSorted(elementsInC);
    }

    public boolean isSorted(List<WebElement> newlist) {
        List<String> originList = new ArrayList<>();
        List<String> sortList = new ArrayList<>();
        for (int i = 0; i < newlist.size(); i++) {
            originList.add(newlist.get(i).getText());
            sortList.add(newlist.get(i).getText());
        }
        out.println(Arrays.toString(originList.toArray()));

        Collections.sort(sortList);
        boolean inOrder = originList.equals(sortList);
        if (inOrder) {
            out.println("Order is correct.");
            return true;
        } else {
            out.println("Order is incorrect :( ");
            return false;
        }
    }

}

