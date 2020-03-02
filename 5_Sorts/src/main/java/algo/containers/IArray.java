package algo.containers;

public interface IArray<T> {

    int size();
    void add(T item);
    T  get(int index);
    void clear();

    // homework
    void add(T item, int index);
    T remove(int index);

    @SuppressWarnings("unchecked")
    default T[] resize(T[] array, int delta) {
        T[] newArray = (T[]) new Object[size() + delta];
        System.arraycopy(array, 0, newArray, 0, size());
        return newArray;
    }
}
