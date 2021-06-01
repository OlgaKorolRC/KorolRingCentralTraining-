import org.testng.annotations.Test;

public class WorkWithCart extends  forAllTests{

    @Test
    public void checkNewUser() {
        int numberUtya = 3;

        MainPageApplication.openSite();
        addAllNeededUtyaInCart(numberUtya);
        MainPageApplication.goToCart();
        CartPageApplication.deleteFromCart();
    }

    public void addAllNeededUtyaInCart(int numberUtya) {
        for (int i = 1; i <= numberUtya; i++) {
            UtyaPageApplication.addToCart(i);
            MainPageApplication.openMainPage();
        }
    }
}
