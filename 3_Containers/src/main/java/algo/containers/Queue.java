package algo.containers;

public class Queue<T> {

    private Node<T> head;
    private Node<T> tail;


    public void Queue() {
        head = tail = null;
    }

    public Node<T> getHead() {
        return head;
    }

    public void enqueue(T item) {
        Node<T> node = new Node<>(item);
        if (isEmpty()) {
            head = tail = node;
        } else {
            this.tail.setNext(node);
            this.tail = node;
        }
    }

    public T dequeue() {
        if (isEmpty()) return null;

        T item = getHead().getItem();
        this.head = head.getNext();

        return item;
    }

    public boolean isEmpty() {
        return head == null;
    }

}
