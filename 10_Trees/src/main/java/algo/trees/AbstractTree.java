package algo.trees;

public abstract class AbstractTree<T extends Comparable<T>> implements Tree<T> {

    protected Node<T> root;
    protected int size;

    public AbstractTree(){
        this.size = 0;
    }

    @Override
    public void insert(T item) {
        Node<T> node = newNode(item);
        insertNode(node);
    }

    protected void insertNode(Node<T> node) {
        if (size == 0) {
            root = node;
        } else {

            Node<T> prev = root;
            Node<T> cursor = root;

            while (cursor != null) {
                prev = cursor;
                int comparator = node.getItem().compareTo(cursor.getItem());

                if (comparator >= 0) {
                    cursor = prev.getRight();
                } else {
                    cursor = prev.getLeft();
                }
            }

            node.linkParent(prev);
        }
        size++;
    }

    @Override
    public boolean search(T item) {
        if (size == 0)
            return false;

        return searchItem(item) != null;
    }

    private Node<T> searchItem(T item) {
        Node<T> founded = null;

        Node<T> prev = root;
        Node<T> cursor = root;
        while (cursor != null) {
            prev = cursor;
            int comparator = item.compareTo(cursor.getItem());

            if (comparator == 0) {
                founded = cursor;
                break;
            }
            if (comparator > 0)
                cursor = prev.getRight();
            else if (comparator < 0) {
                cursor = prev.getLeft();
            }
        }

        return founded;
    }

    @Override
    public void remove(T item) {
        Node<T> removed = searchItem(item);
        if (removed == null) {
            return;
        }

        removeNode(removed);

        size--;
    }

    protected Node<T> removeNode(Node<T> removed) {
        Node<T> replacement = null;
        Node<T> parent = removed.unlinkParent();

        replacement = findMaxNode(removed.getLeft());
        if (replacement != null) {
            //there's left branch with max
            Node<T> maxParent = replacement.unlinkParent();
            Node<T> maxLeft = replacement.unlinkLeft();
            if (maxLeft != null)
                maxLeft.linkParent(maxParent);
        }

        // replace removed by replacement
        if (replacement != null) {
            replacement.linkLeft(removed.unlinkLeft());
            replacement.linkRight(removed.unlinkRight());
        } else {
            replacement = removed.unlinkRight();
        }

        if (parent != null) {
            if (replacement != null)
                replacement.linkParent(parent);
        } else {
            root = replacement;
        }

        return replacement;
    }

    private Node<T> findMaxNode(Node<T> root) {
        Node<T> current = root;
        Node<T> node = null;
        while (current != null) {
            node = current;
            current = current.getRight();
        }

        return node;
    }

    @Override
    public void sort() {
        if (size == 0) return;

        sort(root);
    }

    private void sort(Node<T> node){
        if (node.getLeft() != null)
            sort(node.getLeft());
        System.out.println(node.getItem());
        if (node.getRight() != null)
            sort(node.getRight());
    }

    public abstract Node<T> newNode(T item);
}
