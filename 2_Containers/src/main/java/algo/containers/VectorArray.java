package algo.containers;

public class VectorArray<T> extends AbstractArray<T>{

    private int vector;

    public VectorArray() {
        this(0, 100);
    }

    public VectorArray(int vector) {
        this(0, vector);
    }

    @SuppressWarnings("unchecked")
    private VectorArray(int initCapacity, int vector) {
        super(initCapacity);
        this.vector = vector;
    }



    protected int getCapacityIncrement() {
        return this.vector;
    }
}
