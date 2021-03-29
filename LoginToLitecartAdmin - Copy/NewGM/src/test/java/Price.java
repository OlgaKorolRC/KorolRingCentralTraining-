import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Price {
    private WebElement purchasePrice;
    private WebElement price;

    Price(WebDriver driver) {
        purchasePrice = driver.findElement(By.name("purchase_price"));
        price = driver.findElement(By.name("prices[USD]")) ;
    }

    public WebElement getPurchasePrice() {
        return purchasePrice;
    }

    public WebElement getPrice() {
        return price;
    }
}
