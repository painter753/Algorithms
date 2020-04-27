package algo.trees.node;

public class AVLNode<T extends Comparable<T>> extends BSNode<T> implements HasHeight {

    private int height;

    public AVLNode(T item) {
        super(item);
        this.height = 1;
    }

    @Override
    public AVLNode<T> getLeft() {
        return (AVLNode<T>) super.getLeft();
    }

    @Override
    public AVLNode<T> getRight() {
        return (AVLNode<T>) super.getRight();
    }

    @Override
    public AVLNode<T> getParent() {
        return (AVLNode<T>) super.getParent();
    }

    public int getHeight() {
        return this.height;
    }

    public void updateHeight() {
        int leftHeight = getLeft() == null ? 0 : getLeft().getHeight();
        int rightHeight = getRight() == null ? 0 : getRight().getHeight();
        this.height =  Math.max(leftHeight, rightHeight) + 1;
    }

    public int getBalance() {
        int leftHeight = getLeft() == null ? 0 : getLeft().getHeight();
        int rightHeight = getRight() == null ? 0 : getRight().getHeight();
        int balance = rightHeight - leftHeight;
        return balance;
    }

}
