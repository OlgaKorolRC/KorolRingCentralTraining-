import java.util.Arrays;
import java.util.Random;

/*
Задание 2. Случайности расходятся
- Создать массив на 5 элементов типа int и вывести на экран
- Разделить на два других - в первом массиве только четные числа, во втором - только нечетные. Оба массива вывести на экран.
- Найти среднее значение в каждом массива и вывести их на экран
 */
public class Task2_2 {
    public static void main(String[] args) {
        int[] forFiveValues = new int[5];
        int even = 0;
        int odd = 0;
        for (int i = 0; i < forFiveValues.length; i++) {
            forFiveValues[i] = new Random().nextInt(100);
            if (forFiveValues[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        int[] evenValues = new int[even];
        int[] oddValues = new int[odd];
        int sumEven = 0;
        int sumOdd = 0;
        for (int i = 0, j = 0, k = 0; i < forFiveValues.length; i++) {
            if (forFiveValues[i] % 2 == 0) {
                evenValues[j] = forFiveValues[i];
                sumEven += evenValues[j];
                j++;
            } else {
                oddValues[k] = forFiveValues[i];
                sumOdd += oddValues[k];
                k++;
            }
        }
        System.out.println("All values:" + Arrays.toString(forFiveValues));
        System.out.println("All even values:" + Arrays.toString(evenValues));
        System.out.println("All odd values:" + Arrays.toString(oddValues));
        System.out.println("Middle even = " + (sumEven / even));
        System.out.println("Middle odd =" + (sumOdd / odd));
    }
}
