package algo.trees.tree;

import algo.trees.node.BSNode;
import algo.trees.node.Node;

public class BSTree<T extends Comparable<T>> extends AbstractTree<T> {

    @Override
    public Node<T> newNode(T item) {
        return new BSNode<>(item);
    }

    public static void main(String[] args) {
        BSTree<Integer> tree = new BSTree<>();

        tree.insert(4);
        tree.insert(6);
        tree.insert(3);
        tree.insert(12);
        tree.insert(9);
        tree.insert(10);

        tree.sort();

        tree.remove(12);

        System.out.println();
        tree.sort();

    }
}
