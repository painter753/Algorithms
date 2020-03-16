package algo.trees;

import algo.trees.util.TreeUtil;

public class AVLTree<T extends Comparable<T>> extends AbstractTree<T> {

    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>();

        tree.insert(6);
        tree.insert(4);
        tree.insert(2);

        tree.sort();

        tree.insert(1);
        tree.insert(8);
        tree.insert(0);
        tree.insert(4);
        tree.insert(3);
        tree.insert(3);
        tree.insert(7);

    }

    @Override
    public Node<T> newNode(T item) {
        return new AVLNode<>(item);
    }

    @Override
    protected void insertNode(Node<T> node) {
        AVLNode<T> currentNode = (AVLNode<T>) node;
        super.insertNode(node);

        updateNode(currentNode.getParent());
    }

    private void updateNode(AVLNode<T> node) {
        if (node == null) return;
        AVLNode<T> parent = node.getParent();
        node.updateHeight();

        if (node.getBalance() >= 2)
            rightRotation(node);
        else if (node.getBalance() <= -2)
            leftRotation(node);

        updateNode(parent);
    }

    public void rightRotation(AVLNode<T> node) {
        if (TreeUtil.getHeight(node.getLeft().getLeft()) >= TreeUtil.getHeight(node.getLeft().getRight()))
           smallRightRotation(node);
        else
            bigRightRotation(node);
    }

    public void leftRotation(AVLNode<T> node) {
        if (TreeUtil.getHeight(node.getRight().getLeft()) <= TreeUtil.getHeight(node.getRight().getRight()))
           smallLeftRotation(node);
        else
            bigLeftRotation(node);
    }

    public void smallRightRotation(AVLNode<T> a) {
        Node<T> parent = a.unlinkParent();
        AVLNode<T> b = (AVLNode<T>) a.unlinkLeft();
        AVLNode<T> C = (AVLNode<T>) b.unlinkRight();

        a.linkLeft(C);
        b.linkRight(a);

        a.updateHeight();
        b.updateHeight();

        if (parent == null) {
            this.root = b;
        } else {
            b.linkParent(parent);
        }

    }

    public void smallLeftRotation(AVLNode<T> a) {
        Node<T> parent = a.unlinkParent();
        AVLNode<T> b = (AVLNode<T>) a.unlinkRight();
        AVLNode<T> C = (AVLNode<T>) b.unlinkLeft();

        a.linkRight(C);
        b.linkLeft(a);

        a.updateHeight();
        b.updateHeight();

        if (parent == null) {
            this.root = b;
        } else {
            b.linkParent(parent);
        }

    }

    public void bigRightRotation(AVLNode<T> node) {
        Node<T> parent = node.unlinkParent();
        AVLNode<T> left = (AVLNode<T>) node.unlinkLeft();

        AVLNode<T> c = (AVLNode<T>) left.unlinkRight();
        AVLNode<T> M = (AVLNode<T>) c.unlinkLeft();
        AVLNode<T> N = (AVLNode<T>) c.unlinkRight();

        node.linkLeft(N);
        left.linkRight(M);
        c.linkLeft(left);
        c.linkRight(node);

        node.updateHeight();
        left.updateHeight();
        c.updateHeight();

        if (parent == null) {
            this.root = c;
        } else {
            parent.linkChild(c);
        }

    }

    public void bigLeftRotation(AVLNode<T> node) {
        Node<T> parent = node.unlinkParent();
        AVLNode<T> right = (AVLNode<T>) node.unlinkRight();

        AVLNode<T> c = (AVLNode<T>) right.unlinkLeft();
        AVLNode<T> M = (AVLNode<T>) c.unlinkRight();
        AVLNode<T> N = (AVLNode<T>) c.unlinkLeft();

        node.linkRight(N);
        right.linkLeft(M);
        c.linkLeft(node);
        c.linkRight(right);

        node.updateHeight();
        right.updateHeight();
        c.updateHeight();

        if (parent == null) {
            this.root = c;
        } else {
            parent.linkChild(c);
        }
    }

}
