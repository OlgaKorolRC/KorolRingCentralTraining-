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