package AnimalPackage;

public abstract class Animal {
    String name;

    public abstract String getFavoriteMeal();

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}
