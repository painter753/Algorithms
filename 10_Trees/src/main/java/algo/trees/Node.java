package algo.trees;

public class Node<T extends Comparable<T>> {

    private Node<T> left;
    private Node<T> right;
    private Node<T> parent;

    private T item;

    public Node(T item) {
        this.item = item;
    }

    private void setLeft(Node<T> left) {
        this.left = left;
    }
    private void setRight(Node<T> right) {
        this.right = right;
    }
    private void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public Node<T> getLeft() {
        return left;
    }
    public Node<T> getRight() {
        return right;
    }
    public Node<T> getParent() {
        return parent;
    }

    public void linkLeft(Node<T> node) {
        this.setLeft(node);
        if (node != null) {
            node.setParent(this);
        }
    }
    public void linkRight(Node<T> node) {
        this.setRight(node);
        if (node != null) {
            node.setParent(this);
        }
    }
    public void linkParent(Node<T> node) {
        if (node != null) {
            if (this.getItem().compareTo(node.getItem()) > 0) {
                node.linkRight(this);
            } else {
                node.linkLeft(this);
            }
        }
    }

    public void unlinkLeft() {
        Node<T> node = getLeft();
        setLeft(null);
        if (node != null) {
            node.setParent(null);
        }
    }
    public void unlinkRight() {
        Node<T> node = getRight();
        setRight(null);
        if (node != null) {
            node.setParent(null);
        }
    }
    public void unlinkParent() {
        Node<T> node = getParent();
        if (node != null) {
            if (this.getItem().compareTo(node.getItem()) > 0) {
                node.unlinkRight();
            } else {
                node.unlinkLeft();
            }
        }
    }


    public T getItem() {
        return item;
    }
}
