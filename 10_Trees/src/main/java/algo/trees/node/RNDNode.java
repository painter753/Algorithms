package algo.trees.node;

public class RNDNode<T extends Comparable<T>> extends BSNode<T> implements HasSize {

    protected int size = 0;

    public RNDNode(T item) {
        super(item);
        size = 1;
    }

    @Override
    public void setSize(int i) {
        this.size = i;
    }
}
