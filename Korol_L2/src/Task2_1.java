/*
Задание 1. Случайности складываются
- Создать массив на 10 чисел типа int
- Заполнить массив случайными числами, используя класс Random и функцию nextInt()
- Вывести массив на экран одной строкой, разделив элементы пробелом
- Посчитать сумму всех элементов и вывести на экран
- Найти минимальный элемент и вывести на экран его индекс в массиве и значение

 */

import java.util.Random;
import java.util.Arrays;

public class Task2_1 {
    public static void main(String args[]) {
        int[] forTenValues = new int[10];
        int sum = 0;
        for (int i = 0; i < forTenValues.length; i++) {
            forTenValues[i] = new Random().nextInt();
            sum = sum + forTenValues[i];
        }
        int indexMinValue = 0;
        for (int i = 1; i < forTenValues.length; i++) {
            if (forTenValues[indexMinValue] > forTenValues[i]) {
                indexMinValue = i;
            }
        }

        System.out.println("All values:" + Arrays.toString(forTenValues));
        System.out.println("Sum: " + sum);
        System.out.println("Min [" + indexMinValue + "]: " + forTenValues[indexMinValue]);
    }
}