import java.util.Arrays;
import java.util.Random;

/*
1. Фруктовая неоднозначность
Создать класс Fruit со свойством "вес" типа int и методом toString
Создать наследники:
Apple - с дополнительным свойством цвет (красное, зеленое, желтое) - String
Orange - с дополнительном свойством толщина кожуры - int от 0 до 20
Pineapple - с дополнительным свойством - высота хвоста - int, от 5 до 20

переопределить во всех фруктах toString, чтобы выводил все свойства фрукта и тип фрукта (яблоко, апельсин, ананас)

создать метод getRandomFruit - которое возвращает случаный фрукт со случайными характеристиками.
Создать массив типа Fruit, заполнить его 4 разными случаными фруктами и вывести их на экран

 */
public class Fruit {
    int weight = new Random().nextInt(900);

    @Override
    public String toString() {
        return "Any Fruit {" +
                "weight=" + weight +
                '}';
    }

    public static void main(String[] args) {
        Fruit[] fourItems= new Fruit[4];

        for (int i = 0; i < fourItems.length; i++) {
            int typeFruit = new Random().nextInt(3);
            Fruit anyFruit = new Fruit();
            switch (typeFruit) {
                case 0: anyFruit = new Apple(new Random().nextInt(3));
                break;
                case 1: anyFruit = new Orange(new Random().nextInt(20));
                break;
                case 2: anyFruit = new Pineapple(new Random(5).nextInt(20));
                break;
            }

            fourItems[i] = anyFruit;
            System.out.println("Fruit № " + (i+1) + " " + anyFruit.toString());
        }

    }
}

class Apple extends Fruit {
    String[] color = {"red", "yellow", "green"};
    int colorNumber;
    Apple (int number) {
        colorNumber = number;
    }
    @Override
    public String toString() {
        return "Type is Apple {" +
                "weight=" + weight + "gm" +
                ", color=" + color[colorNumber] +
                '}';
    }
}

class Orange extends Fruit {
    int peelThickness;
    Orange (int peel) {
        peelThickness = peel;
    }
    @Override
    public String toString() {
        return "Type is Orange {" +
                "weight=" + weight + "gm"  +
                ", peelThickness=" + peelThickness + "mm" +
                '}';
    }
}

class Pineapple extends Fruit {
    int sultanHeight;
    Pineapple (int height) {
        sultanHeight = height;
    }


    @Override
    public String toString() {
        return "Type is Pineapple {" +
                "weight=" + weight + "gm"  +
                ", sultanHeight=" + sultanHeight + "cm" +
                '}';
    }
}
