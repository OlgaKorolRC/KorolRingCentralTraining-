import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.List;

import static java.lang.Thread.sleep;

public class compareUtya extends MainPage {
    @Test
    public void comparison() throws InterruptedException {

        for (Category box : Category.values()) {
            String block = box.title;
            List<WebElement> elementsLink = driver.findElements(By.xpath("//div[@id='" + block + "']//li[@class='product column shadow hover-light']/a[1]"));
            String[] allDucks = new String[elementsLink.size()];

            for (int i = 0; i < elementsLink.size(); i++) {
                allDucks[i] = elementsLink.get(i).getAttribute("href");
            }

            for (int i = 0; i < allDucks.length; i++) {
                WebElement thisUtya = driver.findElement(By.xpath("//div[@id='" + block + "']//a[contains(@href,'" + allDucks[i] + "')]/.."));
                Utya utayFromMainPage = utyaOnMainPage(thisUtya);
                driver.findElement(By.xpath("//a[contains(@href,'" + allDucks[i] + "')]")).click();
                sleep(500);
                Utya utayFromLink = utyaInLink();
                driver.navigate().back();
                sleep(500);
                boolean coincidence = utayFromMainPage.equals(utayFromLink);
                System.out.println("In block " + block + " after back in " + (i + 1) + " attempt coincidence is " + coincidence);
            }
        }
    }

    public Utya utyaOnMainPage(WebElement currentUtya) {
        String kryaName = currentUtya.findElement(By.xpath(".//div[contains(@class, 'name')]")).getText();
        List<WebElement> stickerKrya = currentUtya.findElements(By.xpath(".//div[contains(@class, 'sticker')]"));

        if (stickerKrya.size() == 0) {
            WebElement price = currentUtya.findElement(By.xpath(".//span[contains(@class, 'price')]"));
            String blackPrice = price.getText();
            Utya normalUtya = new Utya(kryaName, blackPrice, null, null);
            return normalUtya;
        } else {
            WebElement miniPrice = currentUtya.findElement(By.xpath(".//*[contains(@class, 'regular-price')]"));
            String smallPrice = miniPrice.getText();

            WebElement largePrice = currentUtya.findElement(By.xpath(".//*[contains(@class, 'campaign-price')]"));
            String bigPrice = largePrice.getText();

            checkPrice(miniPrice, largePrice);

            Utya stickerUtya = new Utya(kryaName, null, smallPrice, bigPrice);
            return stickerUtya;
        }
    }

    public Utya utyaInLink() {
        String kryaName = driver.findElement(By.xpath(".//h1[@class = 'title']")).getText();
        List<WebElement> stickerKrya = driver.findElements(By.xpath("//div[@id = 'box-product']//div[contains(@class, 'sticker')]"));

        if (stickerKrya.size() == 0) {
            WebElement normalPrice = driver.findElement(By.xpath(".//div[@class = 'information' ]//span[contains(@class, 'price')]"));

            String blackPrice = normalPrice.getText();

            Utya normalLinkUtya = new Utya(kryaName, blackPrice, null, null);
            return normalLinkUtya;
        } else {
            WebElement miniPrice = driver.findElement(By.xpath(".//*[contains(@class, 'regular-price')]"));
            String smallPrice = miniPrice.getText();

            WebElement largePrice = driver.findElement(By.xpath(".//*[contains(@class, 'campaign-price')]"));
            String bigPrice = largePrice.getText();

            checkPrice(miniPrice, largePrice);

            Utya stickerLinkUtya = new Utya(kryaName, null, smallPrice, bigPrice);
            return stickerLinkUtya;
        }
    }

    public String getColor(WebElement price) {
        return price.getCssValue("color");
    }

    public String getTextType(WebElement price) {
        return price.getCssValue("text-decoration-line");
    }

    public String getTextStrong(WebElement price) {
        return price.getCssValue("font-weight");
    }

    public Integer getSize(WebElement price) {
        String sizePX = price.getCssValue("font-size");
        String size = sizePX.substring(0, 2);
        return Integer.valueOf(size);
    }

    public boolean checkGreyPrice(String rgbaSting) {
        int[] rgba = getRgbFromRgb(rgbaSting);
        if (rgba[0] == rgba[1] && rgba[1] == rgba[2]) {
            System.out.println("Color is grey");
            return true;
        } else {
            System.out.println("Color is not grey");
            return false;
        }
    }

    public boolean checkRedPrice(String rgbaSting) {
        int[] rgba = getRgbFromRgb(rgbaSting);
        if (rgba[1] == 0 && rgba[2] == 0) {
            System.out.println("This color is red");
            return true;
        } else {
            System.out.println("This color is not red");
            return false;
        }
    }

    public boolean checkStroke(String typeText) {
        if (typeText.equals("line-through")) {
            System.out.println("This is line-through");
            return true;
        } else {
            System.out.println("This is not line-through");
            return false;
        }

    }

    public boolean checkBold(String fontWeight) {
        if (fontWeight.equals("bold") || fontWeight.equals("700")) {
            System.out.println("This is bold");
            return true;
        } else {
            System.out.println("This is not bold");
            return false;
        }

    }

    public boolean checkSize(int oldSize, int newSize) {
        if (oldSize < newSize) {
            System.out.println("Size of new price less than size of new price");
            return true;
        } else {
            System.out.println("Size of new and old prices is incorrect");
            return false;
        }
    }

    public void checkPrice(WebElement oldPrice, WebElement newPrice) {
        checkGreyPrice(getColor(oldPrice));
        checkStroke(getTextType(oldPrice));

        checkRedPrice(getColor(newPrice));
        checkBold(getTextStrong(newPrice));

        checkSize(getSize(oldPrice), getSize(newPrice));
    }

    private static int[] getRgbFromRgb(String rgbString) {
        String[] values = rgbString.split("[\\s,()]");
        int red = Integer.parseInt(values[1]);
        int green = Integer.parseInt(values[3]);
        int blue = Integer.parseInt(values[5]);
        int alpha = Integer.parseInt(values[7]);

        int[] valuesInRGBa = new int[]{
                red,
                green,
                blue,
                alpha
        };
        return valuesInRGBa;
    }
}
