import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CartPageApplication extends forAllTests{
    public static void deleteFromCart(){
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
