import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Info {
    private Select manufacturer;
    private WebElement supplier;
    private WebElement keywords;
    private WebElement shortDescription;
    private WebElement description;
    private WebElement headTitle;
    private WebElement metaDescription;

    Info(WebDriver driver) {
        manufacturer = new Select(driver.findElement(By.name("manufacturer_id")));
        supplier = driver.findElement(By.name("supplier_id"));
        keywords = driver.findElement(By.name("keywords"));
        shortDescription = driver.findElement(By.name("short_description[en]"));
        description = driver.findElement(By.xpath("//div[@class='trumbowyg-editor']"));
        headTitle = driver.findElement(By.name("head_title[en]"));
        metaDescription = driver.findElement(By.name("meta_description[en]"));
    }

    public Select getManufacturer() {
        return manufacturer;
    }
    public WebElement getSupplier() {
        return supplier;
    }
    public WebElement getKeywords() {
        return keywords;
    }
    public WebElement getShortDescription() {
        return shortDescription;
    }
    public WebElement getDescription() {
        return description;
    }
    public WebElement getHeadTitle() {
        return headTitle;
    }
    public WebElement getMetaDescription() {
        return metaDescription;
    }
}
