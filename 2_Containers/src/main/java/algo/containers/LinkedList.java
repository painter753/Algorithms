package algo.containers;

public class LinkedList<T> implements IArray<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList() {
        head = tail = null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {
        Node<T> node = new Node<>(item);
        if (size == 0)
            head = tail = node;
        else {
            tail.setNext(node);
            tail = node;
        }
        size++;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        T item = null;
        if (index == size() - 1)
            item = tail.getItem();
        else
            item = getNode(index).getItem();
        return item;
    }

    private Node<T> getNode(int index) {
        Node<T> node = null;
        if (index == size() - 1)
            node = tail;
        else {
            node = head;
            for (int i = 0; i < index; i++)
                node = node.getNext();
        }
        return node;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public void add(T item, int index) {
        checkIndex(index);
        Node<T> node = new Node<>(item);
        if (index == 0) {
            node.setNext(head);
            head = node;
        } else {
            Node<T> prev = getNode(index - 1);
            node.setNext(prev.getNext());
            prev.setNext(node);
        }
        size++;
    }

    @Override
    public T remove(int index) {
        checkIndex(index);
        T item = null;
        if (index == 0) {
            item = head.getItem();
            head = head.getNext();
        } else {
            Node<T> prev = getNode(index - 1);
            item = prev.getNext().getItem();
            prev.setNext(prev.getNext().getNext());
        }
        size--;
        return item;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException();
    }
}
