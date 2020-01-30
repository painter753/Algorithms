package algo.containers;

public class SingleArray<T> implements IArray<T> {

    // causes problems because array = new T[capaacity] throw error and you should create Object[] and cast to T[]
    private T[] array;
    private int size;

    //private Object[] array2;

    @SuppressWarnings("unchecked")
    public SingleArray() {
        array = (T[]) new Object[0];
        size = array.length;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {
        array = resize(array,1);
        size = array.length;
        array[size() - 1] = item;
    }

    @Override
    public T get(int index) {
        return array[index];
    }

    @Override
    public void clear() {
        array = (T[]) new Object[0];
        size = array.length;
    }

    @Override //todo check method
    public void add(T item, int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }

        int oldArraySize = size();
        array = resize(array, 1);
        size = array.length;
        System.arraycopy(array, index, array, index + 1, oldArraySize - index );
        array[index] = item;
    }

    @Override
    @SuppressWarnings("unchecked")//todo check method
    public T remove(int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }

        T item = get(index);
        if (index == size() - 1 ) {
            array[index] = null;

        } else {
            System.arraycopy(array, index + 1, array, index, size() - index - 1);
        }
        size--;

        return item;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (array.length == 0) return "no";
        for (int i = 0; i < size(); i++) {
            builder.append(array[i].toString()).append(" ");
        }
        return builder.toString();
    }
}
