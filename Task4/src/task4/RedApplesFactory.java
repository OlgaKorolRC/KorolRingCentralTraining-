package task4;

class RedApplesFactory extends AbstractFabric {
    @Override
    public Fruit makeFruit() {
        return new Apple(0);
    }
}
