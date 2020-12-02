package task4;

import java.util.Random;

class ThinOrangeFactory extends AbstractFabric {

    @Override
    public Fruit makeFruit() {
        return new Orange(new Random(1).nextInt(5));
    }
}
