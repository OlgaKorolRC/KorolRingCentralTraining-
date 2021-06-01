import org.openqa.selenium.By;

public class MainPageApplication extends  forAllTests{

    public static void openSite() {
        driver.get("http://localhost/litecart/en/");
    }

    public static void goToCart(){
        System.out.println("In Cart !!!" );
        driver.findElement(By.partialLinkText("Checkout")).click();
        System.out.println("After click to checkout");
    }

    public static void openMainPage() {
        driver.findElement(By.xpath("//img[@title='My Store']")).click();
    }

}
