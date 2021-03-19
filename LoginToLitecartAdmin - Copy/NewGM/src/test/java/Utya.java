import javax.naming.BinaryRefAddr;
import java.util.Objects;

public class Utya {
    String nameOfUtya;
    String defaultPrice;
    String oldPrice;
    String newPrice;

    Utya(String defaultName, String greyPrice, String miniPrice, String redPrice) {
        nameOfUtya = defaultName;
        defaultPrice = greyPrice;
        oldPrice = miniPrice;
        newPrice = redPrice;
    }

    @Override
    public String toString() {
        return "Utya{" +
                "name Of Utya= '" + nameOfUtya + '\'' +
                ", defaultPrice= " + defaultPrice +
                ", oldPrice= " + oldPrice +
                ", newPrice= " + newPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Utya)) return false;
        Utya utya = (Utya) o;
        return Objects.equals(nameOfUtya, utya.nameOfUtya) &&
                Objects.equals(defaultPrice, utya.defaultPrice) &&
                Objects.equals(oldPrice, utya.oldPrice) &&
                Objects.equals(newPrice, utya.newPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfUtya, defaultPrice, oldPrice, newPrice);
    }
}