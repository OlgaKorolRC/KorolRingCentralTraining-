package AnimalPackage;

import java.util.*;

public class Zoo {
    //    System.out.println("ArrayList : " + name);
    static HashSet<PetAnimal> fillCollectionWithPetAnimals(HashSet collectionWithPetAnimals, ArrayList name) {
        int numberAnimals = new Random(0).nextInt(4) + 1;
        Collections.shuffle(name);
        List<String> namesForPetCollection = name.subList(0, numberAnimals);
        Object[] objectsArray = namesForPetCollection.toArray();
        double catOrDog = Math.random();
        for (Object animalName : objectsArray) {
            if (catOrDog >= 0.5) {
                Cat mimiCat = new Cat((String) animalName);
                collectionWithPetAnimals.add(mimiCat);
            } else {
                Dog mimiDog = new Dog((String) animalName);
                collectionWithPetAnimals.add(mimiDog);
            }
        }
        System.out.println(collectionWithPetAnimals);
        return collectionWithPetAnimals;
    };

    static HashSet<WildAnimal> fillCollectionWithWildAnimals(HashSet collectionWithWildAnimals, ArrayList name) {
        int numberAnimals = new Random(3).nextInt(10);
        Collections.shuffle(name);
        List<String> namesForWildCollection = name.subList(0, numberAnimals);
        Object[] objectsArray = namesForWildCollection.toArray();
        double foxOrWolf = Math.random();
        for (Object animalName : objectsArray) {
            if (foxOrWolf >= 0.5) {
                Fox mimiFox = new Fox((String) animalName);
                collectionWithWildAnimals.add(mimiFox);
            } else {
                Wolf mimiWolf = new Wolf((String) animalName);
                collectionWithWildAnimals.add(mimiWolf);
            }
        }
        System.out.println(collectionWithWildAnimals);
        return collectionWithWildAnimals;
    };

    private static void printAnimalsFromCollection() {
        ArrayList<String> name = new ArrayList<String>();
        name.add("Simba");
        name.add("Murka");
        name.add("Bethoven");
        name.add("Matroskin");
        name.add("MuMu");
        name.add("Sharik");
        name.add("Tom");
        name.add("Kashtanka");
        name.add("Bazilio");
        name.add("Catrin");
        HashSet<PetAnimal> collectionWithPetAnimals = new HashSet<PetAnimal>();
        HashSet<WildAnimal> collectionWithWildAnimals = new HashSet<WildAnimal>();

        fillCollectionWithPetAnimals(collectionWithPetAnimals, name);
        fillCollectionWithWildAnimals(collectionWithWildAnimals, name);
        System.out.println("Privat method for Pet Animals" + collectionWithPetAnimals.toString());
        System.out.println("Privat method for Wild Animals" + collectionWithWildAnimals.toString());
    };

    public static void printAllAnimals() {
        printAnimalsFromCollection();
    }
}