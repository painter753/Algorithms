package algo.sorts.sort6;

import algo.sorts.Sorter;

import static algo.sorts.util.Utils.*;

public class InsertionSort<T extends Comparable<T>> implements Sorter<T> {
    public static void main(String[] args) {
        Integer[] array = new Integer[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }

        printArray(array);
        new InsertionSort<Integer>().sortAgain(array);
        printArray(array);

//        Integer[] clone = new Integer[array.length];
//        System.arraycopy(array, 0, clone, 0, array.length);
//
//
//        System.out.println("Simple Sort:");
//        printArray(array);
//        long start = System.currentTimeMillis();
//        new InsertionSort<Integer>().sortSimple(array);
//        System.out.println((System.currentTimeMillis() - start) + " ms");
//        printArray(array);
//
//        System.out.println("Advanced Sort:");
//        printArray(clone);
//        long start2 = System.currentTimeMillis();
//        new InsertionSort<Integer>().sortAdvanced(clone);
//        System.out.println((System.currentTimeMillis() - start2) + " ms");
//        printArray(clone);
    }


    @Override
    public void sort(T[] array) {
        sortSimple(array);
    }

    public void sortSimple(T[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j].compareTo(array[j - 1]) < 0) {
                    swap(j, j - 1 ,array);
                }
            }
        }
    }

    public void sortAdvanced(T[] array) {
        for (int i = 0; i < array.length; i++) {
            T value = array[i];
            int j = i - 1;
            for (j = i - 1; j >= 0 && array[j].compareTo(value) > 0; j--) {
                    array[j + 1] = array[j];
            }
            array[j + 1] = value;
        }
    }

    public void sortAgain(T[] array) {
        for (int i = 1; i < array.length; i++) {
            T elem = array[i];
            int j = i - 1;
            while (j >= 0 && array[j].compareTo(elem) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = elem;

        }
    }
}
