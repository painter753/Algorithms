package algo.trees;

public class CNode<T extends Comparable<T>> extends BSNode<T> {

    protected int priority;

    public CNode(T item, int priority) {
        super(item);
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public CNode<T> unlinkLeft() {
        return (CNode<T>) super.unlinkLeft();
    }

    @Override
    public CNode<T> unlinkRight() {
        return (CNode<T>) super.unlinkRight();
    }

    @Override
    public CNode<T> unlinkParent() {
        return (CNode<T>) super.unlinkParent();
    }

    @Override
    public void linkParent(Node<T> node) {
        if (node != null) {
            if (this.getItem() == null || node.getItem() == null) {
                if (this.getItem() == null) {
                    node.linkLeft(this);
                } else {
                    if (node.getItem() == null) {
                        node.linkRight(this);
                    } else {
                        node.linkLeft(this);
                    }
                }
            } else {
                super.linkParent(node);
            }
        }
    }
}
