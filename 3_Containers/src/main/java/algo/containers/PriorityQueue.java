package algo.containers;

public class PriorityQueue<T> {

    public static void main(String[] args) {
        PriorityQueue<String> queue = new PriorityQueue<>();
    }

    private static int DEFAULT_PRIORITY = 5;

    private DoubleLinkedList<PriorityElement<T>> containers;
    private int size;

    public PriorityQueue() {
        this.containers = new DoubleLinkedList<>();
    }

    //todo
    public void enqueue(int priority, T item) {
    }

    //todo
    public T dequeue() {
        return null;
    }

    private static class PriorityElement<T> {
        private int priority;
        private DoubleLinkedList<T> queue;

        public PriorityElement(int priority) {
            this.priority = priority;
            this.queue = new DoubleLinkedList<>();
        }

        public void add(T item) {
            this.queue.add(item);
        }

        public T get() {
            return this.queue.remove(0);
        }

        public int size() {
            return this.queue.size();
        }
    }

}
