package algo.containers;

public class Stack<T> {

    private Node<T> head;

    public Stack() {
        head = null;
    }

    public void push(T item) {
        this.head = new Node<>(item, head);
    }

    public T pop() {
        if (isEmpty())
            return null;
        T item = head.getItem();
        head = head.getNext();
        return item;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
