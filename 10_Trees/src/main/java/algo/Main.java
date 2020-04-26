package algo;

import algo.trees.RandomBSTree;
import algo.trees.tree.*;
import algo.trees.util.ArrayGenerator;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Tree<Integer> dtree = new IntCTree();

        Integer[] array = ArrayGenerator.generateAscendedSequence(100000, 100000);
        //for (Integer integer : array) {
        //    dtree.insert(integer);
        //}

        testOtherTree(new RandomBSTree(), array, "some");




        // int[] array = new int[10];
        // Tree<Integer> btree1 = new BSTree<>();
         testTrees();
    }

    public static void testTrees() {

        Integer[] elements = ArrayGenerator.generateAscendedSequence(10000, 100000);

        Tree<Integer> btree1 = new BSTree<>();
        //testTree(btree1, elements, " btree ascending");
        Tree<Integer> avltree1 = new AVLTree<>();
        testTree(avltree1, elements, " avltree ascending");
        Tree<Integer> dtree1 = new IntCTree();
        testTree(dtree1, elements, "dtree ascending");

        Tree<Integer> rndtree1 = new RNDTree<>();
        testTree(rndtree1, elements, "rndtree ascending");

        if (true) return;
        elements = ArrayGenerator.generateRandomSequence(200000, 100000);

        Tree<Integer> btree2 = new BSTree<>();
        //testTree(btree2, elements, "btree random");
        Tree<Integer> avltree2 = new AVLTree<>();
        testTree(avltree2, elements, "avltree random");
        Tree<Integer> dtree2 = new IntCTree();
        testTree(dtree2, elements, "dtree random");

    }

    public  static <T extends Comparable<T>> void testTree(Tree<T> tree, T[] elements, String comment) {
        System.out.printf("Testing with %s array. size: %d \n", comment, elements.length);
        final int elementsCounter = elements.length;
        final int elementsSearchCounter = elementsCounter / 10;

        long start = System.currentTimeMillis();
        for (T element : elements) {
            tree.insert(element);
        }
        long end = System.currentTimeMillis() - start;
        System.out.printf("Insertion: %d \n", end);

        List<T> elementsShuffled = Arrays.asList(elements);
        Collections.shuffle(elementsShuffled);

        start = System.currentTimeMillis();
        for (int i = 0; i < elementsSearchCounter; i++) {
            tree.search(elementsShuffled.get(i));
        }
        end = System.currentTimeMillis() - start;
        System.out.printf("Searching: %d \n", end);

        Collections.shuffle(elementsShuffled);

        start = System.currentTimeMillis();
        for (int i = 0; i < elementsSearchCounter; i++) {
            tree.remove(elementsShuffled.get(i));
        }
        end = System.currentTimeMillis() - start;
        System.out.printf("Removing: %d \n", end);
    }

    public  static void testOtherTree(RandomBSTree tree, Integer[] elements, String comment) {
        System.out.printf("Testing with %s array. size: %d \n", comment, elements.length);
        final int elementsCounter = elements.length;
        final int elementsSearchCounter = elementsCounter / 10;

        long start = System.currentTimeMillis();
        for (Integer element : elements) {
            tree.insert(element);
        }
        long end = System.currentTimeMillis() - start;
        System.out.printf("Insertion: %d \n", end);

        List<Integer> elementsShuffled = Arrays.asList(elements);
        Collections.shuffle(elementsShuffled);

        start = System.currentTimeMillis();
        for (int i = 0; i < elementsSearchCounter; i++) {
            tree.search(elementsShuffled.get(i));
        }
        end = System.currentTimeMillis() - start;
        System.out.printf("Searching: %d \n", end);

        Collections.shuffle(elementsShuffled);

        start = System.currentTimeMillis();
        for (int i = 0; i < elementsSearchCounter; i++) {
            tree.remove(elementsShuffled.get(i));
        }
        end = System.currentTimeMillis() - start;
        System.out.printf("Removing: %d \n", end);
    }


}
