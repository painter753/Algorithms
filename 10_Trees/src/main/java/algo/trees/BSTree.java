package algo.trees;

public class BSTree<T extends Comparable<T>> extends AbstractTree<T> {

    private boolean searchItemRec(T item, Node<T> node) {
        if (node == null)
            return false;

        int comparison = item.compareTo(node.getItem());
        if (comparison == 0)
            return  true;

        if (comparison > 0)
            return searchItemRec(item, node.getRight());
        else
            return searchItemRec(item, node.getLeft());
    }
    private void insertItemRec(T item, Node<T> node) {
        if (node.getItem().compareTo(item) < 0)
            if (node.getLeft() != null)
                insertItemRec(item, node.getLeft());
            else
                node.getLeft();//setLeft(new Node<>(item));
        else
        if (node.getRight() != null)
            insertItemRec(item, node.getRight());
        else
            node.getRight();//setRight(new Node<>(item));
    }

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
