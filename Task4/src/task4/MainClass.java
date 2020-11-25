package task4;

import java.util.Random;

public class MainClass {
    public static void main(String[] args) throws Exception {
        Fruit[] fourItems= new Fruit[4];

        for (int i = 0; i < fourItems.length; i++) {
            int typeFruit = new Random().nextInt(3);
            Fruit anyFruit;

            switch (typeFruit) {
                case 0: anyFruit = new Apple(new Random().nextInt(3));
                    break;
                case 1: anyFruit = new Orange(new Random().nextInt(20));
                    break;
                case 2: anyFruit = new Pineapple(new Random(5).nextInt(20));
                    break;
                default:
                    throw new Exception();
            }

            fourItems[i] = anyFruit;
            System.out.println("Fruit № " + (i+1) + " " + anyFruit.toString());
        }

    }

}
