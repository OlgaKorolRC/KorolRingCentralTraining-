package AnimalPackage;

public class Dog extends PetAnimal {
    Dog(String name) {
        this.name = name;
    }

    @Override
    public String getFavoriteMeal() {
        return "Bone";
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}
