package GenericsAndCollections;

import java.util.Arrays;
import java.util.Random;

public class MainClass {
    public static void main(String[] args) {
        String[] modelName = {
                "Mountain bike",
                "Female bike",
                "Children bicycle",
                "Teenage bike",
                "Folding bicycle",
                "Comfort bike",
                "Double suspension",
                "Extreme bike",
                "Road bike",
                "City bike",
                "Electric bicycles"
        };
        int minSpeed = new Random().nextInt(50);
        MyArrayList<Bycicle> newBicycleList = new MyArrayList<Bycicle>();

        System.out.println("New list of bicycle: \n");
        for (int i = 0; i <= 11; i++) {
            int maxSpeed = new Random(5).nextInt(50);
            Bycicle newBicycle = new Bycicle(maxSpeed, modelName[new Random().nextInt(modelName.length)]);
            try {
                newBicycleList.add(newBicycle);
                System.out.println("Spead: " + newBicycle.maxSpeed + " Model: " + newBicycle.modelName);
            } catch (MyArrayStoreException exception) {
                System.out.println(exception.toString() + newBicycle.toString());
                break;
            };
        }
        System.out.println("Too slow " + minSpeed);

        Object[] byciclesArray = newBicycleList.toArray();
        for (Object i:byciclesArray) {
            Bycicle bike = (Bycicle) i;
            if (bike.maxSpeed < minSpeed) {
                newBicycleList.remove(bike);
            }
            System.out.println("Big Speed: " + bike.maxSpeed + " Great Model: " + bike.modelName);
        }
        System.out.println("\n New list of Numbers: ");
        MyArrayList<Integer> arrayNumbers = new MyArrayList<Integer>();
        int valueInArray = 10;
        for (int i = 0; i < valueInArray; i++) {
            int intInArray = new Random().nextInt(10);
            arrayNumbers.add(intInArray);
        }
        System.out.println("First int array" + Arrays.toString(arrayNumbers.toArray()));

        for (int i = 0; i < valueInArray; i++) {
            int newValue = arrayNumbers.get(i);
            if (newValue % 2 == 0) {
                arrayNumbers.remove(newValue);
                valueInArray--;
                i--;
            }
        }
        System.out.println("Second int array" + Arrays.toString(arrayNumbers.toArray()));
    }
}