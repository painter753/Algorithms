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

                if (comparator > 0) {
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

        if (size == 1)
            return item.compareTo(root.getItem()) == 0;

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
        Node<T> replacement = null;

        if (removed == null)
            return;

        if (removed.getParent() == null) {
            // removed == root
            replacement = findMaxNode(removed.getLeft());
            if (replacement == null) {
                //there's no left branch
                replacement = removed.getRight();
                removed.unlinkRight();
            } else {
                //replace remove node by max from left branch
                replaceByMaxFromLeftBranch(removed, replacement);
            }
            root = replacement;
        } else {
            // removed != root
            replacement = findMaxNode(removed.getLeft());
            if (replacement == null) {
                //there's no left branch
                replacement = removed.getRight();
                removed.unlinkRight();
                if (replacement != null)
                    //replace removed node by right branch
                    replacement.linkParent(removed.getParent());
                else
                    //removed == leaf
                    removed.unlinkParent();
            } else {
                //replace removed node by max from left branch + link to parent
                replaceByMaxFromLeftBranch(removed, replacement);
                replacement.linkParent(removed.getParent());
            }
        }
        size--;
    }

    private void replaceByMaxFromLeftBranch(Node<T> removed, Node<T> replacement) {
        replacement.unlinkParent();
        replacement.linkLeft(removed.getLeft());
        replacement.linkRight(removed.getRight());
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
