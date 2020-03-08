package algo.containers;

import java.util.ArrayList;

// O(n log n)
public class ArrayListWrapper<T> implements IArray<T> {

    private ArrayList<T> array;

    public ArrayListWrapper() {
        this.array = new ArrayList<>();
    }

    @Override
    public int size() {
        return array.size();
    }

    @Override
    public void add(T item) {
        array.add(item);
    }

    @Override
    public T get(int index) {
        return array.get(index);
    }

    @Override
    public void clear() {
        array.clear();
    }

    @Override
    public void add(T item, int index) {
        array.add(index, item);
    }

    @Override
    public T remove(int index) {
        return array.remove(index);
    }
}