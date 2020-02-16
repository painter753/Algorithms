package algo.containers;

// O(n log n)
public class FactorArray<T> extends AbstractArray<T> {

    private int factor;

    @SuppressWarnings("unchecked")
    private FactorArray(int initCapacity, int factor) {
        super(initCapacity);
        this.factor = factor;
    }

    public FactorArray() {
        this(10, 100);
    }

    public FactorArray(int factor) {
        this(10, factor);
    }

    protected int getCapacityIncrement() {
        return size() * this.factor / 100;
    }
}
