import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

import static java.lang.Thread.sleep;

public class UtyaPageApplication extends forAllTests{
    public static int addToCart(int inCartNUmber){
        driver.findElement(By.xpath("//div[@class='content']//a[@class='link']")).click();
        WebElement inCart = driver.findElement(By.xpath("//span[@class='quantity']"));
        selectSize();
        driver.findElement(By.name("add_cart_product")).click();
        WebDriverWait wait = new WebDriverWait(driver, 2);


        String expectedText = String.valueOf(inCartNUmber);
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//span[@class='quantity']")), expectedText));
        inCart = driver.findElement(By.xpath("//span[@class='quantity']"));
        System.out.println("new find " + Integer.parseInt(inCart.getText()));
        return Integer.parseInt(inCart.getText());
    }
    public static void selectSize() {

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
}
