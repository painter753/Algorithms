package algo.sorts.sort6;

import algo.sorts.Sorter;

import static algo.sorts.util.Utils.*;

public class SelectionSort<T extends Comparable<T>> implements Sorter<T> {
    public static void main(String[] args) {
        Integer[] array = new Integer[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }


        System.out.println("Simple Sort:");
        printArray(array);
        long start = System.currentTimeMillis();
        new SelectionSort<Integer>().sortSimple(array);
        System.out.println((System.currentTimeMillis() - start) + " ms");
        printArray(array);
    }



    @Override
    public void sort(T[] array) {
        sortSimple(array);
    }

    public void sortSimple(T[] array) {
        for (int i = 0; i < array.length; i++) {
            int minInd = i;
            for (int j = i + 1; j < array.length ; j++) {
                if (array[j].compareTo(array[minInd]) < 0)
                    minInd = j;
            }
            swap(minInd, i, array);
        }
    }
}
