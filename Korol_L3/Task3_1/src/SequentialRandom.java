import java.util.Random;

/*
Задание 2. Случайности - не случайны
Создать класс SequentialRandom с одним полем типа int.
Значение поле можно только прочитать, но не изменить (используйте модифиактор private на поле и создайте только getter)
Значение этого int вычисляется по следующим правилом:
- Значение для первого созданного объекта - случайное
- значение для каждого следующего на 1 больше, чем предыдущее
- У класса есть статический метод resetRandom(), который делает значение следующего созданного объекта - случайным.

Например
new SequentialRandom() // содержит 5 (случайное)
new SequentialRandom() // содержит 6 (на 1 больше)
new SequentialRandom() // содержит 7 (на 1 больше)
SequentialRandom.resetRandom()
new SequentialRandom() // содержит 42 (случайное
new SequentialRandom() // содержит 43) (на 1 больше)

Подсказка: Используйте статическую переменную в классе, чтобы хранить значение предыдущего объекта.

 */
public class SequentialRandom {
    private static int field = 0;

    public int getField() {
        return field;
    }
    SequentialRandom () {
        if (field == 0) {
            field = new Random(1).nextInt();
        } else {
            field++;
        }
    }
    public static void resetRandom() {
        field = 0;
    }

    public static void main(String[] args) {
        int size = 10;
        int randomIndex = new Random().nextInt(size);

        for (int i = 0; i < size; i++) {
            if (i == randomIndex) {
                SequentialRandom.resetRandom();
                System.out.println("randomIndex reset " + randomIndex);
            }
            SequentialRandom number = new SequentialRandom();
            System.out.println(number.getField());
        }
    }
}
