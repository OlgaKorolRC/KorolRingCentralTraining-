package task4;
import java.util.Random;
import java.util.Arrays;

public class MainFabricClass {
    public static void main(String[] args) {
        AbstractFabric[] tenSame = new AbstractFabric[10];
        int typeFabric = new Random().nextInt(4);
        for (int i = 0; i < tenSame.length; i++) {
            switch (typeFabric) {
                case 0:
                    tenSame[i] = new ThinOrangeFactory();
                    break;
                case 1:
                    tenSame[i] = new RedApplesFactory();
                    break;
                case 2:
                    tenSame[i] = new GreenApplesFactory();
                    break;
                case 3:
                    tenSame[i] = new LongPinepplesFactory();
                    break;

            }
            System.out.println("Fruit № " + (i + 1) + " " + tenSame[i].makeFruit().toString());
        }

        int[] doubleTypeFabric = new int[20];
        do {
            doubleTypeFabric = AbstractFabric.listFabric();
            for (int i = 0; i < 20; i++) {
                System.out.println(doubleTypeFabric[i]);
            }
        } while (Arrays.asList(doubleTypeFabric).contains(0) &&
                Arrays.asList(doubleTypeFabric).contains(1) &&
                Arrays.asList(doubleTypeFabric).contains(2) &&
                Arrays.asList(doubleTypeFabric).contains(3));

        AbstractFabric[] tenCoupleFruit = new AbstractFabric[20];
        for (int i = 0; i < tenCoupleFruit.length; i++) {
            switch (doubleTypeFabric[i]) {
                case 0:
                    tenCoupleFruit[i] = new ThinOrangeFactory();
                    break;
                case 1:
                    tenCoupleFruit[i] = new RedApplesFactory();
                    break;
                case 2:
                    tenCoupleFruit[i] = new GreenApplesFactory();
                    break;
                case 3:
                    tenCoupleFruit[i] = new LongPinepplesFactory();
                    break;
            }
            System.out.println("Fruit (couple) № " + (i + 1) + " " + tenCoupleFruit[i].makeFruit().toString());
        }
    }
}
