package AnimalPackage;

public class Fox extends WildAnimal {
    Fox(String name) {
        this.name = name;
    }

    @Override
    public String getFavoriteMeal() {
        return "Fish";
    }

    @Override
    public String toString() {
        return "Fox{" +
                "name='" + name + '\'' +
                '}';
    }
}
