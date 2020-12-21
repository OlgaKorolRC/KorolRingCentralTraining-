package AnimalPackage;

public class Wolf extends WildAnimal {
    Wolf(String name) {
        this.name = name;
    }

    @Override
    public String getFavoriteMeal() {
        return "Rabbit";
    }

    @Override
    public String toString() {
        return "Wolf{" +
                "name='" + name + '\'' +
                '}';
    }
}
