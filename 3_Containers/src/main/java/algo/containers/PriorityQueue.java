package algo.containers;

public class PriorityQueue<T> {

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        queue.enqueue(4, 2);
        queue.enqueue(1, 1);
        queue.enqueue(4, 2);
        queue.enqueue(1, 1);
        queue.enqueue(4, 2);
        queue.enqueue(1, 1);
        queue.enqueue(10, 4);
        queue.enqueue(0, 100);



        System.out.println(queue);

        System.out.println(queue.dequeue());
        System.out.println(queue);

    }

    private static int DEFAULT_PRIORITY = 5;

    private DoubleLinkedList<PriorityList<T>> containers;
    private int size;

    public PriorityQueue() {
        this.containers = new DoubleLinkedList<>();
    }

    public void enqueue(int priority, T item) {

        if (size() == 0) {
            PriorityList<T> list = new PriorityList<>(priority);
            list.add(item);
            containers.add(list);
        } else {
            int cursor = 0;
            while (cursor < containers.size()) {
                if (containers.get(cursor).priority > priority)
                    cursor++;
                else
                    break;
            }

            if (containers.size() == cursor) {
                PriorityList<T> list = new PriorityList<>(priority);
                list.add(item);
                containers.add(list);
            } else if (containers.get(cursor).priority == priority) {
                containers.get(cursor).add(item);
            } else {
                PriorityList<T> list = new PriorityList<>(priority);
                list.add(item);
                containers.add(list, cursor);
            }
        }

        size++;
    }

    //todo
    public T dequeue() {
        if (size() == 0) return null;

        T element = containers.get(0).get();
        if (containers.get(0).size() == 0)
            containers.remove(0);

        size--;
        return element;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Size: ").append(size).append(" [");
        for (int i = 0; i < containers.size(); i++) {
            PriorityList<T> list = containers.get(i);
            builder.append(list).append(",");
        }

        builder.deleteCharAt(builder.length() - 1);
        builder.append("]");
        return builder.toString();
    }

    private static class PriorityList<T> {
        private int priority;
        private DoubleLinkedList<T> queue;

        public PriorityList(int priority) {
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

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{").append(priority).append(":");
            for (int i = 0; i < queue.size(); i++) {
                builder.append(queue.get(i)).append(",");
            }
            builder.append("}");
            return builder.toString();
        }
    }

}
