import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.lang.System.out;

public class General {
    private WebElement status;
    private WebElement name;
    private WebElement code;
    private List<WebElement> selectCategories;
    private WebElement defaultCategory;
    private List<WebElement> selectGroup;
    private WebElement quantity;
    private WebElement dateFrom;
    private WebElement dateTo;

    General(WebDriver driver) {
        status = driver.findElement(By.xpath("//input[@name='status' and @value='1']"));
        name = driver.findElement(By.xpath("//input[@name='name[en]']"));
        code = driver.findElement(By.xpath("//input[@name='code']"));
        selectCategories = driver.findElements(By.xpath("//input[@type='checkbox' and @name='categories[]']"));
        defaultCategory = driver.findElement(By.xpath("//select[@name='default_category_id']"));
        selectGroup = driver.findElements(By.xpath("//input[@type='checkbox' and @name='product_groups[]']"));
        quantity = driver.findElement(By.xpath("//input[@name='quantity']"));
        dateFrom = driver.findElement(By.name("date_valid_from"));
        dateTo = driver.findElement(By.name("date_valid_to"));

    }

    public WebElement getStatus() {
        return status;
    }
    public WebElement getName() {
        return name;
    }
    public WebElement getCode() {
        return code;
    }
    public List<WebElement> getSelectCategories() {
        return selectCategories;
    }
    public WebElement getDefaultCategory() {
        return defaultCategory;
    }
    public List<WebElement> getSelectGroup() {
        return selectGroup;
    }
    public WebElement getQuantity() {
        return quantity;
    }
    public WebElement getDateFrom() {
        return dateFrom;
    }
    public WebElement getDateTo() {
        return dateTo;
    }

    public static boolean uncheck(List<WebElement> checkbox) {
        for (WebElement field : checkbox) {
            if (field.getAttribute("checked") != null) {
                out.println("This is " + field.getAttribute("checked") + " and this is bug");
                field.click();
                return true;
            } else {
                out.println("No problem");
                return true;
            }
        }
        return false;
    }

    public static boolean checkDefaultCheckbox(List<WebElement> checkbox) throws InterruptedException {
        for (WebElement field : checkbox) {
            if (field.getAttribute("checked") != null) {
                return true;
            } else {
                field.click();
                return true;
            }
        }
        return false;
    }

    public static boolean checkDefaultCategory(WebElement defaultCategory) {
        WebElement option = defaultCategory.findElement(By.xpath(".//option"));
        if (option != null) {
            out.println("OK with DefaultCategory" + option.getText());
            return true;
        } else {
            out.println("No select DefaultCategory");
            return false;
        }
    }
}


