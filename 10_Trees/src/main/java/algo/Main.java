package algo;

import algo.trees.tree.*;
import algo.trees.util.ArrayGenerator;
import java.util.*;

public class Main {

    enum NumSequence {

        RANDOM,
        PART_PERC_RANDOM,
        PART_NUM_RANDOM,
        ASCENDED,
        DESCENDED;


        @Override
        public String toString() {
            switch (this) {
                case RANDOM: return "random";
                case ASCENDED: return "ascended";
                case DESCENDED: return "descended";
                case PART_PERC_RANDOM: return "partially percentage";
                case PART_NUM_RANDOM: return "partially numbers";
                default: throw new NoSuchElementException();
            }
        }
    }


    public static void main(String[] args) {
        Map<String, Tree<Integer>> trees = new LinkedHashMap<>();

        Tree<Integer> bst = new BSTree<>();
        //trees.put("BS Tree", bst);

        Tree<Integer> avlt = new AVLTree<>();
        trees.put("AVL Tree", avlt);

        Tree<Integer> ct = new IntCTree();
        trees.put("C Tree", ct);

        Tree<Integer> splt = new SplayTree<>();
        trees.put("Splay Tree", splt);

        Tree<Integer> rndt = new RNDTree<>();
        trees.put("RND Tree", rndt);

        testIntTrees(trees, 1000000, NumSequence.RANDOM);
        System.out.println();

        trees = new LinkedHashMap<>();

        bst = new BSTree<>();
        //trees.put("BS Tree", bst);

        avlt = new AVLTree<>();
        trees.put("AVL Tree", avlt);

        ct = new IntCTree();
        trees.put("C Tree", ct);

        rndt = new RNDTree<>();
        trees.put("RND Tree", rndt);

        splt = new SplayTree<>();
        trees.put("Splay Tree", splt);

        testIntTrees(trees, 1000000, NumSequence.ASCENDED);
    }


    /*
        Have some problems. Need to resolve. But not now
     */
    public static <T extends Comparable<T>> void testTrees(Map<String, Tree<T>> trees, int itemCount, NumSequence type) {
        System.out.printf("Sort %d elements. Order: %s\n", itemCount, type.toString());
        System.out.printf("| %s | %s | %s | %s |\n", "TreeName", "Add item", "Get Item", "Remove Item");
        System.out.printf("| --- | --- | --- | --- |");

        Integer[] array = null;

        switch (type) {
            case RANDOM: array = ArrayGenerator.generateRandomSequence(itemCount, itemCount); break;
            case DESCENDED: array = ArrayGenerator.generateDescendedSequenceWithoutDuplicates(itemCount); break;
            case ASCENDED: array = ArrayGenerator.generateAscendedSequenceWithoutDuplicates(itemCount); break;
            case PART_PERC_RANDOM: array = ArrayGenerator.generatePartiallyRandomSequencePercentage(itemCount, itemCount, 10); break;
            case PART_NUM_RANDOM: array = ArrayGenerator.generatePartiallyRandomSequenceNumbers(itemCount, itemCount, 10); break;
        }

        for (Map.Entry<String, Tree<T>> entry : trees.entrySet()) {
            Integer[] arr = ArrayGenerator.cloneArray(array);
            //testTree(entry.getValue(), array, "azaza");
        }
    }
    public static <T extends Comparable<T>> void testTree(Tree<T> tree, T[] array) {

    }

    @Deprecated
    public static void testTrees() {

        Integer[] elements = ArrayGenerator.generateAscendedSequenceWithoutDuplicates(10000);

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
    public  static <T extends Number & Comparable<T>> void testTree(Tree<T> tree, T[] elements, String comment) {
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

    public static void testIntTrees(Map<String, Tree<Integer>> trees, int itemCount, NumSequence type) {
        System.out.printf("Test tree for %d elements. Order: %s\n", itemCount, type.toString());
        System.out.printf("| %s | %s | %s | %s |\n", "TreeName", "Add item", "Get Item", "Remove Item");
        System.out.printf("| --- | --- | --- | --- |\n");

        Integer[] array = null;

        switch (type) {
            case RANDOM: array = ArrayGenerator.generateRandomSequence(itemCount, itemCount); break;
            case DESCENDED: array = ArrayGenerator.generateDescendedSequenceWithoutDuplicates(itemCount); break;
            case ASCENDED: array = ArrayGenerator.generateAscendedSequenceWithoutDuplicates(itemCount); break;
            case PART_PERC_RANDOM: array = ArrayGenerator.generatePartiallyRandomSequencePercentage(itemCount, itemCount, 10); break;
            case PART_NUM_RANDOM: array = ArrayGenerator.generatePartiallyRandomSequenceNumbers(itemCount, itemCount, 10); break;
        }

        for (Map.Entry<String, Tree<Integer>> entry : trees.entrySet()) {
            testIntTree(entry.getValue(), array, entry.getKey());
        }
    }



    public static void testIntTree(Tree<Integer> tree, Integer[] elements, String treeName) {
        System.out.printf("| %s |", treeName);
        final int elementsCounter = elements.length;
        final int elementsSearchCounter = elementsCounter / 10;

        long time = testAddToIntTree(tree, elements);
        System.out.printf(" %d |", time);

        List<Integer> elementsShuffled = Arrays.asList(elements);
        Collections.shuffle(elementsShuffled);
        Integer[] arrayShuffled = new Integer[elementsCounter];
        elementsShuffled.toArray(arrayShuffled);

        time = testGetFromIntTree(tree, arrayShuffled, elementsSearchCounter);
        System.out.printf(" %d |", time);

        Collections.shuffle(elementsShuffled);
        arrayShuffled = new Integer[elementsCounter];
        elementsShuffled.toArray(arrayShuffled);

        time = testRemoveFromTree(tree, arrayShuffled, elementsSearchCounter);
        System.out.printf(" %d |\n", time);
    }

    public static long testAddToIntTree(Tree<Integer> tree, Integer[] elements) {
        long start = System.currentTimeMillis();
        for (Integer element : elements) {
            tree.insert(element);
        }
        return System.currentTimeMillis() - start;
    }

    public static long testGetFromIntTree(Tree<Integer> tree, Integer[] elements, int elemCounter) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < elemCounter; i++) {
            tree.search(elements[i]);
        }
        return System.currentTimeMillis() - start;
    }

    public static long testRemoveFromTree(Tree<Integer> tree, Integer[] elements, int elemCounter) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < elemCounter; i++) {
            tree.remove(elements[i]);
        }
        return System.currentTimeMillis() - start;
    }

}
