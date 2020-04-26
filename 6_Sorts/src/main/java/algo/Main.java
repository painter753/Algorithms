package algo;

import algo.containers.FactorArray;
import algo.containers.IArray;
import algo.sorts.sort6.*;
import algo.sorts.sort7.HeapSort;
import algo.util.ArrayGenerator;
import algo.util.GapGenerator;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class Main {

    public static void lesson6() {
        Map<String, Consumer<Integer[]>> sorters = new LinkedHashMap<>();

        BubbleSort<Integer> bs = new BubbleSort<>();
        //sorters.put("Basic Bubble Sort", bs::sort);
        //sorters.put("Advanced Bubble Sort", bs::sortAdvanced);
        //sorters.put("Advanced2 Bubble Sort", bs::sortAdvanced2);

        SelectionSort<Integer> ss = new SelectionSort<>();
        //sorters.put("Basic Selection Sort", ss::sortSimple);

        InsertionSort<Integer> is = new InsertionSort<>();
        //sorters.put("Basic Insertion Sort", is::sortSimple);
        //sorters.put("Advanced Insertion Sort", is::sortAdvanced);

        ShellSort<Integer> shs1 = new ShellSort<Integer>();
        sorters.put("Shell Sort", shs1::sort);

        shs1 = new ShellSort<Integer>(GapGenerator.GapType.SHELL_GAP);
        sorters.put("Shell Sort Shell Gaps", shs1::sort);

        shs1 = new ShellSort<Integer>(GapGenerator.GapType.KP_GAP);
        sorters.put("Shell Sort KP Gap", shs1::sort);

        shs1 = new ShellSort<Integer>(GapGenerator.GapType.HIBBARD_GAP);
        sorters.put("Shell Sort HIB Gap", shs1::sort);

        int itemCount = 200000;

        testSorters(sorters, itemCount, NumSequence.RANDOM);
        System.out.println();
        testSorters(sorters, itemCount, NumSequence.PART_PERC_RANDOM);
        System.out.println();
        testSorters(sorters, itemCount, NumSequence.PART_NUM_RANDOM);
        System.out.println();

        itemCount = 1000000;

        testSorters(sorters, itemCount, NumSequence.RANDOM);
        System.out.println();
        testSorters(sorters, itemCount, NumSequence.PART_PERC_RANDOM);
        System.out.println();
        testSorters(sorters, itemCount, NumSequence.PART_NUM_RANDOM);
        System.out.println();
    }

    public static void lesson6Other(){
        Map<String, Consumer<Integer[]>> sorters = new LinkedHashMap<>();

        ShellSort<Integer> shs1 = new ShellSort<Integer>();
        sorters.put("Shell Sort", shs1::sort);

        IntShellSort ishs = new IntShellSort();
        Map<String, Consumer<int[]>> intSorters = new LinkedHashMap<>();
        intSorters.put("Shell Sort for int", ishs::sort);

        testSorters(sorters, 100000, NumSequence.RANDOM);
        testIntSorters(intSorters, 100000, NumSequence.RANDOM);
    }

    public static void lesson7() {
        Map<String, Consumer<Integer[]>> sorters = new LinkedHashMap<>();

        ShellSort<Integer> shs1 = new ShellSort<Integer>();
        sorters.put("Shell Sort", shs1::sort);

        shs1 = new ShellSort<Integer>(GapGenerator.GapType.KP_GAP);
        sorters.put("Shell Sort KP Gap", shs1::sort);

        shs1 = new ShellSort<Integer>(GapGenerator.GapType.HIBBARD_GAP);
        sorters.put("Shell Sort HIB Gap", shs1::sort);

        HeapSort<Integer> hs = new HeapSort<>();
        sorters.put("Heap sort", hs::sort);


        int itemCount = 200000;
        testSorters(sorters, itemCount, NumSequence.RANDOM);
        System.out.println();
        testSorters(sorters, itemCount, NumSequence.PART_PERC_RANDOM);
        System.out.println();

        itemCount = 1000000;
        testSorters(sorters, itemCount, NumSequence.RANDOM);
        System.out.println();
        testSorters(sorters, itemCount, NumSequence.PART_PERC_RANDOM);
        System.out.println();


    }

    public static void main(String[] args) {
        lesson7();
    }

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

    public static void testSorters (Map<String, Consumer<Integer[]>> consumers, int itemCount, NumSequence type) {

        System.out.printf("Sort %d elements. Order: %s\n", itemCount, type.toString());
        System.out.printf("%s | %s\n", "SorterName", "Evaluation time");

        Integer[] array = null;

        switch (type) {
            case RANDOM: array = ArrayGenerator.generateAbsoluteRandomSequence(itemCount, itemCount); break;
            case DESCENDED: array = ArrayGenerator.generateDescendedSequenceWithoutDuplicates(itemCount); break;
            case ASCENDED: array = ArrayGenerator.generateAscendedSequenceWithoutDuplicates(itemCount); break;
            case PART_PERC_RANDOM: array = ArrayGenerator.generatePartiallyRandomSequencePercentage(itemCount, itemCount, 10); break;
            case PART_NUM_RANDOM: array = ArrayGenerator.generatePartiallyRandomSequenceNumbers(itemCount, itemCount, 10); break;
        }

        for (Map.Entry<String, Consumer<Integer[]>> entry : consumers.entrySet()) {
            Integer[] arr = ArrayGenerator.cloneArray(array);
            testSorter(entry.getValue(), arr, entry.getKey());
        }

    }

    public static void testIntSorters(Map<String, Consumer<int[]>> consumers, int itemCount, NumSequence type) {

        System.out.printf("Sort %d elements. Order: %s\n", itemCount, type.toString());
        System.out.printf("%s | %s\n", "SorterName", "Evaluation time");

        Integer[] array = null;

        switch (type) {
            case RANDOM: array = ArrayGenerator.generateAbsoluteRandomSequence(itemCount, itemCount); break;
            case DESCENDED: array = ArrayGenerator.generateDescendedSequenceWithoutDuplicates(itemCount); break;
            case ASCENDED: array = ArrayGenerator.generateAscendedSequenceWithoutDuplicates(itemCount); break;
            case PART_PERC_RANDOM: array = ArrayGenerator.generatePartiallyRandomSequencePercentage(itemCount, itemCount, 10); break;
            case PART_NUM_RANDOM: array = ArrayGenerator.generatePartiallyRandomSequenceNumbers(itemCount, itemCount, 10); break;
        }

        for (Map.Entry<String, Consumer<int[]>> entry : consumers.entrySet()) {
            int[] arr = ArrayGenerator.cloneToIntArray(array);
            testSorter(entry.getValue(), arr, entry.getKey());
        }

    }

    public static void testSorter(Consumer<int[]> consumer, int[] array, String sorterName) {

        long start = System.currentTimeMillis();
        consumer.accept(array);
        long end = System.currentTimeMillis() - start;
        System.out.printf("%s | %d | %s\n", sorterName, end, "");


    }

    public static <T extends Comparable<T>> void testSorter(Consumer<T[]> consumer, T[] array, String sorterName) {

        long start = System.currentTimeMillis();
        consumer.accept(array);
        long end = System.currentTimeMillis() - start;
        System.out.printf("%s | %d | %s\n", sorterName, end, "");


    }
}
