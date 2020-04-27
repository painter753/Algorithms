package algo.trees.tree;

public interface Tree<T> {

    void insert(T item);
    boolean search(T item);
    void remove(T item);

    void sort();
    int size();

}
