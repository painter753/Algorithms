package algo;

import algo.trees.AVLTree;
import algo.trees.BSTree;
import algo.trees.Tree;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[10];

        testTrees();
    }

    public static void testTrees() {
        int[] elements = new int[]{100000, 5000};

        Tree<Integer> btree1 = new BSTree<>();
        //testTree(btree1, false);

        Tree<Integer> avltree1 = new AVLTree<>();
        //testTree(avltree1, false);

        Tree<Integer> btree2 = new BSTree<>();
        //testTree(btree2, true);

        Tree<Integer> avltree2 = new AVLTree<>();
        testTree(avltree2, true);
    }

    public static void testTree(Tree<Integer> tree, boolean useRandom) {
        final int elements = 150000;
        final int elementsSearch = elements / 10;

        long start = System.currentTimeMillis();
        if (!useRandom) {
            for (int i = 0; i < elements; i++)
                tree.insert(i);
        } else {
            Random random = new Random();
            for (int i = 0; i < elements; i++) {
                tree.insert(random.nextInt(elements));
            }
        }
        long end = System.currentTimeMillis() - start;
        System.out.println("Insert ended: " + end);

        start = System.currentTimeMillis();
        Random random = new Random();
        for (int i = 0; i < elementsSearch; i++) {
            tree.search(random.nextInt(elementsSearch));
        }
        end = System.currentTimeMillis() - start;
        System.out.println("Search ended: " + end);

        //start = System.currentTimeMillis();
        //for (int i = 0; i < elementsSearch; i++) {
        //    tree.remove(random.nextInt(elementsSearch));
        //}
        //end = System.currentTimeMillis() - start;
        //System.out.println("Remove ended: " + end);
    }

}
