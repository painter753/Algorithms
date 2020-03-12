package algo.containers;

public class DoubleLinkedList<T> implements IArray<T> {

    public static void main(String[] args) {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.add(1);
        list.add(4);
        list.add(12);
        list.add(11);
        list.add(7);
        list.add(3);
        list.add(14);

        System.out.println(list);


        System.out.println(list.get(0));
        System.out.println(list.get(3));
        System.out.println(list.get(list.size - 1));
    }

    private int size;
    private Node<T> head;
    private Node<T> tail;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {
        Node<T> node = new Node<>(item);
        if (size == 0) {
            head = tail = node;
        } else {
            node.setPrev(tail);
            this.tail.setNext(node);
            this.tail = node;
        }
        this.size++;
    }

    //todo check
    @Override
    public T get(int index) {
        T value = null;

        if (index == 0) {
            value = this.head.getItem();
        } else if (index == size - 1) {
            value = this.tail.getItem();
        } else {
            Node<T> node = this.head.getNext();
            for (int i = 1; i < index; i++)
                node = node.getNext();
            value = node.getItem();
        }

        return value;
    }

    @Override
    public void clear() {
        this.head = this.tail = null;
        this.size = 0;
    }

    @Override
    public void add(T item, int index) {
        if (index < 0 || index > size)
            throw new ArrayIndexOutOfBoundsException();
        Node<T> node = new Node<>(item);
        if (index == size) {
            add(item);
            return;
        } else if (index == 0) {
            node.setNext(this.head);
            this.head.setPrev(node);
            this.head = node;
        } else if ( index == size - 1 ) {
             Node<T> prev = this.tail.getPrev();
             this.tail.setPrev(node);
             prev.setNext(node);
             node.setPrev(prev);
             node.setNext(this.tail);
        } else {
            Node<T> current = this.head.getNext();
            for (int i = 1; i < index ; i++)
                current = current.getNext();

            node.setPrev(current.getPrev());
            node.setNext(current);
            current.getPrev().setNext(node);
            current.setPrev(node);
        }
        this.size++;

    }

    @Override
    public T remove(int index) {
        if (index < 0 || index > size)
            throw new ArrayIndexOutOfBoundsException();

        T value = null;

        if (this.size == 1) {
            value = this.head.getItem();
            this.head = this.tail = null;
        } else if (index == 0) {
            value = this.head.getItem();

            Node<T> next = this.head.getNext();
            next.setPrev(null);
            this.head.setNext(null);
            this.head = next;
        } else if (index == size - 1) {
            value = this.tail.getItem();
            Node<T> prev = this.tail.getPrev();
            prev.setNext(null);
            this.tail.setPrev(null);
            this.tail = prev;
        } else {
            Node<T> node = this.head.getNext();
            for (int i = 1; i < index; i++)
                node = node.getNext();
            value = node.getItem();

            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());

            node.setPrev(null);
            node.setNext(null);
        }
        this.size--;

        return value;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Size: ").append(size).append(" [");

        Node<T> node = this.head;
        builder.append(node.getItem()).append(",");
        while ((node = node.getNext()) != null) {
            builder.append(node.getItem()).append(",");
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append("]");
        return builder.toString();
    }

    protected static class Node<T> {

        private T item;
        private Node<T> prev;
        private Node<T> next;

        public Node(T item) {
            this.item = item;
        }

        public Node(T item, Node<T> prev, Node<T> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public T getItem() {
            return item;
        }
    }
}
