/*
1.	Написать программу, в которой есть две переменные типа Integer со значениями. Значения можно указать в коде программы или ввести с клавиатуры или взять из аргументов.
2.	Если первое число больше второго – написать на экран «Число %s больше %s».
3.	Если первое число меньше второго – написать на экран «Число %s меньше %s».
4.	В любом случае, вывести на экран сумму чисел.
 */
public class Task1 {
    public static void main (String args []) {
        int theFirstVariable = 3;
        int theSecondVariable = 8;
        if (theFirstVariable > theSecondVariable) {
            System.out.println("Число " + theFirstVariable + " больше " + theSecondVariable);
        } else if (theFirstVariable < theSecondVariable) {
                System.out.println("Число " + theFirstVariable + " меньше " + theSecondVariable);
        }
        System.out.println("Сумма чисел = " + (theFirstVariable+theSecondVariable));
    }
}