package task4;

import java.util.Random;

class LongPinepplesFactory extends AbstractFabric {

    @Override
    public Fruit makeFruit() {
        return new Pineapple(new Random(10).nextInt());
    }
}