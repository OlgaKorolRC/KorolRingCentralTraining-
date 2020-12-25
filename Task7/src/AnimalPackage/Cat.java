package AnimalPackage;

public class Cat extends PetAnimal {
    Cat(String name) {
        this.name = name;
    }

    @Override
    public String getFavoriteMeal() {
        return "Sour cream";
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}