package algo.containers;

public class SingleArray<T> extends AbstractArray<T> {

    public SingleArray() {
        this(0);
    }

    @SuppressWarnings("unchecked")
    private SingleArray(int initCapacity) {
        super(initCapacity);
    }

    protected int getCapacityIncrement() {
        return 1;
    }


}
