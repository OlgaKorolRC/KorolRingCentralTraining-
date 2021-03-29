import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static java.lang.System.out;
import static java.lang.System.setProperty;
import static java.lang.Thread.sleep;

public class AddUtya {
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
    public void addNewUtya() throws InterruptedException {
        String name = "Sherlock";
        login();
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog");
        driver.findElement(By.linkText("Add New Product")).click();
        General newUtyaGeneral = new General(driver);
        dataInGeneralTab(newUtyaGeneral, name);
        driver.findElement(By.linkText("Information")).click();
        Info newUtyaInfo = new Info(driver);
        dataInInformationTab(newUtyaInfo);
        driver.findElement(By.linkText("Prices")).click();
        Price newUtyaPrice = new Price(driver);
        dataInPricesTab(newUtyaPrice);
        driver.findElement(By.name("save")).click();
        checkNewUtya(name);
        sleep(500);
        out.println("Time to enjoy the added duck");
        deleteUtya(name);
    }

    public void login() {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    public void dataInGeneralTab(General newUtya, String name) throws InterruptedException {
        newUtya.getStatus().click();
        newUtya.getName().sendKeys(name);
        newUtya.getCode().sendKeys("125");
        General.uncheck(newUtya.getSelectCategories());
        General.checkDefaultCheckbox(newUtya.getSelectCategories());
        General.checkDefaultCategory(newUtya.getDefaultCategory());
        General.checkDefaultCheckbox(newUtya.getSelectGroup());
        newUtya.getQuantity().clear();
        newUtya.getQuantity().sendKeys("21");
        uploadFile();
        changeDate(newUtya.getDateFrom(), "08032021");
        changeDate(newUtya.getDateTo(), "05042021");
        sleep(500);
    }

    public void dataInInformationTab(Info newUtya) {
        newUtya.getManufacturer().selectByIndex(1);
        newUtya.getKeywords().sendKeys("KEYwords");
        newUtya.getShortDescription().sendKeys("This Utya is Sherlock Utya");
        newUtya.getDescription().sendKeys("You want to hide a tree, then a forest is the best place to do it.");
        newUtya.getHeadTitle().sendKeys("SherlockUtka");
        newUtya.getMetaDescription().sendKeys("Utka by Sir Arthur Ignatius Conan Doyle");
    }

    public void dataInPricesTab(Price newUtya) {
        newUtya.getPurchasePrice().clear();
        newUtya.getPurchasePrice().sendKeys("21");
        newUtya.getPrice().sendKeys("22");
    }

    public void checkNewUtya(String name) {
        driver.findElement(By.xpath("//table[@class='dataTable']//a[text()='" + name + "']"));
    }

    public void uploadFile() {
        File utkaFile = new File("D:\\JaveSE-P - Full", "utka.jpg");
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(utkaFile.getAbsolutePath());
    }

    public void changeDate(WebElement field, String date) {
        field.sendKeys(date);
    }

    public void deleteUtya(String name) {
        WebElement checkbox = driver.findElement(By.xpath("//table[@class='dataTable']//a[text()='" + name + "']/../preceding-sibling::td[2]/input"));
        checkbox.click();
        driver.findElement(By.name("delete")).click();
        if(driver.switchTo().alert() != null)
        {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            out.println("alertText " + alertText);
            alert.accept();
        }
    }
}
