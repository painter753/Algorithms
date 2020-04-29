package algo.trees.tree;

import algo.trees.node.BSNode;
import algo.trees.node.Node;

import java.util.Random;

public class RNDTree<T extends Comparable<T>> implements Tree<T> {

    private Random random = new Random();
    protected Node<T> root;
    protected int size;

    public Node<T> newNode(T item) {
        return new RNDNode<T>(item);
    }

    @Override
    public boolean search(T item) {
        return searchNode(root, item) != null;
    }

    @Override
    public void remove(T item) {
        root = removeNode((RNDNode<T>) root, item);
    }

    @Override
    public void sort() {

    }

    @Override
    public int size() {
        return 0;
    }

    protected Node<T> searchNode(Node<T> parent, T item) {
        if (parent == null) return null;

        int comparator = item.compareTo(parent.getItem());
        if (comparator == 0) {
            return parent;
        }
        if ( comparator > 0) {
            return searchNode(parent.getRight(), item);
        } else {
            return searchNode(parent.getLeft(), item);
        }
    }


    @Override
    public void insert(T item) {
        root = insert(root, item);
        size++;
    }

    private Node<T> insert(Node<T> p, T item) {
        if (p == null) return newNode(item);

        if (random.nextInt() % (getSize((RNDNode) p) + 1) == 0)
            return insertRoot(p, item);

        if (p.getItem().compareTo(item) >= 0)
            p.linkLeft(insert(p.getLeft(), item));
        else
            p.linkRight(insert(p.getRight(), item));
        recalcSize((RNDNode) p);
        return p;
    }

    private Node<T> insertRoot(Node<T> p, T item) {
        if (p == null) return newNode(item);

        if (p.getItem().compareTo(item) >= 0) {
            p.linkLeft(insertRoot(p.getLeft(), item));
            recalcSize((RNDNode) p);
            return rotateRight((RNDNode<T>) p);
        } else {
            p.linkRight(insertRoot(p.getRight(), item));
            recalcSize((RNDNode) p);
            return rotateLeft((RNDNode<T>) p);
        }

    }

    private Node<T> rotateRight(RNDNode<T> p) {
        RNDNode<T> q = (RNDNode<T>) p.getLeft();

        if (q == null) return p;

        p.linkLeft(q.unlinkRight());
        q.linkRight(p);
        q.setSize(getSize(p));
        recalcSize(p);

        return q;
    }

    private Node<T> rotateLeft(RNDNode<T> q) {
        RNDNode<T> p = (RNDNode<T>) q.getRight();

        if (p == null) return q;

        q.linkRight(p.unlinkLeft());
        p.linkLeft(q);
        p.setSize(getSize(q));
        recalcSize(q);

        return p;
    }

    protected RNDNode<T> join(RNDNode<T> p, RNDNode<T> q) {
        if ( p == null ) return q;
        if ( q == null ) return p;

        if (random.nextInt() % (getSize(p) + getSize(q)) < getSize(p)) {
            p.linkRight(join((RNDNode<T>) p.getRight(), q));
            recalcSize(p);
            return p;
        } else {
            q.linkLeft(join(p, (RNDNode<T>) q.getLeft()));
            recalcSize(q);
            return q;
        }
    }

    protected RNDNode<T> removeNode(RNDNode<T> p, T item) {
        if ( p == null) return p;

        int comparator = item.compareTo(p.getItem());
        if (comparator == 0) {
            RNDNode<T> q = join((RNDNode<T>)p.unlinkLeft(), (RNDNode<T>)p.unlinkRight());
            p.unlinkParent();
            return q;
        } else if (comparator < 0) {
            p.linkLeft(removeNode((RNDNode<T>) p.getLeft(), item));
        } else {
            p.linkRight(removeNode((RNDNode<T>)p.getRight(), item));
        }
        return p;
    }






    ///
    public void insertOld(T item) {
        Node<T> node = newNode(item);
        //insertNode(node);

        Node<T> parent = node.getParent();

        if (parent != null) {
            if (random.nextInt(10) % (2 + 1) == 0) {
                root = upToRoot(parent, node);
            }
        }
    }
    private Node<T> upToRoot(Node<T> parent, Node<T> node) {
        if (parent == null)
            return node;

        if (parent.getItem().compareTo(node.getItem()) >= 0) {
            //rightRotation
            rightRotation(parent);
        } else {
            //leftRotation
            leftRotation(parent);
        }
        return upToRoot(node.getParent(), node);
    }


    public void rightRotation(Node<T> a) {
        Node<T> parent = a.unlinkParent();

        Node<T> b = a.unlinkLeft();
        Node<T> c = b.unlinkRight();

        a.linkLeft(c);
        b.linkRight(a);
        b.linkParent(parent);
        recalcSize((RNDNode) a);
    }

    public void leftRotation(Node<T> a) {
        Node<T> parent = a.unlinkParent();

        Node<T> b = a.unlinkRight();
        Node<T> c = b.unlinkLeft();

        b.linkLeft(a);
        a.linkRight(c);
        b.linkParent(parent);
        recalcSize((RNDNode) a);
    }

    public int getSize(RNDNode node) {
        return (node == null) ? 0 : node.size;
    }

    public void recalcSize(RNDNode node) {
        node.setSize(getSize((RNDNode) node.getLeft()) + getSize((RNDNode) node.getRight()) + 1);
    }

    private class RNDNode<T extends Comparable<T>> extends BSNode<T> implements Node<T> {

        protected int size;

        public RNDNode(T item) {
            super(item);
            size = 1;
        }

        public void setSize(int size) {
            this.size = size;
        }
    }

}
