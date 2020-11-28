package task4;

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