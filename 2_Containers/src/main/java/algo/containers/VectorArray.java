package algo.containers;

public class VectorArray<T> implements IArray<T>{


    // causes problems because array = new T[capaacity] throw error and you should create Object[] and cast to T[]
    private T[] array;
    private int vector;
    private int size;


    //private Object[] array2;

    @SuppressWarnings("unchecked")
    public VectorArray(int vector) {
        array = (T[]) new Object[0];
        this.vector = vector;
        this.size = 0;
    }


    public VectorArray() {
        this(100);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {
        if( size() == array.length)
            array = resize(array, vector);
        array[size] = item;
        size++;
    }

    @Override
    public T get(int index) {
        return array[index];
    }

    @Override
    public void clear() {
        this.array = (T[]) new Object[0];
        this.size = 0;
    }

    @Override
    public void add(T item, int index) {
        // add to the end
        if (index == array.length) {
            add(item);
        } else {
            if (size() == array.length) {
                //need to resize
                int oldArraySize = size();
                array = resize(array, vector);
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
            throw new IndexOutOfBoundsException("Invalid index:" + index);
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
        for (int i = 0; i < size() ; i++ ) {
            builder.append(array[i].toString()).append(" ");
        }
        return builder.toString();
    }
}
