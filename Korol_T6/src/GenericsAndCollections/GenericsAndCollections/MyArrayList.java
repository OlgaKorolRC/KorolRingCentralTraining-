package GenericsAndCollections;
import java.util.ArrayList;
import java.util.List;


/*
Дженерики и коллекции

(пожалуйста, делайте каждое задание в отдельном package'e)

Задание 1. Велосипеды и контейнеры

Создать свой класс MyArrayList, который хранит максимум 10 объектов любого типа (по аналогии с ArrayList).
Если попытаться добавить больше, чем 10 элементов, то должно выкинуться unchecked исключение - MyArrayStoreException.
Используйте обощенный класс для этого (generic) с типом T.

- Реализуйте методы:
1. void add(T) - добавляет элемент  в коллекцию
2. boolean remove(T) - возвращает true, если элемент был найден и удален
3. T[] toArray() - возвращает массив из всех текущих элементов
4. int size()
5. T get(int) - взять элемент по индексу.


- Создайте класс Bycicle, определите у него свойства String modelName; int maxSpeed (от 5 до 50км\ч);
Переопределите equals и hashCode, который используют оба свойства велосипеда.

- Создайте 11 случайных велосипедов и попытайтесь их добавить их в новый экземпляр MyArrayList.
 Если какой-то велосипед добавить не получилось - то в лог выведите какой велосипед не добавился.
- Проверьте, что все методы работают правильно:
  1. Возьмите случайное число от 0 до 50.
  2. Удалите из коллекции все велосипеды со скоростью меньше этого случайного числа.


- Теперь создайте новый экземпляр MyArrayList
- Добавьте в него 10 случайных чисел от 1 до 10
- удалите все четные числа
- Выведите оставшиеся числа на экран.

 */
public class MyArrayList<T> {
    private static int MAX_SIZE = 10;

    private List<T> list = new ArrayList<>();

    public void add(T item) {
        if(size() <= MAX_SIZE) {
            list.add(item);
        }
        else {
            throw new MyArrayStoreException();
        }
    }

    public boolean remove(T item) {
        return list.remove(item);
    }

    public T[] toArray() {
        return (T[])list.toArray();
    }

    public int size() {
        return list.size();
    }

    public T get(int index) {
        return list.get(index);
    }
}
