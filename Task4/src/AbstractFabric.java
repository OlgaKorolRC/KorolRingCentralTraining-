import java.util.Random;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/*
Фруктовая абстрактность
Создать класс AbstractFabric с одним абстрактным методом makeFruit(), который возвращает фрукт.
Создайте следующие подклассы:

ThinOrangeFactory - которая создает  только апельсины с толщиной кожуры от 1 до 5
RedApplesFactory - которая создает только красные яблоки
GreenApplesFactory - которая создает только зеленые яблоки.
LongPinepplesFactory - которая создает только ананасы с длиной хвоста больше 10

Создайте массив на 10 элементов и поместите туда 10 случайных фабрик одного из 4 описанных выше типов.
Создайте массив типа Fruit на 20 элементов и заполните его фруктами из всех  фабрик - по 2 фрукта от одной фабрики.

 */

public abstract class AbstractFabric {
    public abstract Fruit makeFruit();

    public static int[] listFabric() {
        Fruit[] twentyFruits = new Fruit[20];
        int[] doubleTypeFabric = new int[twentyFruits.length];
        for (int i = 0; i < twentyFruits.length; i++) {
            int newvalue = new Random().nextInt(4);
            doubleTypeFabric[i] = newvalue;
            i++;
            doubleTypeFabric[i] = newvalue;
        }
        return doubleTypeFabric;
    }
    public static void main(String[] args) {
        AbstractFabric[] tenSame = new AbstractFabric[10];
        int typeFabric = new Random().nextInt(4);
        for (int i = 0; i < tenSame.length; i++) {
            switch (typeFabric) {
                case 0: tenSame[i] = new ThinOrangeFactory();
                    break;
                case 1: tenSame[i] = new RedApplesFactory();
                    break;
                case 2: tenSame[i] = new GreenApplesFactory();
                    break;
                case 3: tenSame[i] = new LongPinepplesFactory();
                    break;

            }
            System.out.println("Fruit № " + (i+1) + " " + tenSame[i].makeFruit().toString());
        }

        int[] doubleTypeFabric = new int[20];
        do {
            doubleTypeFabric = listFabric();
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
            System.out.println("Fruit (couple) № " + (i+1) + " " + tenCoupleFruit[i].makeFruit().toString());
        }
    }
}
class ThinOrangeFactory extends AbstractFabric {

    @Override
    public Fruit makeFruit() {
        return new Orange(new Random(1).nextInt(5));
    }
}
class RedApplesFactory extends AbstractFabric {
    @Override
    public Fruit makeFruit() {
        return new Apple(0);
    }
}

class GreenApplesFactory extends AbstractFabric {
    @Override
    public Fruit makeFruit() {
        return new Apple(2);
    }
}

class LongPinepplesFactory extends AbstractFabric {

    @Override
    public Fruit makeFruit() {
        return new Pineapple(new Random(10).nextInt());
    }
}