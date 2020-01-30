package algo.containers;

public class Node<T> {
    protected T item;
    protected Node<T> next;

    public Node(T item, Node<T> next) {
        this.item = item;
        this.next = next;
    }

    public Node(T item) {
        this(item, null);
    }

    public T getItem() {
        return item;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
