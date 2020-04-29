package algo.trees.tree;

import algo.trees.node.BSNode;
import algo.trees.node.Node;

public class SplayTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;
    private int size;

    public static void main(String[] args) {
        Tree<Integer> spl = new SplayTree<>();

        for (int i = 0; i < 10; i++) {
            int n = (int)(Math.random() * 100);
            System.out.printf("Size tree : %d , try insert %d \n",spl.size(), n);
            spl.insert(n);
        }

        spl.search(0);
    }

    protected Node<T> newNode(T item) {
        return new BSNode<>(item);
    }

    @Override
    public void insert(T item) {
        //Node<T> node = insert(root, item);
        Node<T> inserted = insertNode(newNode(item));
        root = splay(inserted);
        size++;
    }

    private Node<T> insertNode(Node<T> node) {
        if (root == null) {
            root = node;
        } else {

            Node<T> prev = root;
            Node<T> cursor = root;

            while (cursor != null) {
                prev = cursor;
                int comparator = node.getItem().compareTo(cursor.getItem());

                if (comparator >= 0) {
                    cursor = prev.getRight();
                } else {
                    cursor = prev.getLeft();
                }
            }

            node.linkParent(prev);
        }
        return node;
    }

    private Node<T> insert(Node<T> p, T item) {
        if (p == null) return newNode(item);

        if (p.getItem().compareTo(item) >= 0)
            p.linkLeft(insert(p.getLeft(), item));
        else
            p.linkRight(insert(p.getRight(), item));
        return p;
    }

    private Node<T> splay(Node<T> node) {
        if (node.getParent() == null) {
            return node;
        }

        Node<T> parent = node.getParent();
        Node<T> gparent = parent.getParent();

        if (gparent == null ) {
            // make simple rotate and return node
            rotate(parent, node);
            return node;
        } else {
            boolean isZigZig = (gparent.getLeft() == parent) == (parent.getLeft() == node);
            if (isZigZig) {
                rotate(gparent, parent);
                rotate(parent, node);
            } else {
                rotate(parent, node);
                rotate(gparent, node);
            }
            return splay(node);
        }
    }

    private Node<T> rotate(Node<T> parent, Node<T> child) {
        Node<T> gp = parent.unlinkParent();

        Node<T> p = child.unlinkParent();
        int comparator = child.getItem().compareTo(p.getItem());
        if (comparator >= 0) {
            Node<T> leftFuture = child.unlinkLeft();
            parent.linkRight(leftFuture);
            child.linkLeft(parent);
        } else {
            Node<T> rightFuture = child.unlinkRight();
            parent.linkLeft(rightFuture);
            child.linkRight(parent);
        }

        child.linkParent(gp);
        return child;
    }

    @Override
    public boolean search(T item) {
        if (root == null)
            return false;

        root = searchNode(root, item);
        return  root.getItem().compareTo(item) == 0 ;
    }

    public Node<T> searchNode(Node<T> node, T key) {
        if (node == null)
            return null;

        int comparator = node.getItem().compareTo(key);
        if (comparator == 0)
            return splay(node);
        if (comparator > 0 && node.getLeft() != null)
            return searchNode(node.getLeft(), key);
        if (comparator < 0 && node.getRight() != null)
            return searchNode(node.getRight(), key);
        return splay(node);
    }

    @Override
    public void remove(T item) {
        if (root == null)
            return;

        Node<T> node = searchNode(root, item);
        if (root.getItem().compareTo(item) == 0) {
            root = deleteRoot(root);
            size--;
        }
    }

    private Node<T> deleteRoot(Node<T> node) {
        Node<T> left = node.unlinkLeft();
        Node<T> right = node.unlinkRight();

        if (left == null)
            return right;
        if (right == null)
            return left;

        Node<T> max = findMaxNode(left);
        max = splay(max);
        max.linkRight(right);

        return max;
    }

    private Node<T> findMaxNode(Node<T> root) {
        Node<T> current = root;
        Node<T> node = null;
        while (current != null) {
            node = current;
            current = current.getRight();
        }

        return node;
    }

    @Override
    public void sort() {

    }

    @Override
    public int size() {
        return size;
    }
}
