import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.List;


public class CheckSticker extends MainPage{

    @Test
    public void checkSticker() {
        List<WebElement> elements = driver.findElements(By.xpath("//li[@class='product column shadow hover-light']"));
        System.out.println("Number of krya: " + elements.size());
        List<WebElement> stickers = driver.findElements(By.xpath("//div[contains(@class, 'sticker')]"));
        System.out.println("Number of all stickers: " + stickers.size());

        for (WebElement duck: elements) {
            List<WebElement> stickerKrya = duck.findElements(By.xpath(".//div[contains(@class, 'sticker')]"));
            System.out.println("Number of sticker for this duck: " + stickerKrya.size() + duck.getLocation());
            if (stickerKrya.size()==1) {
                System.out.println("Only one sticker for this duck");
            } else {
                System.out.println("Not one sticker for this duck");
            }
        }
    }

}
