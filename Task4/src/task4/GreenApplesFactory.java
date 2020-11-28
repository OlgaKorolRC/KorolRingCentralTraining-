package task4;

class GreenApplesFactory extends AbstractFabric {
    @Override
    public Fruit makeFruit() {
        return new Apple(2);
    }
}