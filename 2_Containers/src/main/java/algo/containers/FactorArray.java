package algo.containers;

// O(n log n)
public class FactorArray<T> implements IArray<T> {

    private T[] array;
    private int factor;
    private int size;

    @SuppressWarnings("unchecked")
    public FactorArray(int factor) {
        array = (T[]) new Object[10];
        this.factor = factor;
        this.size = 0;
    }

    public FactorArray() {
        this(100);
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {
        if (size() == array.length) {
            array = resize(array, size() * factor / 100);
        }
        array[size] = item;
        size++;
    }

    @Override
    public T get(int index) {
        return array[index];
    }

    @Override
    public void clear() {
        array = (T[]) new Object[10];
        this.size = 0;
    }

    @Override
    public void add(T item, int index) {
        if (index == array.length) {
            add(item);
        } else {
            if (size() == array.length) {
                //need to resize
                int oldArraySize = size();
                array = resize(array, size() * factor / 100);
                System.arraycopy(array, index, array, index + 1, oldArraySize - index );
                array[index] = item;
            } else {
                //no need for resize
                System.arraycopy(array, index, array, index + 1, size() - index);
                array[index] = item;
            }
            size++;
        }
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }

        T item = array[index];
        System.arraycopy(array, index + 1, array, index, size() - index - 1);
        size--;

        return item;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (array.length == 0) return "no";
        for (int i = 0 ; i < size(); i++ ) {
            builder.append(array[i].toString()).append(" ");
        }
        return builder.toString();
    }
}
