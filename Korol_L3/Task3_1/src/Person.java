import java.util.Random;

/*
Задание 1. Цифровая персонализация
- Создать класс Person с двумя полями типа String: firstName, lastName
- создать один публичный конструктор с аргументами firstName и lastName. В конструкторе инициализировать поля класса значениями из аргументов.
- Для каждого поля определить только getter'ы (без setter'ов) - getFirstName, getLastName , который возвращают соответствующее поле
- Создать метод toString() который возвращает человека в формате "Фамилия, Имя"

 в методе main
- Создать массив типа String на 5 элементов - туда записать какие-нибудь реальные имена.
- Создать массив типа String на 6 элементов - туда записать какие-нибудь реальные фамилии
- Создать массив типа Person на 50 элементов - туда записать людей со случайными фамилиями из массивов выше
- Вывести всех людей из массива в формате "Человек №{индекс в массиве} - Фамилия, Имя"

 */
public class Person {
    String firstName;
    String lastName;
    Person (String nickname, String surname) {
        firstName = nickname;
        lastName = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return getLastName() + ", " + getFirstName();
    }

    public static void main(String[] args) {
        String[] realName = {"Vasya", "Zhenya", "Sasha", "Valya", "Rosya"};
        String[] surname = {"Depp", "Pitt", "Jolie", "Dior", "Grindelwald", "Trump"};
        Person[] people = new Person [50];

        for (int i = 0; i < people.length; i++) {
            int randomNameIndex = new Random().nextInt(realName.length);
            int randomSurNameIndex = new Random().nextInt(surname.length);
            Person human = new Person(realName[randomNameIndex], surname[randomSurNameIndex]);
            System.out.println("Person № " + (i+1) + " " + human.toString());
        }
    }
}
