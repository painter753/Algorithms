package algo.trees;

import java.util.Random;

public abstract class CTree<T extends Comparable<T>> extends AbstractTree<T>{

    protected Node<T> root;

    protected int seed;
    protected Random random;

    public CTree() {
        super();
        seed = 100;
        random = new Random();
    }

    @Override
    public void insert(T item) {
        CNode<T> node = newNode(item);
        if (size == 0) {
            root = node;
        } else {
            insertNode(node);
        }

        size++;
        reconfigureRandom();
    }

    @Override
    protected void insertNode(Node<T> insertedNode) {
        CNode<T> leftBranch = new CNode<>(null, 0);
        CNode<T> rightBranch = new CNode<>(null, 0);

        T item = insertedNode.getItem();

        split((CNode<T>) root, item, leftBranch, rightBranch);

        CNode<T> node = (CNode<T>) insertedNode;
        CNode<T> leftResult = merge(deleteFakeRoot(leftBranch), node);

        root = merge(leftResult, deleteFakeRoot(rightBranch));
    }

    public void remove(T item) {
        if (size == 0) return;

        CNode<T> leftFake = newNode(null);
        CNode<T> rightFake = newNode(null);

        root = removeNode((CNode<T>) root, item, leftFake, rightFake);

        size--;

    }

    protected CNode<T> removeNode(CNode<T> tree, T item, CNode<T> leftBranch, CNode<T> rightBranch) {
        // разделить по элемнту item - 1
        // Рполучилит две пирамиды: в одной значения ччетко меньше item,  вдругой содержится item и все элементы > item
        // вторую пирамиду разделяем еще раз на 2 по элементу item
        // получаем пирамиду из одного элемента item и пирамиду со значениями > item
        // соединяем пирамиду полученную вначале и в конце. профит

        T prevValue = getPrevDiscreteValue(item);

        split(tree, prevValue, leftBranch, rightBranch);

        CNode<T> nextTree = deleteFakeRoot(rightBranch);

        CNode<T> leftFakeBranch = new CNode<>(null, 0);
        CNode<T> rightFakeBranch = new CNode<>(null, 0);

        split(nextTree, item, leftFakeBranch, rightFakeBranch );

        return merge(deleteFakeRoot(leftBranch), deleteFakeRoot(rightFakeBranch));
    }

    private CNode<T> deleteFakeRoot(CNode<T> node) {
        if (node.getItem() == null) {
            CNode<T> child = (CNode<T>) node.unlinkRight();
            return child;
        }
        return null;
    }

    @Override
    public CNode<T> newNode(T item) {
        return new CNode<>(item, random.nextInt(seed));
    }

    protected abstract T getPrevDiscreteValue(T item);

    private void reconfigureRandom() {
        if (size > 0.75 * seed) {
            this.seed = (int) (seed * 1.5);
        }
    }

    // first call splitTree(root, splitter, fakeLeft, fakeRight)
    protected void split(CNode<T> tree, T splitter, CNode<T> left, CNode<T> right) {
        if (tree == null) return;

        int comparator = tree.getItem().compareTo(splitter);
        if (comparator < 0 ) {
            CNode<T> rightNode = tree.unlinkRight();
            tree.linkParent(left);
            split(rightNode, splitter, tree, right);
        } else {
            CNode<T> leftNode = tree.unlinkLeft();
            tree.linkParent(right);
            split(leftNode, splitter, left, tree);
        }
    }

    protected CNode<T> merge(CNode<T> left, CNode<T> right) {
        CNode<T> result = null;

        //criteria
        if (left == null) {
            result = right;
        } else if (right == null) {
            result = left;
        } else {
            int leftPriority = left.getPriority();
            int rightPriority = right.getPriority();

            if (leftPriority > rightPriority) {
                CNode<T> l1 = left.unlinkRight();
                left.linkRight(merge(l1, right));
                result = left;
            } else {
                CNode<T> r1 = right.unlinkLeft();
                right.linkLeft(merge(left, r1));
                result = right;
            }
        }
        return result;
    }

}
