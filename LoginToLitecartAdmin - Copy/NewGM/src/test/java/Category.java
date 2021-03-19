import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public enum Category {

    MOST_POPULAR("box-most-popular"),
    CAMPAIGNS("box-campaigns"),
    LATEST_PRODUCTS("box-latest-products");

    final String title;

    Category(String title) {
        this.title = title;
    }

//    public WebElement getIdTitle(WebDriver driver) {
//        return driver.findElement(By.xpath("//div[@id='" + title + "']"));
//    }
}
