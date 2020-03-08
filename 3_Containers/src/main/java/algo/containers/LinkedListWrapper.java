package algo.containers;

import java.util.LinkedList;

public class LinkedListWrapper<T> implements IArray<T> {

    private LinkedList<T> linkedList;

    public LinkedListWrapper() {
        linkedList = new LinkedList<>();
    }

    @Override
    public int size() {
        return linkedList.size();
    }

    @Override
    public void add(T item) {
        linkedList.add(item);
    }

    @Override
    public T get(int index) {
        return linkedList.get(index);
    }

    @Override
    public void clear() {
        linkedList.clear();
    }

    @Override
    public void add(T item, int index) {
        linkedList.add(index, item);
    }

    @Override
    public T remove(int index) {
        return linkedList.remove(index);
    }
}
