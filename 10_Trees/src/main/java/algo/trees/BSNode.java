package algo.trees;

public class BSNode<T extends Comparable<T>> implements Node<T>{

    protected Node<T> left;
    protected Node<T> right;
    protected Node<T> parent;

    private T item;

    public BSNode(T item) {
        this.item = item;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }
    public void setRight(Node<T> right) {
        this.right = right;
    }
    public void setParent(Node<T> parent) {
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

    public T getItem() {
        return item;
    }
}
