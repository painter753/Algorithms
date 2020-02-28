package algo.containers;

public abstract class AbstractArray<T> implements IArray<T> {

    protected T[] array;
    protected int size;

    @SuppressWarnings("unchecked")
    public AbstractArray(int initCapacity) {
        this.array = (T[]) new Object[initCapacity];
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {
        if (array.length == size())
            array = resize(array,1);
        array[size()] = item;
        size++;
    }

    @Override
    public void add(T item, int index) {
        checkIndex(index);

        if (index == size()) {
            add(item);
        } else {
            int oldArraySize = size();
            if (array.length == size()) {
                array = resize(array, getCapacityIncrement());
            }

            System.arraycopy(array, index, array, index + 1, oldArraySize - index);
            array[index] = item;
            size++;
        }
    }

    @Override
    public T get(int index) {
        checkIndex(index);

        return array[index];
    }

    @Override
    public void clear() {
        array = (T[]) new Object[0];
        this.size = 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        checkIndex(index);

        T item = get(index);
        System.arraycopy(array, index + 1, array, index, size() - index - 1);
        size--;

        return item;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (array.length == 0) return "no elements";
        for (int i = 0; i < size(); i++) {
            builder.append(array[i].toString()).append(" ");
        }
        return builder.toString();
    }

    protected void checkIndex(int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Invalid index:" + index);
        }
    }

    protected abstract int getCapacityIncrement();

}
