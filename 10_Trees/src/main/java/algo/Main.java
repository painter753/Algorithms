package algo;

import algo.trees.AVLTree;
import algo.trees.BSTree;
import algo.trees.Tree;
import algo.trees.util.ArrayGenerator;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[10];
        Tree<Integer> btree1 = new BSTree<>();


        testTrees();
    }

    public static void testTrees() {

        Integer[] elements = ArrayGenerator.generateAscendedSequence(200000, 100000);

        Tree<Integer> btree1 = new BSTree<>();
        //testTree(btree1, elements, " btree ascending");
        Tree<Integer> avltree1 = new AVLTree<>();
        testTree(avltree1, elements, " avltree ascending");

        elements = ArrayGenerator.generateRandomSequence(200000, 100000);

        Tree<Integer> btree2 = new BSTree<>();
        //testTree(btree2, elements, "btree random");
        Tree<Integer> avltree2 = new AVLTree<>();
        testTree(avltree2, elements, "avltree random");

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


}
