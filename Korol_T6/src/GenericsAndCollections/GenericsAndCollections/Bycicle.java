package GenericsAndCollections;
import java.util.Objects;
import java.util.Random;

public class Bycicle {
    String modelName;
    int maxSpeed;

    Bycicle (int maxSpeed, String modelName) {
        this.maxSpeed = maxSpeed;
        this.modelName = modelName;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bycicle)) return false;
        Bycicle bycicle = (Bycicle) o;
        return maxSpeed == bycicle.maxSpeed &&
                Objects.equals(modelName, bycicle.modelName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelName, maxSpeed);
    }

    @Override
    public String toString() {
        return "Bycicle{" +
                "modelName='" + modelName + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
