package algo.containers;

public class LinkedArray<T> implements IArray<T> {
    private Queue<T> queue;
    private int size;

    public LinkedArray() {
        this.queue = new Queue<>();
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void add(T item) {
        queue.enqueue(item);
        size++;
    }

    @Override
    public T get(int index) {
        if (index >= size)
            throw new ArrayIndexOutOfBoundsException();

        Node<T> curr = queue.getHead();
        for (int i = 0; i < index; i++) {
            curr = curr.getNext();
        }
        return curr.getItem();
    }

    @Override
    public void clear() {
        this.queue = new Queue<>();
        this.size = 0;
    }

    @Override
    public void add(T item, int index) {
        if (index < 0 || index > size)
            throw new ArrayIndexOutOfBoundsException();

        if (index == size) {
            add(item);
            return;
        } else if (index == 0) {
                Node<T> oldHead = this.queue.getHead();
                this.queue = new Queue<>();
                this.queue.enqueue(item);

                Node<T> node = oldHead;
                this.queue.enqueue(node.getItem());

                while ((node = node.getNext()) != null)
                    this.queue.enqueue(node.getItem());
        } else {
            Node<T> prev = this.queue.getHead();
            Node<T> curr = this.queue.getHead().getNext();
            for (int i = 1; i < index; i++) {
                if (i == index - 1) {
                    prev = curr;
                }
                curr = curr.getNext();
            }
            Node<T> newItem = new Node<>(item);
            newItem.setNext(curr);
            prev.setNext(newItem);
        }
        size++;
    }

    @Override
    public T remove(int index) {
        if ( index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException();
        T item = null;
        if (index == 0) {
            item = this.queue.dequeue();
        } else if (index == size - 1) {
            Node<T> oldHead = this.queue.getHead();
            this.queue = new Queue<>();
            this.queue.enqueue(oldHead.getItem());

            Node<T> node = oldHead.getNext();
            for (int i = 1; i < index; i++) {
                this.queue.enqueue(node.getItem());
                node = node.getNext();
            }
        } else {
            Node<T> prev = this.queue.getHead();
            Node<T> curr = this.queue.getHead().getNext();
            for (int i = 1; i < index; i++) {
                if (i == index - 1) {
                    prev = curr;
                }
                curr = curr.getNext();
            }
            prev.setNext(curr.getNext());
        }

        size--;
        return null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Size: ").append(size).append(" [");

        Node<T> node = queue.getHead();
        builder.append(node.getItem()).append(",");
        while ((node = node.getNext()) != null) {
            builder.append(node.getItem()).append(",");
        }
        builder.append("]");
        return builder.toString();
    }
}
