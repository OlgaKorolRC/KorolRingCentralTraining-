package task4;
import java.util.Random;
import java.util.Arrays;

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
}