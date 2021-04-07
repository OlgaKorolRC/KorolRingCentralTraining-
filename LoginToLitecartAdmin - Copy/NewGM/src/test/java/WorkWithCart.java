import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import org.openqa.selenium.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static java.lang.System.setProperty;
import static java.lang.Thread.sleep;

public class WorkWithCart {

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
        int numberUtya = 3;
        int numberInCart;
        driver.get("http://localhost/litecart/en/");

        for (int i = 1; i <= numberUtya; i++) {
            numberInCart = addToCart(i);
            //System.out.println("in cart in for 1 " + numberInCart + " utya " + numberUtya);
            driver.findElement(By.xpath("//img[@title='My Store']")).click();
            //System.out.println("in cart in for 2 " + numberInCart + " utya " + numberUtya);

            System.out.println("i is " + i);
            if (numberInCart == numberUtya) {
                System.out.println("in cart " + numberInCart + " utya " + numberUtya);
                goToCart();
                deleteFromCart();
            }
        }
    }

    public int addToCart(int inCartNUmber){
        driver.findElement(By.xpath("//div[@class='content']//a[@class='link']")).click();
        WebElement inCart = driver.findElement(By.xpath("//span[@class='quantity']"));
        selectSize();
        driver.findElement(By.name("add_cart_product")).click();
        WebDriverWait wait = new WebDriverWait(driver, 2);
        //System.out.println("after wait");

        String expectedText = String.valueOf(inCartNUmber);
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//span[@class='quantity']")), expectedText));
        inCart = driver.findElement(By.xpath("//span[@class='quantity']"));
        System.out.println("new find " + Integer.parseInt(inCart.getText()));
        return Integer.parseInt(inCart.getText());
    }
    public void selectSize() {

        try {
            WebElement option = driver.findElement(By.xpath("//select[@name='options[Size]']"));
            System.out.println("Yellow Utya");
            Select size = new Select(option);
            size.selectByIndex(new Random(2).nextInt(4));
            sleep(500);
        } catch (NoSuchElementException | InterruptedException e) {
            System.out.println("Not yellow utya");
        }
    }

    public void goToCart(){
        System.out.println("In Cart !!!" );
        //driver.findElement(B)
        driver.findElement(By.partialLinkText("Checkout")).click();
        System.out.println("After click to checkout");
    }

    public void deleteFromCart(){
        System.out.println(" In Delete :) ");
        WebDriverWait wait = new WebDriverWait(driver, 2);

        List<WebElement> order = driver.findElements(By.xpath("//div[@id='box-checkout-summary']//td[@class='item']"));
        int waitedNumber = order.size();
        int currentNumber = order.size();
        System.out.println("order size = " + order.size());
        for (int i = 0; i < waitedNumber; i++) {
            driver.findElement(By.name("remove_cart_item")).click();
            System.out.println("waitedNumber " + waitedNumber + " currentNumber " + currentNumber);
            wait.until(ExpectedConditions.numberOfElementsToBe(
                    By.xpath("//div[@id='box-checkout-summary']//td[@class='item']"), currentNumber-1));
            order = driver.findElements(By.xpath("//div[@id='box-checkout-summary']//td[@class='item']"));
            currentNumber = order.size();
        }
    }
}
