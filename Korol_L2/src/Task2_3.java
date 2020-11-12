import java.util.Arrays;
import java.util.Random;

/*
Задание 3. Противоположности притигиваются
- Создайте два массива на 7 элементов.
- Используюте функцию Random.nextInt() чтобы полностью заполнить два массива: в первом массиве должно оказаться ровно 7 положительных чисел, во втором - ровно 7 отрицательных.
Подсказка: используйте цикл while во время генерации случайных чисел и проверку на заполненность массива, прежде, чем записывать туда элемент.
- Выведите оба массива на экран
- Создайте новый массив на 7 элементов.
Значением на каждой позиции является суммой значений на позициях с тем же индексом из положительного и отрицательного массива.
 */
public class Task2_3 {
    public static void main(String[] args) {
        int[] forPositiveValues = new int[7];
        int[] forNegativeValues = new int[7];
        int[] forSumValues = new int[7];
        int newValue = 0;
        int i = 0;
        int j = 0;
        do {
            newValue = new Random().nextInt();
            if (newValue > 0) {
                forPositiveValues[i] = newValue;
                i++;
            } else {
            }
        } while (i < forPositiveValues.length);

        do {
            newValue = new Random().nextInt();
            if (newValue < 0) {
                forNegativeValues[j] = newValue;
                j++;
            } else {
            }
        } while (j < forNegativeValues.length);
        for (int k = 0; k < forSumValues.length; k++) {
            forSumValues[k] = forPositiveValues[k] + forNegativeValues[k];
        }
        System.out.println("Positive values:" + Arrays.toString(forPositiveValues));
        System.out.println("Negative values:" + Arrays.toString(forNegativeValues));
        System.out.println("Sum values:" + Arrays.toString(forSumValues));
    }
}
