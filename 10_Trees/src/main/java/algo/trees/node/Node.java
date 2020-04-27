package algo.trees.node;

public interface Node<T extends Comparable<T>> {

    T getItem();

    Node<T> getParent();
    Node<T> getLeft();
    Node<T> getRight();

    void setParent(Node<T> node);
    void setLeft(Node<T> node);
    void setRight(Node<T> node);

    default void linkChild(Node<T> node) {
        if (node == null) return;

        int comparator = node.getItem().compareTo(this.getItem());
        if ( comparator > 0 ) {
            this.linkRight(node);
        } else {
            this.linkLeft(node);
        }
    }
    default void linkLeft(Node<T> node) {
        this.setLeft(node);
        if (node != null) {
            node.setParent(this);
        }
    }
    default void linkRight(Node<T> node) {
        this.setRight(node);
        if (node != null) {
            node.setParent(this);
        }
    }
    default void linkParent(Node<T> node) {
        if (node != null) {
            if (this.getItem().compareTo(node.getItem()) >= 0) {
                node.linkRight(this);
            } else {
                node.linkLeft(this);
            }
        }
    }

    default Node<T> unlinkLeft() {
        Node<T> node = getLeft();
        setLeft(null);
        if (node != null) {
            node.setParent(null);
        }

        return node;
    }
    default Node<T> unlinkRight() {
        Node<T> node = getRight();
        setRight(null);
        if (node != null) {
            node.setParent(null);
        }

        return node;
    }
    default Node<T> unlinkParent() {
        Node<T> node = getParent();
        if (node != null) {
            if (this.getItem().compareTo(node.getItem()) >= 0) {
                node.unlinkRight();
            } else {
                node.unlinkLeft();
            }
        }

        return node;
    }

}
