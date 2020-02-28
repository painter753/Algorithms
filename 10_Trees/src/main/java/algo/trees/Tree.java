package algo.trees;

public interface Tree<T> {

    void insert(T value);
    boolean search(T value);
    void remove(T value);

    void sort();

}
